package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.componentes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rB1.setOnClickListener(this);
        binding.rB2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (binding.rB1.isChecked()) {
            Toast.makeText(this, "Opción 1", Toast.LENGTH_SHORT).show();
        } else {
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
}