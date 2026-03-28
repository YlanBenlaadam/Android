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
    private Handler handler;

    // on remplace le TextView par une référence à l'activité
    // pour pouvoir appeler afficherMessage()
    private MainActivity activity;


    public monThread(int numTable, int numPlat, MainActivity activity, Handler handler) {
        this.numTable = numTable;
        this.numPlat = numPlat;
        this.activity = activity;
        this.handler = handler;
        this.messageComplet = null ;
    }

    // constructeur pour les commandes personnalisées
    public monThread(String messageComplet, MainActivity activity, Handler handler) {
        this.messageComplet = messageComplet;
        this.activity = activity;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("chadok.info", 9874);

            //permet d'ecrire au serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            //permet de lire les réponses du serveurs
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

            // on envoie le message au serveur (numtable + numplat)
            writer.println(message);

            // on lit la réponse du serveur
            String reponse1 = reader.readLine();
            String reponse2 = reader.readLine();

            // on poste sur le thread principal pour afficher le pop-up
            handler.post(new Runnable() {
                @Override
                public void run() {
                    // on affiche les 2 réponses dans un seul pop-up
                    activity.afficherMessage(reponse1 + "\n" + reponse2);
                }
            });

            socket.close();

        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    // en cas d'erreur, on affiche aussi dans un pop-up
                    activity.afficherMessage("Erreur de connexion");
                }
            });
        }
    }
}