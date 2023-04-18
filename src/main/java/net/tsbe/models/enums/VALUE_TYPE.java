package net.tsbe.models.enums;

public enum VALUE_TYPE {
    INTEGER {
        @Override
        public String toString() {
            return "int";
        }
    },
    BOOLEAN {
        @Override
        public String toString() {
            return "bool";
        }
    },
    VOID {
        @Override
        public String toString() {
            return "void";
        }
    },
    INVALID,
    OTHER
}
