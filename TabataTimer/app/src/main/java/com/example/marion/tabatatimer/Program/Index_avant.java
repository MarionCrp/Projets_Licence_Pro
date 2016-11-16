/*package com.example.marion.tabatatimer.Program;

import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marion.tabatatimer.R;
import com.example.marion.tabatatimer.data.Program;
import com.example.marion.tabatatimer.data.ProgramDAO;

public class Index_avant extends AppCompatActivity {

    public final static int EDIT_ACTIVITY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        final LinearLayout linearMain = (LinearLayout) findViewById(R.id.linearMain);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        linearMain.setOrientation(LinearLayout.VERTICAL);

        // Instanciation de l'objet qui va chercher la liste des programmes en base de données.
        ProgramDAO programDao = new ProgramDAO();

        // On affiche tous les programmes
        for( Program program : programDao.selectAll()) {
            // On créé un layout horizontal pour y mettre le titre, et les boutons pour chaque programme.
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            // On créé le TextView pour afficher le titre du programme.
            TextView program_title = new TextView(this);
            program_title.setText(program.getTitle());

            setTitleParams(program_title);

            // On créé les boutons :

            // Bouton edit
            ImageButton edit = new ImageButton(this);
            // On attribut une icone au bouton
            Drawable edit_picture = VectorDrawableCompat.create(getResources(), android.R.drawable.ic_menu_edit, null);
            edit_picture = DrawableCompat.wrap(edit_picture);
            edit.setImageDrawable(edit_picture);
            setButtonParams(edit);



            edit.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(Index_avant.this, Edit.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivityForResult(intent, EDIT_ACTIVITY_REQUEST);
                                        }
                                    });

            // Bouton play
            ImageButton play = new ImageButton(this);
            // On attribut une icone au bouton
            Drawable play_picture = VectorDrawableCompat.create(getResources(), android.R.drawable.ic_media_play, null);
            play_picture = DrawableCompat.wrap(play_picture);
            play.setImageDrawable(play_picture);

            // Bouton edit
            ImageButton delete = new ImageButton(this);
            // On attribut une icone au bouton
            Drawable delete_picture = VectorDrawableCompat.create(getResources(), android.R.drawable.ic_menu_delete, null);
            delete_picture = DrawableCompat.wrap(delete_picture);
            delete.setImageDrawable(delete_picture);

            // On ajoute le titre et les boutons dans leur layout horizontal respectif.
            linearLayout.addView(program_title);
            linearLayout.addView(edit);
            linearLayout.addView(play);
            linearLayout.addView(delete);

            // Et on ajoute ce layout au layout principal.
            linearMain.addView(linearLayout);
        }
    }

    // Bouton pour créer un nouveau programme.
    public void onEdit(View view){
        Intent intent = new Intent(this, Edit.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, EDIT_ACTIVITY_REQUEST);
    }

    public void setButtonParams(ImageButton button){
        LinearLayout.LayoutParams button_params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(button_params);

    }

    public void setTitleParams(TextView title){
        LinearLayout.LayoutParams title_params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
}
*/