package de.supercode;

import java.util.LinkedList;
import java.util.ListIterator;

public class CollapseDuplicates {

    public static void collapseDuplicates(LinkedList<Integer> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        ListIterator<Integer> iterator = list.listIterator();
        Integer previous = iterator.next();

        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current.equals(previous)) {
                iterator.remove();
            } else {
                previous = current;
            }
        }
    }

}
