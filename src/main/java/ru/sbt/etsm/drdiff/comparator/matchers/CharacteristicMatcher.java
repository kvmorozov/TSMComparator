package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.generated.Characteristic;
import ru.sbt.etsm.drdiff.generated.Option;

import java.util.List;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class CharacteristicMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        if (obj instanceof Characteristic) {
            Characteristic characteristic = (Characteristic) obj;

            String critId = characteristic.getCritId();

            if (critId == null)
                return null;
            else if (isRadio(characteristic)) {
                List radioCollection = ownCollection == null ? contextCollection : ownCollection;

                if (radioCollection == null)
                    throw new AssertionError();

                int radioBeginIndex = -1;
                for (int index = 0; index < radioCollection.size(); index++) {
                    Characteristic charItem = (Characteristic) radioCollection.get(index);
                    String charItemCritId = charItem.getCritId();

                    if (charItemCritId == null)
                        continue;

                    if (charItemCritId.equals(critId)) {
                        radioBeginIndex = index;
                        break;
                    }
                }

                if (radioBeginIndex >= 0)
                    return critId + "_" + (radioCollection.indexOf(characteristic) - radioBeginIndex + 1);
                else
                    return critId + "/" + characteristic.getCaptionText() + "/" + characteristic.getOperator();
            } else
                return critId + "/" + characteristic.getCaptionText() + "/" + characteristic.getOperator();
        } else
            return null;
    }


    private boolean isRadio(Characteristic characteristic) {
        for (Option option : characteristic.getOptions())
            if (option.getName().equals("Radio") && option.getSet().equals("Yes"))
                return true;

        return false;
    }
}
