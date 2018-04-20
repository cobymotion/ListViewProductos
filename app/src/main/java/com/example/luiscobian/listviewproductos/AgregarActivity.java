package com.example.luiscobian.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AgregarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }

    public void guardaDatos(View v)
    {
        Intent i = new Intent();
        i.putExtra("mensaje", "Lo que quiero que diga");
        setResult(RESULT_OK, i);
        finish();
    }
}
