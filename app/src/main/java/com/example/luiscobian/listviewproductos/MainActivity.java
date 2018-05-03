package com.example.luiscobian.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        registerForContextMenu(lista);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.op_salir:
                Toast.makeText(this, "Saliendo", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.op_info:
                Toast.makeText(this, "Informacion", Toast.LENGTH_LONG)
                        .show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(lista.getAdapter().getItem(info.position).toString());
        getMenuInflater().inflate(R.menu.menu_emergente, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info  =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){

            case R.id.emergente_1:
                String nombre = productos[info.position]; // Lproductos.get(info.position);
                Toast.makeText(this, "Se modificara " + nombre,
                        Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.emergente_2:
                String nombre2 = productos[info.position];
                Toast.makeText(this, "Se Eliminara " + nombre2,
                        Toast.LENGTH_LONG)
                        .show();
                break;
        }
        return true;
    }
}



















