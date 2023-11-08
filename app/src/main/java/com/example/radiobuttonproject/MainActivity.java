package com.example.radiobuttonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    CheckBox checkBox;
    Spinner spinner;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radiogroup);
        checkBox = findViewById(R.id.checkbox1);
        checkBox = findViewById(R.id.checkbox2);
        checkBox = findViewById(R.id.checkbox3);
        button1 = findViewById(R.id.Submit);
        button2 = findViewById(R.id.Link);
        spinner =findViewById(R.id.spinner);

        //For Radiogroup

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton radioButton =findViewById(i);

                Toast.makeText(MainActivity.this,"you have selected" + radioButton.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });

        //for checkbox

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    Toast.makeText(MainActivity.this, "Check Box is Check", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this, "Check Box is not check", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //for spinner

        String [] Course = {"Mani","Krishna","PAbbathi"};

        ArrayAdapter<String>
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Course);
        spinner.setAdapter(adapter);

        //for button

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Intent",Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(getApplicationContext(),Mk.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
    }
}