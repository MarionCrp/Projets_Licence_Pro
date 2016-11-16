package com.example.marion.tabatatimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marion.tabatatimer.Program.Index;
import com.example.marion.tabatatimer.Program.New;

public class MainActivity extends AppCompatActivity {

    public final static int NEW_ACTIVITY_REQUEST = 1;
    public final static int INDEX_ACTIVITY_REQUEST = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test d'affichage d'un timer.
       /* new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished) {
                TextView chronometer = (TextView) findViewById(R.id.chronometer);
                chronometer.setText(Long.toString(millisUntilFinished / 1000));

            }

            public void onFinish() {
               TextView chronometer = (TextView) findViewById(R.id.chronometer);
                chronometer.setText("done!");
            }
        }.start();*/
    }

    // Bouton pour créer un nouveau programme.
    public void onNew(View view){

        Intent intent = new Intent(this, New.class);
        /*intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, NEW_ACTIVITY_REQUEST);*/
        startActivity(intent);
    }

    // Bouton pour avoir accès à la liste des programmes.
    public void onIndex(View view){
        Intent intent = new Intent(this, Index.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, INDEX_ACTIVITY_REQUEST);
    }

    public void onCancel(View view){
        finish();
    }
}
