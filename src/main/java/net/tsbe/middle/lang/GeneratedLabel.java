package net.tsbe.middle.lang;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.models.GeneratorResult;

public class GeneratedLabel extends Label{

    final private int label;
    private static int lastLabel = 0;

    @Override
    public String toString() {
        return "L_"+label;
    }

    public GeneratedLabel() {
        label = lastLabel++;
    }
}
