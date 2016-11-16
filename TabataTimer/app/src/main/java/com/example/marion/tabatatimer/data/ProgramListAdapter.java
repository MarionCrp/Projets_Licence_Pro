package com.example.marion.tabatatimer.data;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.marion.tabatatimer.R;

import java.util.List;

/**
 * Created by Marion on 13/11/2016.
 */

public class ProgramListAdapter extends ArrayAdapter<Program> {

    // programs est la liste à afficher
    public ProgramListAdapter(Context context, List<Program> programs){
        super(context, 0, programs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.program, parent, false);
        }

        ProgramViewHolder viewHolder = (ProgramViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProgramViewHolder();
            viewHolder.program_title = (TextView) convertView.findViewById(R.id.program_title);
            viewHolder.rest_time = (TextView) convertView.findViewById(R.id.rest_textview);
            viewHolder.work_time = (TextView) convertView.findViewById(R.id.workTime_textview);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Program> programs.
        Program program = getItem(position);

        // Remplissage des vues
        viewHolder.program_title.setText(program.getTitle());
        viewHolder.rest_time.setText(program.get);
        viewHolder.work_time.setText("Toto2");
        return convertView;
    }

    private class ProgramViewHolder {
        public TextView program_title;
        public TextView rest_time;
        public TextView work_time;
    }
}
