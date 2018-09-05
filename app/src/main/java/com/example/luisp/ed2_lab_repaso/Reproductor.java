package com.example.luisp.ed2_lab_repaso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Reproductor extends AppCompatActivity {

    private Button Btn;
    private EditText Txt;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> Playlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        Btn = (Button) findViewById(R.id.btnBuscar);
        Txt = (EditText)findViewById(R.id.txtBuscar);
        list = (ListView) findViewById(R.id.lstPlay);
        Playlist = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom, Playlist);
        list.setAdapter(adapter);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Playlist.add(Txt.getText().toString());
                adapter.notifyDataSetChanged();
                Txt.setText("");
            }
        });



    }

}
