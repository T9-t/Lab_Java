import java.util.*;

public class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.lastName.compareTo(o2.lastName);
    }
}
