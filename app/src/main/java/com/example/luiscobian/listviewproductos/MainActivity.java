package com.example.luiscobian.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables a declarar
    private TextView txt;
    private ListView lista;
    //Datos con los que se llenara el ListView
    private String productos[] = {"Computadora", "Mouse", "Dulces", "Hojas", "Lapices", "Lentes",
            "Reloj", "Cuchara", "Celular", "Mesa", "Refrigerador", "Horno", "Audifonos"};
    private String categoria[] = {"Electronica","Electronica","Dulceria","Papeleria","Papeleria",
            "Moda","Perfumeria", "Hogar", "Electronicos", "Hogar", "Electrodomesticos", "Electrodomesticos",
            "Electronica"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
        lista = (ListView) findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Categoria elegido: " + categoria[position]);
            }
        });
    }

    public void llamaVentana(View w)
    {
        Log.e("Verifica Click", "click");
        Intent i = new Intent(this, AgregarActivity.class);
        startActivityForResult(i,4543);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {

        String cad = data.getStringExtra("mensaje");
        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();

    }
}
