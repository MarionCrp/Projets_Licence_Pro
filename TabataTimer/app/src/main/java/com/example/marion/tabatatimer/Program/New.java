package com.example.marion.tabatatimer.Program;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.marion.tabatatimer.R;
import com.example.marion.tabatatimer.data.Program;

public class New extends AppCompatActivity {

    // Initialisation des valeurs propres à la classe Program.
    EditText program_title = null;
    NumberPicker nb_of_cycles = null;
    NumberPicker active_time_minutes = null;
    NumberPicker active_time_secondes = null;
    NumberPicker passive_time_minutes = null;
    NumberPicker passive_time_secondes = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Titre du programme
        program_title = (EditText) findViewById(R.id.exerciceName);
        nb_of_cycles = (NumberPicker) findViewById(R.id.nb_of_cycles);
        nb_of_cycles.setMaxValue(30);
        nb_of_cycles.setMinValue(1);

        //Initialisation du temps actif
        active_time_minutes = (NumberPicker) findViewById(R.id.active_time_minutes);
        active_time_minutes.setMaxValue(59);
        active_time_minutes.setMinValue(0);

        active_time_secondes = (NumberPicker) findViewById(R.id.active_time_secondes);
        active_time_secondes.setMaxValue(59);
        active_time_secondes.setMinValue(0);

        // Initialisation du temps passif
        passive_time_minutes = (NumberPicker) findViewById(R.id.passive_time_minutes);
        passive_time_minutes.setMaxValue(59);
        passive_time_minutes.setMinValue(0);

        passive_time_secondes = (NumberPicker) findViewById(R.id.passive_time_secondes);
        passive_time_secondes.setMaxValue(59);
        passive_time_secondes.setMinValue(0);
    }

    // On créé un programme avec les paramètres choisis par l'utilisateur et on l'enregistre dans la base.
    public void onTimeSubmit(View view) {
        String choosen_program_title = program_title.getText().toString();
        int choosen_active_time_minutes = active_time_minutes.getValue();
        int choosen_active_time_secondes = active_time_secondes.getValue();
        int choosen_passive_time_minutes = passive_time_minutes.getValue();
        int choosen_passive_time_secondes = passive_time_secondes.getValue();
        int choosen_nb_of_cycles = nb_of_cycles.getValue();
        Program program = new Program(choosen_program_title, choosen_active_time_minutes, choosen_active_time_secondes, choosen_passive_time_minutes, choosen_passive_time_secondes, choosen_nb_of_cycles);
        program.save();
        finish();
    }

    public void onCancel(View view){
        finish();
    }

}
