package com.example.marion.tabatatimer.data;

import com.orm.SugarRecord;

/**
 * Created by Marion on 31/10/2016.
 */

public class Program extends SugarRecord {
    private String title;
    private int work_time;
    private int rest_time;
    private int nb_of_cycle;

    public Program(){

    }

    public Program(String title, int active_time, int rest_time, int nb_of_cycle) {
        this.title = title;
        this.work_time = active_time;
        this.rest_time = rest_time;
        this.nb_of_cycle = nb_of_cycle;
    }

    public int getWork_time() {
        return work_time;
    }

    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }

    public int getRest_time() {
        return rest_time;
    }

    public void setRest_time(int rest_time) {
        this.rest_time = rest_time;
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
