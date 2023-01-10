package com.concurrente.dev01.models;

public class BienvenidaRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("R - Hola desde " + Thread.currentThread().getName());
    }
}
