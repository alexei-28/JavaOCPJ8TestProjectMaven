package com.gmail.alexei28.ocpj8.anonymous;

@FunctionalInterface
public interface StatusListener {

    void statusChange(ClientStatus clientStatus);
}
