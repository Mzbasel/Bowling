public enum Scoring {

    STRIKE(10, 'X'),
    SPARE(10, '/'),
    MISS(0, '-');

    public final int value;
    public final char type;

    private Scoring(int value, char type) {
        this.value = value;
        this.type = type;
    }
}
