package com.gmail.alexei28.ocpj8.myenum;

public enum ValuesEnum {
    HIGH(1), MEDIUTM(2), LOW(3); // sort order

    private final int value;

    private ValuesEnum(int value) {
        this.value = value;
    }
}
