package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.componentes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] opciones = {"Opción 1", "Opción 2"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                //android.R.layout.simple_spinner_item, opciones); creacion del spinner

        //personalizar el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones_spinner, R.layout.mi_spinner);
        adapter.setDropDownViewResource(R.layout.mi_spinner);
        binding.spinner.setAdapter(adapter);

        binding.rB1.setOnClickListener(this);
        binding.rB2.setOnClickListener(this);
        
        binding.spinner.setOnItemSelectedListener(this);
    }
    
    @Override
    public void onClick(View view) {
        if (binding.rB1.isChecked()) {
            Toast.makeText(this, "Opción 1", Toast.LENGTH_SHORT).show();
        } else if (binding.rB2.isChecked()){
            Toast.makeText(this, "Opción 2", Toast.LENGTH_SHORT).show();
        }
    }

    public void check(View view) {
        boolean marcado = ((CheckBox)view).isChecked();

        switch (view.getId()) {
            case R.id.cB1:
                if (marcado) {
                    Toast.makeText(this, "Check 1", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.cB2:
                if (marcado) {
                    Toast.makeText(this, "Check 2", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String Opcion = (String) adapterView.getItemAtPosition(i);
        
        if (Opcion.equals("Opción 1")) {
            Toast.makeText(this, "Pulsada opción 1", Toast.LENGTH_SHORT).show();
        } else if (Opcion.equals("Opción 2")) {
            Toast.makeText(this, "Pulsada opción 2", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        
    }
}