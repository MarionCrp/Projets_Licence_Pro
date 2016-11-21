package com.example.marion.tabatatimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.marion.tabatatimer.Program.Index;
import com.example.marion.tabatatimer.Program.New;
import com.example.marion.tabatatimer.data.Program;
import com.example.marion.tabatatimer.data.ProgramDAO;

public class MainActivity extends AppCompatActivity {

    public final static int MAIN_ACTIVITY_REQUEST = 1;
    public final static int NEW_ACTIVITY_REQUEST = 2;
    public final static int INDEX_ACTIVITY_REQUEST = 3;
    public Program program = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView test = (TextView)findViewById(R.id.textView2);
        ProgramDAO programDao = new ProgramDAO();
        System.out.println(programDao.selectAll().size());
        if(programDao.count() > 0){
            test.setText(String.valueOf(programDao.selectFirstProgram().getTitle()));
        }

        // Récupération de l'id du programme
        String program_id;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                program_id= null;
            } else {
                program_id= extras.getString("PROGRAM_ID");
            }
        } else {
            program_id= (String) savedInstanceState.getSerializable("PROGRAM_ID");
        }
        ProgramDAO programDAO = new ProgramDAO();
        if(program_id != null){
            program = programDAO.findById(Integer.parseInt(program_id));

            if(program != null){
                System.out.println(program);
                //Test d'affichage d'un timer.
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished) {
                        TextView chronometer = (TextView) findViewById(R.id.chronometer);
                        chronometer.setText(Long.toString(millisUntilFinished / 1000));
                    }

                    public void onFinish() {
                        TextView chronometer = (TextView) findViewById(R.id.chronometer);
                        chronometer.setText("done!");
                    }
                }.start();
            }
        }
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
