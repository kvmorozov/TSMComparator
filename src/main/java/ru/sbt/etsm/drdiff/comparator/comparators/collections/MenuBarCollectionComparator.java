package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.generated.MenuBar;

import java.util.stream.Collectors;

/**
 * Created by sbt-morozov-kv on 18.08.2016.
 */
public class MenuBarCollectionComparator extends CollectionComparator {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), oldCollection, null);

        oldCollection = oldCollection.stream().filter(item -> !((MenuBar) item).getName().equals("Test_1")).collect(Collectors.toList());
        newCollection = newCollection.stream().filter(item -> !((MenuBar) item).getName().equals("Test_1")).collect(Collectors.toList());

        return super.compare(descObject);
    }
}
