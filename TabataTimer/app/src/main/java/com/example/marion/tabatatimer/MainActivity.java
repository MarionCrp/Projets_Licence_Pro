package com.example.marion.tabatatimer;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
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
    public String program_id;
    public boolean work_session;
    public int nb_cycle_done;
    private Long max_time;
    public final String WORK_COLOR = "#b30000";
    public final String REST_COLOR = "#008000";
    public final String ANNOUNCEMENT_COLOR = "#993366";
    private static String STATE_MILLIUNTILFINISHED;
    private static String STATE_NB_OF_CYCLE_DONE;
    private static String STATE_IS_WORK_SESSION;
    private static String STATE_PROGRAM_ID;
    private static CountDownTimer countDownTimer;
    private long remaining_time;
    private boolean has_been_stop = false;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des données à sauvegarder.
        max_time = Long.valueOf(0);
        nb_cycle_done = 1;
        work_session = true;

        // Récupération de l'id du programme
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            program_id = null;
        } else {
            Button start_button = (Button) findViewById(R.id.start_button);
            Button pause_button = (Button) findViewById(R.id.pause_button);
            start_button.setVisibility(View.VISIBLE);
            pause_button.setVisibility(View.VISIBLE);
            program_id = extras.getString("PROGRAM_ID");
            program = program = ProgramDAO.findById(Integer.parseInt(program_id));
        }


        TextView annoucement = (TextView) findViewById(R.id.announcement);

        if (program != null && has_been_stop == false) {
            nb_cycle_done = 1;
            annoucement.setText("PRESS START TO BEGIN!");
        }

        // Affichage du chrono si programme choisi :
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

    public void onStart(View view){
        if (program_id != null) {
            program = ProgramDAO.findById(Integer.parseInt(program_id));
            setChrono(work_session, program.getWork_time());
            remaining_time = program.getWork_time();
        }

        if (savedInstanceState != null) {
            max_time = savedInstanceState.getLong(STATE_MILLIUNTILFINISHED);
            nb_cycle_done = savedInstanceState.getInt(STATE_NB_OF_CYCLE_DONE);
            work_session = savedInstanceState.getBoolean(STATE_IS_WORK_SESSION);
        }
        setChrono(work_session, remaining_time);
    }

    public void onPauseButton(View view){
        System.out.println(countDownTimer);
        countDownTimer.cancel();
        //System.out.println(remaining_time);
    }

    public void onCancel(View view){
        finish();
    }

    // setChrono(time, done_cycle, work_type)
    public void setChrono(boolean is_work_session, long saved_remaining_time) {
        if (!tabata_is_finished(program)){
            TextView cycles_result = (TextView) findViewById(R.id.cycles_result);
            cycles_result.setText(Integer.toString(nb_cycle_done) + "/" + Integer.toString(program.getNb_of_cycle()));
            if (work_session == true) {
                //max_time = Long.valueOf(program.getWork_time()) * 1000;

                countDownTimer = new CountDownTimer( saved_remaining_time * 1000 , 1) {
                    public void onTick(long millisUntilFinished) {
                        TextView chrono = (TextView) findViewById(R.id.chrono);
                        chrono.setText(Long.toString(millisUntilFinished / 1000) + "," + Long.toString(millisUntilFinished % 1000));
                        chrono.setTextColor(Color.parseColor(WORK_COLOR));
                        remaining_time = (millisUntilFinished / 1000) + (millisUntilFinished % 1000);
                    }
                    public void onFinish() {
                        TextView announcement = (TextView) findViewById(R.id.announcement);
                        announcement.setText("REST TIME");
                        announcement.setTextColor(Color.parseColor(REST_COLOR));
                        work_session = false;
                        setChrono(work_session, remaining_time);
                    }
                }.start();
            } else {
                max_time = Long.valueOf(program.getRest_time()) * 1000;
                countDownTimer = new CountDownTimer(max_time, 1) {
                    public void onTick(long millisUntilFinished) {
                        TextView chrono = (TextView) findViewById(R.id.chrono);
                        chrono.setText(Long.toString(millisUntilFinished / 1000) + "," + Long.toString(millisUntilFinished % 1000));
                        chrono.setTextColor(Color.parseColor(REST_COLOR));
                        remaining_time = (millisUntilFinished / 1000) + (millisUntilFinished % 1000);
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
                        setChrono(work_session, remaining_time);
                    }
                }.start();
            }
        }
    }


    //TODO ::: FAIRE FONCTION PAUSE
    public boolean tabata_is_finished(Program program) {
        return program.getNb_of_cycle() < nb_cycle_done;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong(STATE_MILLIUNTILFINISHED, max_time);
        savedInstanceState.putInt(STATE_NB_OF_CYCLE_DONE, nb_cycle_done);
        savedInstanceState.putBoolean(STATE_IS_WORK_SESSION, work_session);
        savedInstanceState.putString(STATE_PROGRAM_ID, program_id);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        remaining_time = savedInstanceState.getLong(STATE_MILLIUNTILFINISHED);
        nb_cycle_done = savedInstanceState.getInt(STATE_NB_OF_CYCLE_DONE);
        work_session = savedInstanceState.getBoolean(STATE_IS_WORK_SESSION);
        program_id = savedInstanceState.getString(STATE_PROGRAM_ID);
    }
}
