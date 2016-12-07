package com.example.marion.tabatatimer.Program;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.marion.tabatatimer.R;
import com.example.marion.tabatatimer.data.Program;
import com.example.marion.tabatatimer.data.ProgramDAO;
import com.example.marion.tabatatimer.data.ProgramListAdapter;

import java.util.List;

public class Index extends AppCompatActivity {
    public final static int NEW_ACTIVITY_REQUEST = 1;
    public final static int EDIT_ACTIVITY_REQUEST = 2;
    public static int PROGRAM_ID;
    private ListView mListView;
    private TextView no_program_flash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mListView = (ListView) findViewById(R.id.listview_program);
        // Instanciation de l'objet qui va chercher la liste des programmes en base de données.
        List<Program> programs = ProgramDAO.selectAll();

        // On gère l'affichage si aucun programe n'est enregistré.
        if(programs.size() == 0){
            TextView no_program_flash = (TextView) findViewById(R.id.no_program_flash);
            no_program_flash.setText("No program. Add your first!");
        }else {
            ProgramListAdapter adapter = new ProgramListAdapter(Index.this, programs);
            mListView.setAdapter(adapter);
        }
    }

    // Bouton pour créer un nouveau programme.
    public void onNew(View view){
        Intent intent = new Intent(this, New.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, NEW_ACTIVITY_REQUEST);
    }

    public void onCancel(View view){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Intent refresh = new Intent(this, Index.class);
            startActivity(refresh);
            this.finish();
        }
    }
}