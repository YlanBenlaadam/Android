package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoixTableActivity extends AppCompatActivity implements View.OnClickListener{
    public final static String CLE_DONNEES = "CLE_DONNEES";
private TextView textTableLabel ;
private EditText editTable;
private Button Bvalider ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.choix_table_activity);
        textTableLabel = findViewById(R.id.textTableLabel);
        editTable = findViewById(R.id.editTable);
        Bvalider = findViewById(R.id.btnValider);


        //associer des ecouteurs au boutons
        Bvalider.setOnClickListener(this);

        Log.i("Cycle","ChoixTableActivity, Méthode onCreate");


    }
    public void onClick(View v) {
        if(v.getId() == R.id.btnValider  ){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra(CLE_DONNEES, String.valueOf(editTable.getText()));
            startActivity(intent);
        }
    }

    @Override
    protected void onStart(){

        super.onStart();
        Log.i("Cycle","ChoixTableActivity, Méthode onStart");
    }

    @Override
    protected void  onResume(){

        super.onResume();
        Log.i("Cycle","ChoixTableActivity, Méthode onResume");
    }

    @Override
    protected void onPause(){

        super.onPause();
        Log.i("Cycle","ChoixTableActivity, Méthode onPause");
    }

    @Override
    protected void onStop(){

        super.onStop();
        Log.i("Cycle","ChoixTableActivity, Méthode onStop");
    }

    @Override
    protected void onDestroy(){

        super.onDestroy();
        Log.i("Cycle","ChoixTableActivity, Méthode onDestroy");
    }

}