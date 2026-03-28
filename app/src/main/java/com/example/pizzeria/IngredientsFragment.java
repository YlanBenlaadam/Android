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

        return v;
    }

    public void onClick(View v) {

        if (v.getId() == R.id.Mozzarella) {
            ingredientsSelectionnes.add("mozzarella");
            Bmozzarella.setText("MOZZARELLA ✓");
        }

        if (v.getId() == R.id.Gorgonzola) {
            ingredientsSelectionnes.add("gorgonzola");
            Bgorgonzola.setText("GORGONZOLA ✓");
        }

        if (v.getId() == R.id.Anchois) {
            ingredientsSelectionnes.add("anchois");
            Bancchois.setText("ANCHOIS ✓");
        }

        if (v.getId() == R.id.Capres) {
            ingredientsSelectionnes.add("capres");
            Bcapres.setText("CAPRES ✓");
        }

        if (v.getId() == R.id.Olives) {
            ingredientsSelectionnes.add("olives");
            Bolives.setText("OLIVES ✓");
        }

        if (v.getId() == R.id.Artichauts) {
            ingredientsSelectionnes.add("artichauts");
            Bartichauts.setText("ARTICHAUTS ✓");
        }

        if (v.getId() == R.id.JambonCru) {
            ingredientsSelectionnes.add("jambon cru");
            BjambonCru.setText("JAMBON CRU ✓");
        }

        if (v.getId() == R.id.JambonCuit) {
            ingredientsSelectionnes.add("jambon cuit");
            BjambonCuit.setText("JAMBON CUIT ✓");
        }

        if (v.getId() == R.id.Valider) {
            MainActivity activity = (MainActivity) getActivity();

            if (activity != null) {
                activity.validationPizzaPersonnalisee(ingredientsSelectionnes);
                activity.afficherPizzasFragment();
            }
        }
    }
}
