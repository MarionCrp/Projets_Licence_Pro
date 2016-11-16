package com.example.marion.tabatatimer.data;

import com.orm.SugarRecord;

/**
 * Created by Marion on 31/10/2016.
 */

public class Program extends SugarRecord {
    private String title;
    private int active_minutes;
    private int active_secondes;
    private int passive_minutes;
    private int passive_secondes;
    private int nb_of_cycle;

    public Program(){

    }

    public Program(String title, int active_minutes, int active_secondes, int passive_minutes, int passive_secondes, int nb_of_cycle) {
        this.title = title;
        this.active_minutes = active_minutes;
        this.active_secondes = active_secondes;
        this.passive_minutes = passive_minutes;
        this.passive_secondes = passive_secondes;
        this.nb_of_cycle = nb_of_cycle;
    }

    public int getActive_minutes() {
        return active_minutes;
    }

    public void setActive_minutes(int active_minutes) {
        this.active_minutes = active_minutes;
    }

    public int getActive_secondes() {
        return active_secondes;
    }

    public void setActive_secondes(int active_secondes) {
        this.active_secondes = active_secondes;
    }

    public int getPassive_minutes() {
        return passive_minutes;
    }

    public void setPassive_minutes(int passive_minutes) {
        this.passive_minutes = passive_minutes;
    }

    public int getPassive_secondes() {
        return passive_secondes;

    }

    public void setPassive_secondes(int passive_secondes) {
        this.passive_secondes = passive_secondes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb_of_cycle() {
        return nb_of_cycle;
    }

    public void setNb_of_cycle(int nb_of_cycle) {
        this.nb_of_cycle = nb_of_cycle;
    }



}
