package com.example.pizzeria;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class monThread extends Thread {

    private int numTable;
    private int numPlat;
    private String messageComplet;
    private TextView textView;
    private Handler handler;


    public monThread(int numTable, int numPlat, TextView textView, Handler handler) {
        this.numTable = numTable;
        this.numPlat = numPlat;
        this.textView = textView;
        this.handler = handler;
        this.messageComplet = null ;
    }

    // Constructeur commande personnalisée
    public monThread(String messageComplet, TextView textView, Handler handler) {
        this.messageComplet = messageComplet;
        this.textView = textView;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("chadok.info", 9874);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "";

            // Cas 1 : pizza personnalisée
            if (messageComplet != null) {
                message = messageComplet;
            }
            // Cas 2 : pizza normale / dessert
            else {
                if (numTable < 10) {
                    message = message + "0" + numTable;
                } else {
                    message = message + numTable;
                }

                if (numPlat < 10) {
                    message = message + "0" + numPlat;
                } else {
                    message = message + numPlat;
                }
            }

            /// On envoie au serveur la table et le plat
            writer.println(message);

            /// ici on lit la reponse du serveur
            String reponse1 = reader.readLine();

            // on passe par un ha ndler car notre thread ne peut pas edit le textView
            handler.post(new Runnable() {
                @Override
                public void run() {
                    // permettra d'afficher la reponse du serveur
                    textView.setText(reponse1);
                }
            });

            String reponse2 = reader.readLine();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(reponse2);
                }
            });

            socket.close();

        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText("Erreur de connexion");
                }
            });
        }
    }
}