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

    private static CountDownTimer timer;
    public final String WORK_COLOR = "#b30000";
    public final String REST_COLOR = "#008000";
    public final String ANNOUNCEMENT_COLOR = "#993366";
    private static String STATE_MILLIUNTILFINISHED;
    private static String STATE_NB_OF_CYCLE_DONE;
    private static String STATE_IS_WORK_SESSION;
    private static String STATE_PROGRAM_ID;

    //
    public String session_type;
    public int nb_cycle_done;
    public long remaining_time;
    public String state = "ready";
    private Bundle savedInstanceState;

    //
    public String current_timer_name;

    // Elément de design :
    public TextView tv_announcement;
    public TextView tv_cycles;
    public TextView tv_chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        tv_announcement = (TextView) findViewById(R.id.announcement);
        tv_cycles = (TextView) findViewById(R.id.cycles_result);
        tv_chrono = (TextView) findViewById(R.id.chrono);

        if (extras == null) {
            program_id = null;
        } else {
            tv_announcement.setText("PRESS START TO BEGIN!");
            current_timer_name = "work";
            nb_cycle_done = 1;
            Button start_button = (Button) findViewById(R.id.start_button);
            Button pause_button = (Button) findViewById(R.id.pause_button);
            start_button.setVisibility(View.VISIBLE);
            pause_button.setVisibility(View.VISIBLE);
            program_id = extras.getString("PROGRAM_ID");
            program = ProgramDAO.findById(Integer.parseInt(program_id));
            remaining_time = program.getWork_time();
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

    public void onStart(View view) {
        launchTimer();

    }

    public void launchTimer(){
        if(state == "ready"){
            if (current_timer_name.equals("work")) remaining_time = program.getWork_time() * 1000;
            else if (current_timer_name.equals("rest")) remaining_time = program.getRest_time() * 1000;
        }
        state = "ready";
        //else if (current_timer_name.equals("Paused!")) remaining_time = saveCurrentTimerName;
        if( !tabata_is_finished(program)) {
            timer = new CountDownTimer(remaining_time, 10) {

                public void onTick(long millisUntilFinished) {
                    remaining_time = millisUntilFinished;
                    miseAJour();
                }

                public void onFinish() {
                    remaining_time = 0;
                    if (current_timer_name.equals("work")) {
                        current_timer_name = "rest";
                        launchTimer();
                    } else if (current_timer_name.equals("rest")) {
                        current_timer_name = "work";
                        nb_cycle_done++;
                        miseAJour();
                        launchTimer();
                    }
                }
            }.start();
        }
        miseAJour();
    }

    public void onPauseButton(View view){
        state = "on pause";
        if (timer != null) {
            timer.cancel();
        }
    }

    public void onCancel(View view){
        finish();
    }

    // Mise à jour graphique
    private void miseAJour() {
        String chrono_color;
        String annoucement_text;
        if (tabata_is_finished(program)) {
            tv_chrono.setText("Good Job!");
            tv_announcement.setText("");
            tv_cycles.setText("");
        } else {
            if (current_timer_name == "work") {
                chrono_color = WORK_COLOR;
                annoucement_text = "WORK TIME";
            } else if (current_timer_name == "rest") {
                chrono_color = REST_COLOR;
                annoucement_text = "REST TIME";
            } else {
                chrono_color = "red";
                annoucement_text = "";
            }
            // Décompositions en secondes et minutes
            int secs = (int) (remaining_time / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (remaining_time % 1000);

            // Affichage du "timer"
            tv_chrono.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            tv_chrono.setTextColor(Color.parseColor(chrono_color));
            tv_announcement.setText(annoucement_text);
            tv_announcement.setTextColor(Color.parseColor(chrono_color));
            tv_cycles.setText(nb_cycle_done + " / " + program.getNb_of_cycle());
        }

    }

    public boolean tabata_is_finished(Program program) {
        return nb_cycle_done > program.getNb_of_cycle();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong(STATE_MILLIUNTILFINISHED, remaining_time);
        savedInstanceState.putInt(STATE_NB_OF_CYCLE_DONE, nb_cycle_done);
        savedInstanceState.putString(STATE_IS_WORK_SESSION, session_type);
        savedInstanceState.putString(STATE_PROGRAM_ID, program_id);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        remaining_time = savedInstanceState.getLong(STATE_MILLIUNTILFINISHED);
        nb_cycle_done = savedInstanceState.getInt(STATE_NB_OF_CYCLE_DONE);
        session_type = savedInstanceState.getString(STATE_IS_WORK_SESSION);
        program_id = savedInstanceState.getString(STATE_PROGRAM_ID);
    }
}
