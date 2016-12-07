package com.example.marion.tabatatimer.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.marion.tabatatimer.MainActivity;
import com.example.marion.tabatatimer.Program.Edit;
import com.example.marion.tabatatimer.Program.Index;
import com.example.marion.tabatatimer.R;

import java.util.List;

import static android.app.PendingIntent.getActivity;
import static com.example.marion.tabatatimer.MainActivity.MAIN_ACTIVITY_REQUEST;
import static com.example.marion.tabatatimer.Program.Index.EDIT_ACTIVITY_REQUEST;
import static com.example.marion.tabatatimer.Program.Index.PROGRAM_ID;

/**
 * Created by Marion on 13/11/2016.
 */

public class ProgramListAdapter extends ArrayAdapter<Program>{

    // programs est la liste à afficher
    public ProgramListAdapter(Context context, List<Program> programs){
        super(context, 0, programs);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ProgramDAO programDAO = new ProgramDAO();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.program, parent, false);
        }

        ProgramViewHolder viewHolder = (ProgramViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProgramViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title_textView);
            viewHolder.rest_time = (TextView) convertView.findViewById(R.id.rest_time_textView);
            viewHolder.work_time = (TextView) convertView.findViewById(R.id.work_time_textView);
            viewHolder.nb_of_cycles = (TextView) convertView.findViewById(R.id.nb_of_cycle_textView);

            viewHolder.run_button = (ImageButton) convertView.findViewById(R.id.run_button);
            viewHolder.edit_button = (ImageButton) convertView.findViewById(R.id.edit_button);
            viewHolder.destroy_button = (ImageButton) convertView.findViewById(R.id.delete_button);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Program> programs.
        final Program program = getItem(position);

        // Remplissage des vues
        viewHolder.title.setText(program.getTitle());
        viewHolder.rest_time.setText(String.valueOf(program.getRest_time()) + "\"");
        viewHolder.work_time.setText(String.valueOf(program.getWork_time()) + "\"");
        viewHolder.nb_of_cycles.setText(String.valueOf(program.getNb_of_cycle()));

        // Gestion des boutons d'action
        viewHolder.run_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramListAdapter.this.getContext(), MainActivity.class);
                intent.putExtra("PROGRAM_ID", program.getId().toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ((Activity) ProgramListAdapter.this.getContext()).startActivityForResult(intent, MAIN_ACTIVITY_REQUEST);
            }
        });

       viewHolder.edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramListAdapter.this.getContext(), Edit.class);
                intent.putExtra("PROGRAM_ID", program.getId().toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ((Activity) ProgramListAdapter.this.getContext()).startActivityForResult(intent, EDIT_ACTIVITY_REQUEST);
            }
        });

        viewHolder.destroy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgramListAdapter.this.remove(program); // Suppression du programme dans la liste (this = View -> ProgramListAdapter.this = adapter)
                programDAO.destroy(program); // Suppression du programme dans la base de données.
            }
        });

        return convertView;
    }

    private class ProgramViewHolder {
        public TextView title;
        public TextView rest_time;
        public TextView work_time;
        public TextView nb_of_cycles;
        public ImageButton destroy_button;
        public ImageButton edit_button;
        public ImageButton run_button;
    }
}
