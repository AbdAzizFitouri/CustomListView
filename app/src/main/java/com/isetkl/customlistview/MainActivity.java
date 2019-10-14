package com.isetkl.customlistview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        int[] imgArray = {R.drawable.word, R.drawable.excel, R.drawable.powerpoint, R.drawable.outlook};

        String[] names = {"Word","Excel","PowerPoint","Outlook"};

        String[] descriptions = {"Editeur de texte", "Tableur", "Logiciel de présentation", "Client de courrier électronique" };



        ArrayList list = new ArrayList();
        list.add(this);
        list.add(imgArray);
        list.add(names);
        list.add(descriptions);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.list,list);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i == 0)
                {
                    Toast.makeText(MainActivity.this, "Word", Toast.LENGTH_SHORT).show();
                }
                else if (i == 1)
                {
                    Toast.makeText(MainActivity.this, "Excel", Toast.LENGTH_SHORT).show();
                }
                else if (i == 2)
                {
                    Toast.makeText(MainActivity.this, "PowerPoint", Toast.LENGTH_SHORT).show();
                }
                else if (i == 3)
                {
                    Toast.makeText(MainActivity.this, "Outlook", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Veuillez Réessayer de nouveau", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection d'un Item");

                if(position == 0)
                {
                    builder.setMessage("Votre choix : Word");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 1)
                {
                    builder.setMessage("Votre choix : Excel");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 2)
                {
                    builder.setMessage("Votre choix : PowerPoint");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 3)
                {
                    builder.setMessage("Votre choix : Outlook");
                    Log.e("tag" , "position " + position);
                }
                else
                {
                    builder.setMessage("Veuillez Choisir un Item!");
                    Log.e("tag" , "position " + position);
                }

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {

                    }
                });

                AlertDialog alert11 = builder.create();
                alert11.show();

                return true;
            }
        });
    }

}

