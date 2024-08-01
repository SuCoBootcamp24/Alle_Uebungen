package de.supercode.personen;

public enum Rolle {
    STARGAST(1),
    SPEAKER(2),
    ORGANIZER(3),
    ZUSCHAUER(4),
    VOLUNTEER(5);

    private final int rank;

    Rolle(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
