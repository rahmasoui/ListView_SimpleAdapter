package com.example.listview_simpleadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String,String>> values ;
    HashMap<String,String> map ;
    ListView lst ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.lst);
        values = new ArrayList<HashMap<String, String>>();

        map=new HashMap<String, String>();
        map.put ("titre","Word");
        map.put ("description","Editeur de texte");
        map.put ("img",String.valueOf(R.drawable.word));
        values.add(map);

        map=new HashMap<String, String>();
        map.put ("titre","Excel");
        map.put ("description","Tableur");
        map.put ("img",String.valueOf(R.drawable.excel));
        values.add(map);

        map=new HashMap<String, String>();
        map.put ("titre","Power Point");
        map.put ("description","Logiciel de présentation");
        map.put ("img",String.valueOf(R.drawable.powerpoint));
        values.add(map);

        map= new HashMap<String, String>();
        map.put ("titre","Outlook");
        map.put ("description","Client de courrier électronique");
        map.put ("img",String.valueOf(R.drawable.outlook));
        values.add(map);

        SimpleAdapter myAdapter = new SimpleAdapter(this.getBaseContext(), values, R.layout.item, new String [] {"img","titre","description"}, new int[] {R.id.img, R.id.titre, R.id.description});
         lst.setAdapter(myAdapter);
         lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 HashMap<String, String> map = (HashMap<String, String>) lst.getItemAtPosition(position);

                 AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                 adb.setTitle("Sélection Item");
                 adb.setMessage("Votre choix : "+ map.get("titre"));
                 adb.setPositiveButton("Ok", null);
                 adb.show();
             }
         });
    }
}