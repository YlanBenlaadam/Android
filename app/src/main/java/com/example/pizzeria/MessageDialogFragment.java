package com.example.pizzeria;


// DialogFragment = un fragment qui s'affiche sous forme de pop-up
import androidx.fragment.app.DialogFragment;

// AlertDialog = la boîte de dialogue avec titre, message, bouton
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;


public class MessageDialogFragment extends DialogFragment {
    // clé pour passer le message au fragment via un Bundle
    private static final String CLE_MESSAGE = "CLE_MESSAGE";

    // constructeur vide
    public MessageDialogFragment() {
    }

    /*
     méthode statique pour créer le fragment avec un message
     car si on passe par un constructeur des que on tourne la tablete on aurais perdu message
     */
    public static MessageDialogFragment creer(String message) {
        MessageDialogFragment fragment = new MessageDialogFragment();
        // on stocke le message dans un Bundle
        Bundle args = new Bundle();
        args.putString(CLE_MESSAGE, message);
        // on rattache le bundle au fragement pour le reutilisrr
        fragment.setArguments(args);
        return fragment;
    }

    // cette méthode est appelée quand Android crée le pop-up
    // elle remplace onCreateView qu'on utilise pour les fragments normaux
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // on récupère le message depuis le Bundle
        String message = getArguments().getString(CLE_MESSAGE);

        // AlertDialog.Builder = outil pour construire un pop-up étape par étape
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // on définit le titre du pop-up
        builder.setTitle("Réponse du serveur");

        // on définit le contenu du pop-up
        builder.setMessage(message);

        // on ajoute un bouton "OK" pour fermer le pop-up
        // null = pas d'action spéciale quand on clique, ça ferme juste le pop-up
        builder.setPositiveButton("OK", null);

        // on construit et retourne le Dialog final
        return builder.create();
    }
}
