package com.concurrente.dev01.models;

import java.util.Observable;
import java.util.Random;

public class Pelota extends Observable implements Runnable{
    private String name;
    private Posicion pos;
    private String color;
    private int tam;
    private int distanciaX;
    private int distanciaY;
    private Random random;
    private boolean status = true;

    public Pelota(String name, String color, int tam) {
        this.name = name;
        this.color = color;
        this.tam = tam;
        random = new Random(System.currentTimeMillis());
        pos = new Posicion();

    }

    public String getName() {
        return name;
    }

    public Posicion getPos() {
        return pos;
    }

    public String getColor() {
        return color;
    }

    public int getTam() {
        return tam;
    }

    public void setPosicion(){

        pos.setX(random.nextInt(500));
        pos.setY(random.nextInt(400));
        distanciaX = 10;
        distanciaY = 10;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
    @Override
    public void run() {
        while(status) {
            //Notificar cambio
            this.setChanged();
            this.notifyObservers(this.pos);
            //Dormir el hilo
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Realizar nuevos cálculos
            pos.setX(pos.getX() + distanciaX);
            pos.setY(pos.getY() + distanciaY);
            System.out.println(pos.getX()+":"+pos.getY());

            if (pos.getX() >= 590)
                distanciaX *= -1;
            if (pos.getX() < 10)
                distanciaX *= -1;
            if (pos.getY() < 10)
                distanciaY *= -1;
            if (pos.getY() >= 490)
                distanciaY *= -1;
        }
        System.out.println("GoodBay");
    }
}
