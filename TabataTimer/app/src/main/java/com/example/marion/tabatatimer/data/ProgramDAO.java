package com.example.marion.tabatatimer.data;

import java.util.List;

/**
 * Created by Marion on 31/10/2016.
 */

public class ProgramDAO {
    public static List<Program> selectAll(){
        return Program.listAll(Program.class);
    }

    public static Program selectFirstProgram(){
        return Program.first(Program.class);
    }

    public static Program findById(int id){
        return Program.findById(Program.class, id);
    }

    public static int count(){
        return (int) Program.count(Program.class);
    }

    public static void destroy(Program program){
        program.delete();
    }

    public static void destroyAll(){
        for(Program program : selectAll()){
            program.delete();
        }
    }
}
