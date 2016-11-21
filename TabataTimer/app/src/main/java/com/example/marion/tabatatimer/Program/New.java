package com.example.marion.tabatatimer.Program;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.marion.tabatatimer.R;
import com.example.marion.tabatatimer.data.Program;

public class New extends AppCompatActivity {

    EditText program_title = null;
    NumberPicker np_number_of_cycles = null;
    NumberPicker np_work_time = null;
    NumberPicker np_rest_time = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Titre du programme
        program_title = (EditText) findViewById(R.id.exerciceName);
        np_number_of_cycles = (NumberPicker) findViewById(R.id.nb_of_cycles);
        np_number_of_cycles.setMaxValue(30);
        np_number_of_cycles.setMinValue(0);

        //Initialisation du temps actif
        np_work_time = (NumberPicker) findViewById(R.id.work_time);
        np_work_time.setMaxValue(100);
        np_work_time.setMinValue(0);

        // Initialisation du temps passif
        np_rest_time = (NumberPicker) findViewById(R.id.rest_time);
        np_rest_time.setMaxValue(100);
        np_rest_time.setMinValue(0);
    }

    public void onTimeSubmit(View view) {
        String choosen_program_title = program_title.getText().toString();
        int choosen_active_time_minutes = np_work_time.getValue();
        int choosen_passive_time_minutes = np_rest_time.getValue();
        int choosen_nb_of_cycles = np_number_of_cycles.getValue();
        Program program = new Program(choosen_program_title, choosen_active_time_minutes, choosen_passive_time_minutes, choosen_nb_of_cycles);
        program.save();
        setResult(RESULT_OK, null); // Permet de valider la condition du refresh
        finish();
    }

    public void onCancel(View view) {
        finish();
    }

}
