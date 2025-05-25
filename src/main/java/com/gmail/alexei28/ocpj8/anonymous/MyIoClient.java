package com.gmail.alexei28.ocpj8.anonymous;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyIoClient {

    public MyIoClient(ClientListener clientListener) {
        System.out.println("clientListener = " + clientListener);
        clientListener.addClientStatusListener(new StatusListener() {
            @Override
            public void statusChange(ClientStatus clientStatus) {
                if (clientStatus.equals(ClientStatus.AUTHORIZED)) {
                    new MyIoClientBuilder()
                            .subscribeProcessed(new MyInterfaceAnonymous() {
                                @Override
                                public void myInnerMethod(String jsonString) {
                                    try {
                                        Person person = new ObjectMapper().readValue(jsonString, Person.class);
                                        System.out.println("person = " + person);
                                    } catch (JsonProcessingException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }).build();
                }
            }
        });
    }
}
