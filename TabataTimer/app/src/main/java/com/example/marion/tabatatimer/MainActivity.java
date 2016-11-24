package com.example.marion.tabatatimer;

import android.content.Intent;
import android.graphics.Color;
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
    public boolean work_session;
    public boolean rest_session;
    public int nb_cycle_done;
    public final String WORK_COLOR = "#b30000";
    public final String REST_COLOR = "#008000";
    public final String ANNOUNCEMENT_COLOR = "#993366";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView test = (TextView) findViewById(R.id.textView2);
        ProgramDAO programDao = new ProgramDAO();
        if (programDao.count() > 0) {
            test.setText(String.valueOf(programDao.selectFirstProgram().getTitle()));
        }
        // Récupération de l'id du programme
        String program_id;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                program_id = null;
            } else {
                program_id = extras.getString("PROGRAM_ID");
            }
        } else {
            program_id = (String) savedInstanceState.getSerializable("PROGRAM_ID");
        }
        ProgramDAO programDAO = new ProgramDAO();

        // Affichage du chrono si programme choisi :
        if (program_id != null) {

            program = programDAO.findById(Integer.parseInt(program_id));

            if (program != null) {
                work_session = true;
                rest_session = false;
                nb_cycle_done = 1;
                TextView annoucement = (TextView) findViewById(R.id.announcement);
                annoucement.setText("WORK TIME");
                setChrono();
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

    public void setChrono() {
        if (!tabata_is_finished(program)){
            TextView cycles_result = (TextView) findViewById(R.id.cycles_result);
            cycles_result.setText(Integer.toString(nb_cycle_done) + "/" + Integer.toString(program.getNb_of_cycle()));
            if (work_session == true) {
                CountDownTimer countDownTimer = new CountDownTimer((program.getWork_time()) * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        TextView chrono = (TextView) findViewById(R.id.chrono);
                        chrono.setText(Long.toString(millisUntilFinished / 1000));
                        chrono.setTextColor(Color.parseColor(WORK_COLOR));
                    }
                    public void onFinish() {
                        TextView announcement = (TextView) findViewById(R.id.announcement);
                        announcement.setText("REST TIME");
                        announcement.setTextColor(Color.parseColor(REST_COLOR));
                        work_session = false;
                        setChrono();
                    }
                }.start();
            } else {
                CountDownTimer countDownTimer = new CountDownTimer((program.getRest_time()) * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        TextView chrono = (TextView) findViewById(R.id.chrono);
                        chrono.setText(Long.toString(millisUntilFinished / 1000));
                        chrono.setTextColor(Color.parseColor(REST_COLOR));
                    }
                    public void onFinish() {
                        TextView announcement = (TextView) findViewById(R.id.announcement);
                        work_session = true;
                        nb_cycle_done++;
                        if(tabata_is_finished(program)){
                            TextView chrono = (TextView) findViewById(R.id.chrono);
                            announcement.setText("");
                            chrono.setText("GOOD JOB !");
                            chrono.setTextColor(Color.parseColor(ANNOUNCEMENT_COLOR));
                        } else {
                            announcement.setText("WORK TIME");
                            announcement.setTextColor(Color.parseColor(WORK_COLOR));
                        }
                        setChrono();
                    }
                }.start();
            }
        }
    }

    public boolean tabata_is_finished(Program program) {
        return program.getNb_of_cycle() < nb_cycle_done;
    }
}
