package com.example.marion.tabatatimer.Program;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.marion.tabatatimer.R;
import com.example.marion.tabatatimer.data.Program;
import com.example.marion.tabatatimer.data.ProgramDAO;

public class Edit extends AppCompatActivity {

    Program program = null;
    EditText program_title = null;
    NumberPicker np_number_of_cycles = null;
    NumberPicker np_work_time = null;
    NumberPicker np_rest_time = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

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
        program = programDAO.findById(Integer.parseInt(program_id));
        if(program != null){
            //Titre du programme
            program_title = (EditText) findViewById(R.id.exerciceName);
            program_title.setText(program.getTitle());
            np_number_of_cycles = (NumberPicker) findViewById(R.id.nb_of_cycles);
            System.out.println(program.getNb_of_cycle());
            np_number_of_cycles.setMaxValue(30);
            np_number_of_cycles.setMinValue(0);
            np_number_of_cycles.setValue(program.getNb_of_cycle());

            //Initialisation du temps actif
            np_work_time = (NumberPicker) findViewById(R.id.work_time);
            np_work_time.setMaxValue(100);
            np_work_time.setMinValue(0);
            np_work_time.setValue(program.getWork_time());


            // Initialisation du temps passif
            np_rest_time = (NumberPicker) findViewById(R.id.rest_time);
            np_rest_time.setMaxValue(100);
            np_rest_time.setMinValue(0);
            np_rest_time.setValue(program.getRest_time());

        } else {
            finish();
        }


    }

    public void onTimeSubmit(View view) {
        program.setWork_time(np_work_time.getValue());
        program.setRest_time(np_rest_time.getValue());
        program.setNb_of_cycle(np_number_of_cycles.getValue());
        program.setTitle(program_title.getText().toString());
        program.save();
        setResult(RESULT_OK, null);
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}