package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private String valeur;
    private TextView TnumTable;

    private PizzasFragment pizzasFragment;
    private IngredientsFragment ingredientsFragment;

    public final static String CLE_SAUVEGARDE_RESULTAT9 = "CLE_SAUVEGARDE_RESULTAT9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TnumTable = findViewById(R.id.textNumTable);

        Intent intent = getIntent();
        valeur = intent.getStringExtra(ChoixTableActivity.CLE_DONNEES);

        if (savedInstanceState != null) {
            valeur = savedInstanceState.getString(CLE_SAUVEGARDE_RESULTAT9);
        }

        TnumTable.setText("Table numéro " + valeur);

        // Premier lancement
        if (savedInstanceState == null) {
            pizzasFragment = new PizzasFragment();
            ingredientsFragment = new IngredientsFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, pizzasFragment, "PIZZAS")
                    .commit();
        }
        // Recréation après rotation
        else {
            pizzasFragment = (PizzasFragment) getSupportFragmentManager().findFragmentByTag("PIZZAS");
            ingredientsFragment = (IngredientsFragment) getSupportFragmentManager().findFragmentByTag("INGREDIENTS");
        }

        Log.i("Cycle", "MainActivity, Méthode onCreate");
    }

    // Commandes classiques
    public void envoyerCommandePlat(int codePlat) {
        monThread thread = new monThread(
                Integer.parseInt(valeur),
                codePlat,
                this,
                handler
        );
        thread.start();
    }

    // Afficher le fragment ingrédients
    public void afficherIngredientsFragment() {
        if (ingredientsFragment == null) {
            ingredientsFragment = new IngredientsFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, ingredientsFragment, "INGREDIENTS")
                .commit();
    }

    // Revenir au fragment pizzas existant
    public void afficherPizzasFragment() {
        if (pizzasFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, pizzasFragment, "PIZZAS")
                    .commit();
        }
    }

    // Validation de la pizza personnalisée
    public void validationPizzaPersonnalisee(ArrayList<String> ingredients) {
        if (pizzasFragment != null) {
            pizzasFragment.incrementerPizzaPersonnalisee();
        }

        String messageIngredients = "";

        for (int i = 0; i < ingredients.size(); i++) {
            messageIngredients += ingredients.get(i);

            if (i < ingredients.size() - 1) {
                messageIngredients += " + ";
            }
        }

        envoyerCommandePersonnalisee(messageIngredients);
    }

    // Envoi de la commande personnalisée avec le second constructeur de monThread
    public void envoyerCommandePersonnalisee(String ingredients) {
        String message = "";

        int numTable = Integer.parseInt(valeur);

        if (numTable < 10) {
            message += "0" + numTable;
        } else {
            message += numTable;
        }

        message += "50";
        message += ingredients; // on a bien la forme demander "nTable50ing1..."
        // on envoie la chaine au serveur via le thread
        monThread thread = new monThread(message, this, handler);
        thread.start();
    }

    public void reinitialiserLabel() {
        TnumTable.setText("Table numéro " + valeur);
    }

    // affiche la réponse du serveur dans un pop-up
    public void afficherMessage(String message) {
        // on crée le fragment pop-up avec le message
        MessageDialogFragment dialog = MessageDialogFragment.creer(message);

        // on affiche le pop-up
        // getSupportFragmentManager() = le gestionnaire de fragments de l'activité
        // "dialog_message" = un tag pour identifier ce pop-up (comme "PIZZAS" ou "INGREDIENTS")
        dialog.show(getSupportFragmentManager(), "dialog_message");
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CLE_SAUVEGARDE_RESULTAT9, valeur);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Cycle", "MainActivity, Méthode onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Cycle", "MainActivity, Méthode onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Cycle", "MainActivity, Méthode onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Cycle", "MainActivity, Méthode onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Cycle", "MainActivity, Méthode onDestroy");
    }
}