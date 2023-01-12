package com.concurrente.dev01;

import com.concurrente.dev01.models.Pelota;
import com.concurrente.dev01.models.Posicion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Button btnCrear;
    @FXML
    private Button btnDetener;

    @FXML
    private Button btnSalir;

    @FXML
    private Circle pelota;
    private Pelota pelotita;

    @FXML
    void btnCrearOnMouse(MouseEvent event) {
        pelotita = new Pelota("P1", "Blue", 10);
        pelotita.addObserver(this);
        pelotita.setPosicion();
        Thread hilo01 = new Thread(pelotita);
        hilo01.setDaemon(true);
        hilo01.start();
    }

    @FXML
    void btnDetener(MouseEvent event) {
        pelotita.setStatus(false);
    }
    @FXML
    void btnSalirOnMouse(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void update(Observable o, Object arg) {
        Posicion pos = (Posicion)arg;

        pelota.setLayoutX (pos.getX());
        pelota.setLayoutY (pos.getY());
    }
}
