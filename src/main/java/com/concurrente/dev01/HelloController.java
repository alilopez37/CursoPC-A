package com.concurrente.dev01;

import com.concurrente.dev01.models.Bienvenida;
import com.concurrente.dev01.models.BienvenidaRunnable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button btnRunnable;

    @FXML
    protected void onHelloButtonClick() {
       for (int i=1;i<=100;i++)
           new Bienvenida("Hilo"+i).start();
    }

    @FXML
    void btnRunnableOnMouseClicked(MouseEvent event) {
        BienvenidaRunnable hilo02 = new BienvenidaRunnable();
        Thread hilo02b = new Thread(hilo02);
        hilo02b.setName("Maincrafe - R");
        hilo02b.start();
    }
}