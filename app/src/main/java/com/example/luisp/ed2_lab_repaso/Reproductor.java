package com.example.luisp.ed2_lab_repaso;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Reproductor extends AppCompatActivity {

    private Button Btn;
    private Button BtnAdd;
    private Button BtnSort;
    private RadioButton RbAsc;
    private RadioButton RbDesc;
    private EditText Txt;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> Playlist;
    private Map<Integer,Cancion> library;
    private boolean Flag;
    private int song;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        Btn = (Button) findViewById(R.id.btnBuscar);
        BtnAdd=(Button) findViewById(R.id.BtnAgregar);
        BtnSort = (Button) findViewById(R.id.BtnOrdenar);
        RbAsc = (RadioButton) findViewById(R.id.RbA);
        RbDesc = (RadioButton) findViewById(R.id.RbD);
        Txt = (EditText)findViewById(R.id.txtBuscar);
        list = (ListView) findViewById(R.id.lstPlay);
        Playlist = new ArrayList<String>();


        library = new TreeMap<Integer, Cancion>();
        library.put(1,new Cancion("Enter Sandman", "Metallica","05:31"));
        library.put(2,new Cancion("Master of Pupets", "Metallica","08:35"));
        library.put(3,new Cancion("One", "Metallica","07:23"));
        library.put(4,new Cancion("Devils Dance", "Metallica","05:19"));
        library.put(5,new Cancion("Seek and Destroy", "Metallica","06:52"));
        library.put(6,new Cancion("Fade to Black", "Metallica","06:57"));
        library.put(7,new Cancion("Battery", "Metallica","05:12"));
        library.put(8,new Cancion("The Unforgiven", "Metallica","06:26"));
        library.put(9,new Cancion("The end of the line", "Metallica","07:52"));
        library.put(10,new Cancion("Atlas Rise", "Metallica","06:28"));

        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom, Playlist);
        list.setAdapter(adapter);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Aux = Txt.getText().toString();
                for ( i = 1; i <= library.size(); i++){
                    if (library.get(i).Name.equals(Aux)){
                        Dialog();
                        song = i;
                       Flag = true;
                       break;

                    }
                    else{
                        Flag = false;
                    }
                }


            }
        });

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (Flag){
                        Playlist.add(library.get(song).Name.toString()+"/"+library.get(song).Duration.toString());
                        adapter.notifyDataSetChanged();
                        Txt.setText("");
                        i = 0;
                        Flag = false;
                    }


            }
        });



    }

    public void Dialog(){
        new AlertDialog.Builder(this)
                .setTitle("Información")
                .setMessage("La Cancion buscada si existe en la Biblioteca, presione el boton 'Agregar' para ingresarla en la lista")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                }).create().show();
    }

}
