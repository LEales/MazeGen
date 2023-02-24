package model;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableIntegerProperty extends SimpleIntegerProperty implements Serializable {

    public SerializableIntegerProperty() {
        super();
    }

    public SerializableIntegerProperty(int initialValue) {
        super(initialValue);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeInt(get());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        set(s.readInt());
    }
}
