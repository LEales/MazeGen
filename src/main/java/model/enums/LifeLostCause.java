package model.enums;

public enum LifeLostCause {
    GHOST("YOU GOT KILLED BY A GHOST"),
    FORESTWALL("YOU HIT A TREE"),
    LAVAWALL("YOU GOT INCINERATED BY LAVA"),
    CLOUDWALL("YOU FELL FROM THE CLOUDS"),
    DESERTWALL("YOU GOT BURIED IN SAND"),
    SPACEWALL("YOU GOT SUCKED INTO THE VOID");


    String cause;

    LifeLostCause(String cause) {
        this.cause = cause;

    }

    @Override
    public String toString() {
        return cause;
    }
}
