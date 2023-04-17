package net.tsbe.middle.lang;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleLangVisitor;

import java.util.LinkedList;
import java.util.List;

public class SystemCallCommand extends Command {

    public enum CALL_TYPE {
        PRINT_INT { public int toCoded(){ return 1; } },
        PRINT_BYTE { public int toCoded(){ return 1; } };

        public abstract int toCoded();
    }

    private CALL_TYPE syscallType;

    public SystemCallCommand(CALL_TYPE syscallType) {
        this.syscallType = syscallType;
    }

    public CALL_TYPE getSyscallType() {
        return syscallType;
    }

    @Override
    public GeneratorResult accept(GeneratorFromIR visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
