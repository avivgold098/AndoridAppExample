package com.example.menachi.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.menachi.fragmentdemo.model.Student;

import static com.example.menachi.fragmentdemo.R.id.detId;


public class MainActivity extends Activity
        implements StudentListFragment.OnFragmentInteractionListener,StudentAdd.OnFragmentInteractionListener ,StudentDetailsFragment.OnFragmentInteractionListener{
    public static  String CurrentFragment;

  //  FragmentTransaction tran =  getFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","MainActivity onCreate");
        FragmentTransaction tran =  getFragmentManager().beginTransaction();
        CurrentFragment = "List";
        StudentListFragment listFragment = StudentListFragment.newInstance();
        tran.add(R.id.main_container, listFragment);
        tran.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.main_add:
                StudentAdd sa = StudentAdd.newInstance(null);
                this.CurrentFragment="add";
                FragmentTransaction tran = getFragmentManager().beginTransaction();
                tran.replace(R.id.main_container,sa);
                tran.addToBackStack("");
                tran.commit();
                getActionBar().setDisplayHomeAsUpEnabled(true);
                break;
            case android.R.id.home:
                if(this.CurrentFragment.equals("StudentDetails")||this.CurrentFragment.equals("add"))
                    getActionBar().setDisplayHomeAsUpEnabled(false);

                onBackPressed();


                    break;



            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }






    @Override
    public void onFragmentInteraction(String id) {
        this.CurrentFragment="StudentDetails";
        StudentDetailsFragment studentDetailsFragment = StudentDetailsFragment.newInstance(id);
        FragmentTransaction tran = getFragmentManager().beginTransaction();
        tran.replace(R.id.main_container,studentDetailsFragment);
        tran.addToBackStack("");
       // CurrentFragment="Details";
        getActionBar().setDisplayHomeAsUpEnabled(true);

        tran.commit();

    }

    @Override
    public void onFragmentInteraction(boolean bool) {
        CurrentFragment="List";
        StudentListFragment listFragment = StudentListFragment.newInstance();
        FragmentTransaction tran = getFragmentManager().beginTransaction() ;
        tran.replace(R.id.main_container,listFragment);
        tran.commit();
        getActionBar().setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public void onFragmentInteraction(Student str) {

    }
}
