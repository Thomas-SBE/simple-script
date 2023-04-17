package net.tsbe.middle;

import net.tsbe.middle.lang.Label;
import net.tsbe.middle.lang.SystemCallCommand;
import net.tsbe.middle.lang.WriteRegisterCommand;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.Frame;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReservedFrames {

    public static String[] reservedNamespaces = {
            "print"
    };

    public static boolean isReservedFunctionName(String check){
        return Arrays.asList(reservedNamespaces).contains(check);
    }

    public static Frame getFrameFromCodedName(String name){
        return switch (name){
            case "PRINT_INT" -> PRINT_INT;
            case "PRINT_BYTE" -> PRINT_BYTE;
            default -> null;
        };
    }

    public static List<Command> getCodeFromCodedName(String name){
        return switch (name){
            case "PRINT_INT" -> List.of(PRINT_INT_CODE);
            case "PRINT_BYTE" -> List.of(PRINT_BYTE_CODE);
            default -> null;
        };
    }

    public static Frame PRINT_INT =
            new Frame(
                    Label.named("printIntegerValueEntry"),
                    Label.named("printIntegerValueExit"),
                    Collections.singletonList(new Register(MIDDLE_VALUE_TYPE.INT)),
                    new LinkedList<>()).reserved();

    public static Command[] PRINT_INT_CODE = {
            new SystemCallCommand(SystemCallCommand.CALL_TYPE.PRINT_INT)
    };

    public static Frame PRINT_BYTE =
            new Frame(
                    Label.named("printByteValueEntry"),
                    Label.named("printByteValueExit"),
                    Collections.singletonList(new Register(MIDDLE_VALUE_TYPE.BYTE)),
                    new LinkedList<>()).reserved();

    public static Command[] PRINT_BYTE_CODE = {
        new SystemCallCommand(SystemCallCommand.CALL_TYPE.PRINT_BYTE)
    };

}
