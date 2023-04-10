package net.tsbe.middle.models;

import java.util.List;

public class GeneratorResult {

    List<String> lines;
    String exp;

    public GeneratorResult(List<String> lines) {
        this.lines = lines;
    }

    public GeneratorResult(String exp) {
        this.exp = exp;
    }

    public GeneratorResult(List<String> lines, String exp) {
        this.exp = exp;
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public String getExp() {
        return exp;
    }
}
