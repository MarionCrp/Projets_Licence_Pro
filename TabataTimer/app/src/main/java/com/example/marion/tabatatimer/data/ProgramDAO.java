package com.example.marion.tabatatimer.data;

import java.util.List;

/**
 * Created by Marion on 31/10/2016.
 */

public class ProgramDAO {
    public static List<Program> selectAll(){
        return Program.listAll(Program.class);
    }
}
