package com.example.pizzeria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PizzasFragment extends Fragment implements View.OnClickListener {

    private Button Bnapo;
    private Button BRoyale;
    private Button BqFromages;
    private Button BMontagn;
    private Button Bracl;
    private Button Bhawai;
    private Button Bpanna;
    private Button Btira;
    private Button BpizzaPerso ;
    private Button Breinitialiser;


    int nbNapo = 0;
    int nbRoyale = 0;
    int nbFromage = 0;
    int nbMonta = 0;
    int nbRaclette = 0;
    int nbHawai = 0;
    int nbPanna = 0;
    int nbTira = 0;
    int nbPizzaPerso = 0;

    public final static String CLE_SAVE_PERSO = "CLE_SAVE_PERSO";

    public final static String CLE_SAVE_NAPO = "CLE_SAVE_NAPO";
    public final static String CLE_SAVE_ROYALE = "CLE_SAVE_ROYALE";
    public final static String CLE_SAVE_FROMAGE = "CLE_SAVE_FROMAGE";
    public final static String CLE_SAVE_MONTA = "CLE_SAVE_MONTA";
    public final static String CLE_SAVE_RACLETTE = "CLE_SAVE_RACLETTE";
    public final static String CLE_SAVE_HAWAI = "CLE_SAVE_HAWAI";
    public final static String CLE_SAVE_PANNA = "CLE_SAVE_PANNA";
    public final static String CLE_SAVE_TIRA = "CLE_SAVE_TIRA";


    public PizzasFragment() {
        // constructeur vide obligatoire
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // a partir du xaml on va creer la vue et la mettre dans le contenaire
        View v = inflater.inflate(R.layout.fragment_pizzas, container, false);

        Bnapo = v.findViewById(R.id.Napolitaine);
        BRoyale = v.findViewById(R.id.Royale);
        BqFromages = v.findViewById(R.id.QuatreFromages);
        BMontagn = v.findViewById(R.id.Montagnarde);
        Bracl = v.findViewById(R.id.Raclette);
        Bhawai = v.findViewById(R.id.Hawai);
        Bpanna = v.findViewById(R.id.PannaCotta);
        Btira = v.findViewById(R.id.Tiramisu);
        BpizzaPerso = v.findViewById(R.id.PizzaPerso);
        Breinitialiser = v.findViewById(R.id.Reinitialiser);


        Bnapo.setOnClickListener(this);
        BRoyale.setOnClickListener(this);
        BqFromages.setOnClickListener(this);
        BMontagn.setOnClickListener(this);
        Bracl.setOnClickListener(this);
        Bhawai.setOnClickListener(this);
        Bpanna.setOnClickListener(this);
        Btira.setOnClickListener(this);
        BpizzaPerso.setOnClickListener(this);
        Breinitialiser.setOnClickListener(this);

        if (savedInstanceState != null) {
            nbNapo = savedInstanceState.getInt(CLE_SAVE_NAPO);
            nbRoyale = savedInstanceState.getInt(CLE_SAVE_ROYALE);
            nbFromage = savedInstanceState.getInt(CLE_SAVE_FROMAGE);
            nbMonta = savedInstanceState.getInt(CLE_SAVE_MONTA);
            nbRaclette = savedInstanceState.getInt(CLE_SAVE_RACLETTE);
            nbHawai = savedInstanceState.getInt(CLE_SAVE_HAWAI);
            nbPanna = savedInstanceState.getInt(CLE_SAVE_PANNA);
            nbTira = savedInstanceState.getInt(CLE_SAVE_TIRA);
            nbPizzaPerso = savedInstanceState.getInt(CLE_SAVE_PERSO);
        }

        Bnapo.setText("Napolitaine : " + nbNapo);
        BRoyale.setText("Royale : " + nbRoyale);
        BqFromages.setText("QuatreFromages : " + nbFromage);
        BMontagn.setText("Montagnarde : " + nbMonta);
        Bracl.setText("Raclette : " + nbRaclette);
        Bhawai.setText("Hawai : " + nbHawai);
        Bpanna.setText("PannaCotta : " + nbPanna);
        Btira.setText("Tiramisu : " + nbTira);
        BpizzaPerso.setText("Pizza personnalisée : " + nbPizzaPerso);

        return v;
    }

    @Override
    public void onClick(View v) {

        MainActivity activity = (MainActivity) getActivity();

        if (v.getId() == R.id.Napolitaine) {
            nbNapo++;
            Bnapo.setText("Napolitaine : " + nbNapo);
            if (activity != null) activity.envoyerCommandePlat(11);
        }

        if (v.getId() == R.id.Royale) {
            nbRoyale++;
            BRoyale.setText("Royale : " + nbRoyale);
            if (activity != null) activity.envoyerCommandePlat(5);
        }

        if (v.getId() == R.id.QuatreFromages) {
            nbFromage++;
            BqFromages.setText("QuatreFromages : " + nbFromage);
            if (activity != null) activity.envoyerCommandePlat(14);
        }

        if (v.getId() == R.id.Montagnarde) {
            nbMonta++;
            BMontagn.setText("Montagnarde : " + nbMonta);
            if (activity != null) activity.envoyerCommandePlat(18);
        }

        if (v.getId() == R.id.Raclette) {
            nbRaclette++;
            Bracl.setText("Raclette : " + nbRaclette);
            if (activity != null) activity.envoyerCommandePlat(20);
        }

        if (v.getId() == R.id.Hawai) {
            nbHawai++;
            Bhawai.setText("Hawai : " + nbHawai);
            if (activity != null) activity.envoyerCommandePlat(6);
        }

        if (v.getId() == R.id.PannaCotta) {
            nbPanna++;
            Bpanna.setText("PannaCotta : " + nbPanna);
            if (activity != null) activity.envoyerCommandePlat(94);
        }

        if (v.getId() == R.id.Tiramisu) {
            nbTira++;
            Btira.setText("Tiramisu : " + nbTira);
            if (activity != null) activity.envoyerCommandePlat(91);
        }

        if (v.getId() == R.id.PizzaPerso) {
            if (activity != null) {
                activity.afficherIngredientsFragment();
            }
        }
        // si le bouton reinitialiser est cliquer on remet tt les compteurs a 0
        if (v.getId() == R.id.Reinitialiser) {
            nbNapo = 0;
            nbRoyale = 0;
            nbFromage = 0;
            nbMonta = 0;
            nbRaclette = 0;
            nbHawai = 0;
            nbPanna = 0;
            nbTira = 0;
            nbPizzaPerso = 0;

            Bnapo.setText("Napolitaine : 0");
            BRoyale.setText("Royale : 0");
            BqFromages.setText("QuatreFromages : 0");
            BMontagn.setText("Montagnarde : 0");
            Bracl.setText("Raclette : 0");
            Bhawai.setText("Hawai : 0");
            Bpanna.setText("PannaCotta : 0");
            Btira.setText("Tiramisu : 0");
            BpizzaPerso.setText("Pizza personnalisée : 0");
        }
        // permettra de reinitialiser le label en haut de l'ecran, via le mainActivity
        activity.reinitialiserLabel();
    }

    public void incrementerPizzaPersonnalisee() {
        nbPizzaPerso++;
        BpizzaPerso.setText("Pizza personnalisée : " + nbPizzaPerso);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLE_SAVE_NAPO, nbNapo);
        outState.putInt(CLE_SAVE_ROYALE, nbRoyale);
        outState.putInt(CLE_SAVE_FROMAGE, nbFromage);
        outState.putInt(CLE_SAVE_MONTA, nbMonta);
        outState.putInt(CLE_SAVE_RACLETTE, nbRaclette);
        outState.putInt(CLE_SAVE_HAWAI, nbHawai);
        outState.putInt(CLE_SAVE_PANNA, nbPanna);
        outState.putInt(CLE_SAVE_TIRA, nbTira);
        outState.putInt(CLE_SAVE_PERSO, nbPizzaPerso);
    }
}