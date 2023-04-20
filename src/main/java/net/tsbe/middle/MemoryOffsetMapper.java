package net.tsbe.middle;

public class MemoryOffsetMapper {

    private static int CURRENT_MEM_OFFSET = 0;

    public static int allocate(MIDDLE_VALUE_TYPE type, int amount_of_values){
        int pointer = CURRENT_MEM_OFFSET;
        // SHIFTING POINTER
        int val_size = switch (type){
            case INT -> 4;
            case BYTE -> 4;
            case ADDRESS -> 1;
            default -> 1;
        };
        CURRENT_MEM_OFFSET += val_size * amount_of_values;
        return pointer;
    }

    public static int allocate(MIDDLE_VALUE_TYPE type){ return allocate(type, 1); }

}
