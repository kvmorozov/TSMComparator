package ru.sbt.etsm.drdiff.comparator.logger.file;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by sbt-morozov-kv on 07.09.2016.
 */
public class ExcelGenerator {

    private final List<ChangeEntry> entries;
    private XSSFWorkbook workbook;

    private CellStyle cellStyle;

    public ExcelGenerator(List<ChangeEntry> entries) {
        System.setProperty("org.apache.poi.util.POILogger", SystemOutLogger.class.getName());

        this.entries = entries;
    }

    protected Workbook generate() {
        workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("Data");

        for (int index = 0; index < entries.size(); index++) {
            createRow(sheet1, entries.get(index), index);
        }

        for (int colNum = 0; colNum < 5; colNum++) {
            mergeCellsInColumns(sheet1, colNum);
            sheet1.autoSizeColumn(colNum);
        }

        return workbook;
    }

    private void mergeCellsInColumns(Sheet sheet, int colNum) {
        String prevValue = "", currValue;
        int startBlock = 0;

        for (int index = 0; index < entries.size(); index++) {
            currValue = sheet.getRow(index).getCell(colNum).getStringCellValue();
            if (!currValue.equals(prevValue)) {
                if (index - startBlock >= 2) {
                    sheet.addMergedRegion(new CellRangeAddress(startBlock, index - 1, colNum, colNum));
                    prevValue = currValue;
                    startBlock = index;
                } else if (index - startBlock == 1 || index == 0) {
                    prevValue = currValue;
                    startBlock = index;
                }
            }
        }

        if (startBlock < entries.size() - 1)
            sheet.addMergedRegion(new CellRangeAddress(startBlock, entries.size() - 1, colNum, colNum));
    }

    private void createRow(Sheet sheet, ChangeEntry entry, int rowNumber) {
        Row row = sheet.createRow((short) rowNumber);

        createCell(row, 0, entry.getPlace());
        createCell(row, 1, entry.getChange());
        createCell(row, 2, entry.getActivator());
        createCell(row, 3, entry.getRole());
        createCell(row, 4, entry.getType());
    }

    private void createCell(Row row, int colNum, String value) {
        Cell cell = row.createCell(colNum);
        cell.setCellStyle(getCellStyle());
        cell.setCellValue(value);
    }

    public File generateFile() {
        try {
            File tempFile = File.createTempFile("report_xls", ".xlsx");

            try (FileOutputStream fileOut = new FileOutputStream(tempFile)) {
                generate().write(fileOut);
            }

            return tempFile;
        } catch (IOException e) {
            return null;
        }
    }

    private CellStyle getCellStyle() {
        if (cellStyle == null) {
            cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

            cellStyle.setWrapText(true);
        }

        return cellStyle;
    }
}
