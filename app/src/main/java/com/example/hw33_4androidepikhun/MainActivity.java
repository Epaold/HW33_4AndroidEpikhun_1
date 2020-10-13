package com.example.hw33_4androidepikhun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mCountriesSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    // Получаем экземпляр элемента Spinner
    Spinner spinner = findViewById(R.id.spinner);
    Button button =findViewById(R.id.button);
    // Настраиваем адаптер
    ArrayAdapter<?> adapter =
            ArrayAdapter.createFromResource(this, R.array.Language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Вызываем адаптер
spinner.setAdapter(adapter);

        mCountriesSpinner = findViewById(R.id.spinner);




        //public String localeId;

    }
//        @Override
        public void  button (View v) {


        Toast.makeText(MainActivity.this
                    ,mCountriesSpinner.getSelectedItem().toString()
                            +" "

                    ,Toast.LENGTH_LONG)
                    .show();

            String item = mCountriesSpinner.getSelectedItem().toString();
            String localeId;
            switch(item) {
                case "English":
                    localeId = "en";
                    break;
                case "Russian":
                    localeId = "ru";
                    break;
                case "German":
                    localeId = "de";
                    break;


                default:
                    return;
                //  throw new IllegalStateException("Unexpected value: " + item);

            }



            Locale locale= new Locale(localeId);
            Configuration config=new Configuration();
            config.setLocale(locale);
           getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
           recreate();
        }
}

