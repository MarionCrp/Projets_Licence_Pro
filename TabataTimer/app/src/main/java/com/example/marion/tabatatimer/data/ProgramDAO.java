package com.example.marion.tabatatimer.data;

import java.util.List;

/**
 * Created by Marion on 31/10/2016.
 */

public class ProgramDAO {
    public static List<Program> selectAll(){
        return Program.listAll(Program.class);
    }

    public Program selectFirstProgram(){
        return Program.first(Program.class);
    }

    public Program findById(int id){
        return Program.findById(Program.class, id);
    }

    public int count(){
        return (int) Program.count(Program.class);
    }

    public void destroy(Program program){
        program.delete();
    }

    public void destroyAll(){
        for(Program program : selectAll()){
            program.delete();
        }
    }
}
