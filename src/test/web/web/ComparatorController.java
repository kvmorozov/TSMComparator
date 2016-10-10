package ru.sbt.etsm.drdiff.test.web;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.ILogger;
import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntry;
import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntryRepository;
import ru.sbt.etsm.drdiff.comparator.logger.file.ExcelGenerator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;
import ru.sbt.etsm.drdiff.generated.DesignReport;
import ru.sbt.etsm.drdiff.utils.jaxb.JaxbHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by sbt-morozov-kv on 06.09.2016.
 */

@SpringUI(path = "/compare")
@Theme("valo")
@Title("TSM comparator")
public class ComparatorController extends UI {

    private static final String TEST_DATA_1 = "xml/test/sberbank_TDS_HF00.xml";
    private static final String TEST_DATA_2 = "xml/test/sberbank_TDS_HF01.xml";

    private Table table;
    private final ProgressBar progress = new ProgressBar();

    @Autowired
    private ChangeEntryRepository repository;

    @Autowired
    private ILogger logger;

    private MenuBar toolBar = null;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        progress.setIndeterminate(true);
        progress.setVisible(false);

        setPollInterval(1000);

        createToolBar();

        table = new Table();
        table.setContainerDataSource(new BeanItemContainer<>(ChangeEntry.class));
        table.setVisibleColumns("place", "change", "activator", "role", "type");
        table.setWidth("100%");

        VerticalLayout mainLayout = new VerticalLayout(toolBar, table);

        setContent(mainLayout);
    }

    private void createToolBar() {
        this.toolBar = new MenuBar();

        this.toolBar.addItem("Сравнить", FontAwesome.APPLE, (MenuBar.Command) selectedItem -> {
            try {
                progress.setVisible(true);

                DesignReport oldReport = JaxbHelper.unmarshal(DesignReport.class, JaxbHelper.prepareDataFromResource(TEST_DATA_1, true), false);
                DesignReport newReport = JaxbHelper.unmarshal(DesignReport.class, JaxbHelper.prepareDataFromResource(TEST_DATA_2, true), false);

                ChangeTree changes = TsmComparator.compare(oldReport, newReport);

                assert (changes != null);

                try (ILogger _logger = logger) {
                    _logger.logReport(changes);
                } finally {
                    progress.setVisible(false);
                }

                table.setContainerDataSource(new BeanItemContainer(ChangeEntry.class, getTableData()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        this.toolBar.addItem("XLSX", FontAwesome.DOWNLOAD, (MenuBar.Command) selectedItem -> {
            File file = (new ExcelGenerator(getTableData())).generateFile();
            if (file != null) {
                TemporaryFileDownloadResource resource = null;
                try {
                    resource = new TemporaryFileDownloadResource(file.getName(), "application/vnd.ms-excel", file);
                    getPage().open(resource, null, false);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<ChangeEntry> getTableData() {
        return repository.findAll(ChangeEntryRepository.DEFAULT_SORT);
    }
}
