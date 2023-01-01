package com.fawrysystem.app.Provider;

public class Component {
    protected char type;
    protected String label;

    public Component(char type, String label) {
        this.type = type;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public char getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Component{" +
                "type=" + type +
                ", label='" + label + '\'' +
                '}';
    }
}
