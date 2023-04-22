package net.tsbe.middle;

import net.tsbe.models.enums.VALUE_TYPE;

public class Register {

    final private int id;
    final private MIDDLE_VALUE_TYPE type;
    static private int lastRegisterId = 0;

    private int memoryStorageOffset;

    public Register(MIDDLE_VALUE_TYPE type){
        this.type = type;
        this.id = lastRegisterId++;
        this.memoryStorageOffset = -1;
    }

    public Register(MIDDLE_VALUE_TYPE type, int memOffset){
        this.type = type;
        this.id = lastRegisterId++;
        this.memoryStorageOffset = memOffset;
    }

    public int getMemoryStorageOffset() {
        return memoryStorageOffset;
    }

    public void setMemoryStorageOffset(int memoryStorageOffset) {
        this.memoryStorageOffset = memoryStorageOffset;
    }

    public int getRegisterId(){
        return id;
    }

    @Override
    public String toString() {
        return "reg"+id;
    }

    public MIDDLE_VALUE_TYPE getType() {
        return type;
    }
}
