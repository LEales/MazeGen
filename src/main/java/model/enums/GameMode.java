package model.enums;

public enum GameMode {
    CAMPAIGN("11"), RANDOMIZE("Random"), CUSTOM("Custom");

    private final String mode;
    GameMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
