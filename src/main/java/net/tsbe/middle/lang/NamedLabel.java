package net.tsbe.middle.lang;

public class NamedLabel extends Label{

    final private String label;

    @Override
    public String toString() {
        return label;
    }

    public NamedLabel(String label) {
        this.label = label;
    }
}
