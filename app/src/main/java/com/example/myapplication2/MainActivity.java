package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerUnits=findViewById(R.id.spinner7);

        Spinner spinnerUnits2=findViewById(R.id.spinner8);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerUnits.setAdapter(adapter);
        spinnerUnits2.setAdapter(adapter);
        Button btn= findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = spinnerUnits.getSelectedItem().toString();
                String to = spinnerUnits2.getSelectedItem().toString();

                EditText edtxt = findViewById(R.id.editTextNumberDecimal7);

                String no = edtxt.getText().toString();
                TextView txt= findViewById(R.id.textView4);

                DecimalFormat formatter = new DecimalFormat("#0.000");

               double res= conversion(from, to, Double.parseDouble(no));
                txt.setText(formatter.format(res)+ " "+ to);

            }

            double conversion(String from, String to, double no)
            {
                if(from.equalsIgnoreCase(to))
                    return no;

                //inches to everything
                else if(from.equalsIgnoreCase("inches (inch)"))
                {
                    if(to.equalsIgnoreCase("Centimeter (cm)"))
                    {
                        return no*2.54;
                    }
                    if(to.equalsIgnoreCase("foot (ft)"))
                        return no*0.083;
                    if(to.equalsIgnoreCase("yard (yd)"))
                        return no/36;
                }
                //Cm to everything
                else if(from.equalsIgnoreCase("Centimeter (cm)"))
                {
                    if(to.equalsIgnoreCase("inches (inch)"))
                    {
                        return no/2.54;
                    }
                    if(to.equalsIgnoreCase("foot (ft)"))
                        return no/30.48;
                    if(to.equalsIgnoreCase("yard (yd)"))
                        return no/91.44;
                }

                //ft to everything
                else if(from.equalsIgnoreCase("foot (ft)")) {
                    if(to.equalsIgnoreCase("inches (inch)"))
                    {
                        return no*12.0;
                    }
                    if(to.equalsIgnoreCase("Centimeter (cm)"))
                        return no*30.48;
                    if(to.equalsIgnoreCase("yard (yd)"))
                        return no/3.0;
                }

                //Yard to everything

                else {
                    if(to.equalsIgnoreCase("inches (inch)"))
                    {
                        return no*36.0;
                    }
                    if(to.equalsIgnoreCase("centimeter (cm)"))
                        return no*91.44;
                    if(to.equalsIgnoreCase("foot (ft)"))
                        return no*3.0;
                }

                return 0.0;
            }


        });

    }



}