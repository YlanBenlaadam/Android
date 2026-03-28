package com.example.pizzeria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

public class IngredientsFragment extends Fragment implements View.OnClickListener {

    private Button Bmozzarella;
    private Button Bgorgonzola;
    private Button Bancchois;
    private Button Bcapres;
    private Button Bolives;
    private Button Bartichauts;
    private Button BjambonCru;
    private Button BjambonCuit;
    private Button Bvalider;
    //permettra de save les ingredients app rotation
    private static final String CLE_SAVE_INGREDIENTS = "CLE_SAVE_INGREDIENTS";


    private ArrayList<String> ingredientsSelectionnes = new ArrayList<>();

    public IngredientsFragment() {
        // constructeur vide obligatoire
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_ingredients, container, false);

        Bmozzarella = v.findViewById(R.id.Mozzarella);
        Bgorgonzola = v.findViewById(R.id.Gorgonzola);
        Bancchois = v.findViewById(R.id.Anchois);
        Bcapres = v.findViewById(R.id.Capres);
        Bolives = v.findViewById(R.id.Olives);
        Bartichauts = v.findViewById(R.id.Artichauts);
        BjambonCru = v.findViewById(R.id.JambonCru);
        BjambonCuit = v.findViewById(R.id.JambonCuit);
        Bvalider = v.findViewById(R.id.Valider);

        Bmozzarella.setOnClickListener(this);
        Bgorgonzola.setOnClickListener(this);
        Bancchois.setOnClickListener(this);
        Bcapres.setOnClickListener(this);
        Bolives.setOnClickListener(this);
        Bartichauts.setOnClickListener(this);
        BjambonCru.setOnClickListener(this);
        BjambonCuit.setOnClickListener(this);
        Bvalider.setOnClickListener(this);

        // on verifia que ce n'est pas le premier lancement du fagement
        if (savedInstanceState != null) {
            ingredientsSelectionnes = savedInstanceState.getStringArrayList(CLE_SAVE_INGREDIENTS);
            // on verifie si l'ingredient etait present dans les ingredients selectionner
            if (ingredientsSelectionnes.contains("mozzarella")) {
                Bmozzarella.setText("MOZZARELLA ✓");// si c le cas on maj son btn99
            }
            if (ingredientsSelectionnes.contains("gorgonzola")) {
                Bgorgonzola.setText("GORGONZOLA ✓");
            }
            if (ingredientsSelectionnes.contains("anchois")) {
                Bancchois.setText("ANCHOIS ✓");
            }
            if (ingredientsSelectionnes.contains("capres")) {
                Bcapres.setText("CAPRES ✓");
            }
            if (ingredientsSelectionnes.contains("olives")) {
                Bolives.setText("OLIVES ✓");
            }
            if (ingredientsSelectionnes.contains("artichauts")) {
                Bartichauts.setText("ARTICHAUTS ✓");
            }
            if (ingredientsSelectionnes.contains("jambon cru")) {
                BjambonCru.setText("JAMBON CRU ✓");
            }
            if (ingredientsSelectionnes.contains("jambon cuit")) {
                BjambonCuit.setText("JAMBON CUIT ✓");
            }
        }


        return v;
    }

    public void onClick(View v) {
    /* ici on ajoute une verif supplementaire, pr eviter les doublons
        le clique fonctionne seulement si l'ingredient n'a pas deja ete selectionner
         if (!ingredientsSelectionnes.contains("ingredient"))
     */
        if (v.getId() == R.id.Mozzarella) {
            if (!ingredientsSelectionnes.contains("mozzarella")) {
                ingredientsSelectionnes.add("mozzarella");
                Bmozzarella.setText("MOZZARELLA ✓");
            }
        }


        if (v.getId() == R.id.Gorgonzola) {
            if (!ingredientsSelectionnes.contains("gorgonzola")) {
                ingredientsSelectionnes.add("gorgonzola");
                Bgorgonzola.setText("GORGONZOLA ✓");
            }
        }

        if (v.getId() == R.id.Anchois) {
            if (!ingredientsSelectionnes.contains("anchois")) {
                ingredientsSelectionnes.add("anchois");
                Bancchois.setText("ANCHOIS ✓");
            }
        }

        if (v.getId() == R.id.Capres) {
            if (!ingredientsSelectionnes.contains("capres")) {
                ingredientsSelectionnes.add("capres");
                Bcapres.setText("CAPRES ✓");
            }
        }

        if (v.getId() == R.id.Olives) {
            if (!ingredientsSelectionnes.contains("olives")) {
                ingredientsSelectionnes.add("olives");
                Bolives.setText("OLIVES ✓");
            }
        }

        if (v.getId() == R.id.Artichauts) {
            if (!ingredientsSelectionnes.contains("artichauts")) {
                ingredientsSelectionnes.add("artichauts");
                Bartichauts.setText("ARTICHAUTS ✓");
            }
        }

        if (v.getId() == R.id.JambonCru) {
            if (!ingredientsSelectionnes.contains("jambon cru")) {
                ingredientsSelectionnes.add("jambon cru");
                BjambonCru.setText("JAMBON CRU ✓");
            }
        }

        if (v.getId() == R.id.JambonCuit) {
            if (!ingredientsSelectionnes.contains("jambon cuit")) {
                ingredientsSelectionnes.add("jambon cuit");
                BjambonCuit.setText("JAMBON CUIT ✓");
            }
        }


        if (v.getId() == R.id.Valider) {
            MainActivity activity = (MainActivity) getActivity();

            if (activity != null) {
                activity.validationPizzaPersonnalisee(ingredientsSelectionnes);
                activity.afficherPizzasFragment();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(CLE_SAVE_INGREDIENTS, ingredientsSelectionnes);
    }

}
