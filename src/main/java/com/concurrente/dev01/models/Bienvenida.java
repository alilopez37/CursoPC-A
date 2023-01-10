package com.concurrente.dev01.models;

import java.util.concurrent.ThreadLocalRandom;

public class Bienvenida extends Thread{
    public Bienvenida(){
        super();
    }
    public Bienvenida(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(401)+100L);
        } catch (InterruptedException e) {}
        System.out.println("T - Hola mundo desde "+ Thread.currentThread().getName());
    }
}
