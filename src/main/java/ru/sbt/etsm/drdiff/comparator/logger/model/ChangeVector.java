package ru.sbt.etsm.drdiff.comparator.logger.model;

import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntry;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.sbt.etsm.drdiff.comparator.logger.file.TsmFileLogger.*;

/**
 * Created by sbt-morozov-kv on 06.09.2016.
 */
public class ChangeVector {

    private static final Pattern pattern = Pattern.compile("\\[(.*?)\\]");

    private final Deque<ChangeItem> vectorItems;

    public ChangeVector() {
        vectorItems = new LinkedList<>();
    }

    public ChangeVector(ChangeItem item) {
        vectorItems = new LinkedList<>();
        vectorItems.add(item);
    }

    private ChangeVector(Deque<ChangeItem> items) {
        vectorItems = items;
    }

    public void add(ChangeItem item) {
        vectorItems.add(item);
    }

    public boolean isEmpty() {
        return vectorItems.isEmpty();
    }

    public ChangeItem getHead() {
        return vectorItems.getFirst();
    }

    public ChangeVector getTail() {
        Deque<ChangeItem> clonedItems = (Deque) ((LinkedList) vectorItems).clone();
        clonedItems.removeFirst();

        return new ChangeVector(clonedItems);
    }

    private String findFirst(String header) {
        for (ChangeItem item : vectorItems) {
            String text = item.getText().replaceAll(PLACEHOLDER_TABS_N, "")
                    .replaceAll(PLACEHOLDER_TABS_N1, "")
                    .replaceAll(PLACEHOLDER_TABS_N2, "")
                    .replaceAll("\\[\\[", "[")
                    .replaceAll("]/", "/");

            if (text.startsWith(header)) {
                Matcher matcher = pattern.matcher(text);
                return matcher.find() ? matcher.group(1) : null;
            }
        }

        return null;
    }

    public ChangeEntry getEntry() {
        ChangeEntry result = new ChangeEntry();

        result.setActivator(findFirst("MenuItem"));

        String place = findFirst("Screen");
        if (place == null) {
            place = findFirst("Occurence");
            result.setType("Occurence");
        } else
            result.setType("Screen");
        result.setPlace(place);

        result.setRole(findFirst("MenuBar"));
        result.setChange(vectorItems.getLast().getText()
                .replace("/null", "")
                .replace(PLACEHOLDER_TABS_N, "")
                .replace(PLACEHOLDER_TABS_N1, "")
                .replace(PLACEHOLDER_TABS_N2, ""));

        return result;
    }

    public List<ChangeVector> split() {
        if (vectorItems.getLast().getChildCount() == 0)
            return Collections.singletonList(this);
        else {
            List<ChangeVector> split = new ArrayList<>();
            List<ChangeVector> result = new ArrayList<>();

            for (ChangeItem item : vectorItems.getLast().getChildItems()) {
                Deque<ChangeItem> clonedItems = (Deque) ((LinkedList) vectorItems).clone();
                clonedItems.add(item);

                split.add(new ChangeVector(clonedItems));
            }

            for (ChangeVector vector : split) {
                List<ChangeVector> splitResult = vector.split();
                if (splitResult != null)
                    result.addAll(splitResult);
            }

            return result;
        }
    }
}
