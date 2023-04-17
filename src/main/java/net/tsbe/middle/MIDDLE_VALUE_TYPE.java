package net.tsbe.middle;


import net.tsbe.middle.models.Symbol;

public enum MIDDLE_VALUE_TYPE {
    BYTE {
        @Override
        public String toString() {
            return "byte";
        }

        public Symbol toSymbol() {
            return Symbol.BYTE_SIZE;
        }
    },
    INT {
        @Override
        public String toString() {
            return "int";
        }

        public Symbol toSymbol() {
            return Symbol.INT_SIZE;
        }
    },
    ADDRESS {//sera utile pour les tableaux
        @Override
        public String toString() {
            return "address";
        }

        public Symbol toSymbol() {
            return Symbol.ADDRESS_SIZE;
        }
    },
    VOID {
        @Override
        public String toString() {
            return "void";
        }

        public Symbol toSymbol() {
            return Symbol.VOID_SIZE;
        }
    };

    public abstract Symbol toSymbol();
}
