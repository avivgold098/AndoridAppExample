package com.example.menachi.fragmentdemo.model;

import java.util.LinkedList;
import java.util.List;
import com.example.menachi.fragmentdemo.MyApplication;
/**
 * Created by menachi on 19/04/2017.
 */

public class Model {
   ModelSql Sql;
    public final static Model instace = new Model();

    private Model()
    {
        Sql = new ModelSql(MyApplication.getMyContext());
    }
    public List<Student> getAllStudents(){
        //StudentSql.onUpgrade(Sql.getReadableDatabase(),0,0);
        return StudentSql.getAllStudents(
                Sql.getReadableDatabase());

    }

    public void addStudent(Student st){
        StudentSql.addStudent(Sql.getWritableDatabase(),st);
    }
    public  void deleteStudent(Student st){StudentSql.deleteStudent(Sql.getWritableDatabase(),st); }

    public Student getStudent(String stId) {
        return StudentSql.getStudent(Sql.getReadableDatabase(),stId);

    }
    public boolean checkIfIdExists(String id )
    {
        if((StudentSql.getStudent(Sql.getReadableDatabase(),id))!=null)
                return true;
        return false;
    }
}
