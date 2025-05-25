package com.gmail.alexei28.ocpj8.myabstractclass;

public abstract class AbstractCar {
    private final int result;

    protected AbstractCar() {
        this.result = 100;
    }

    public abstract int someAbstractMethod();

    public int getResult() {
        return result;
    }
}
