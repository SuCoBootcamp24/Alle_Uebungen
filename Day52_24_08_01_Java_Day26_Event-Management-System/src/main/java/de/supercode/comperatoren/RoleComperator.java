package de.supercode.comperatoren;

import de.supercode.personen.Rolle;

import java.util.Comparator;

public class RoleComperator {

    public static Comparator<Rolle> rankComparator = (r1, r2) -> Integer.compare(r1.getRank(), r2.getRank());
}
