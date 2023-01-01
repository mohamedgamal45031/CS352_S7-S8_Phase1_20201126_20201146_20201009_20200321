package com.fawrysystem.app.Provider;

public class ValuedComponent extends Component {
    private String value;

    public ValuedComponent(char type, String label, String value) {
        super(type, label);
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValuedComponent{" +
                "type=" + type +
                ", label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
