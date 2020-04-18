package com.example.kuisnirkabel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HasilKuis extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView nilai = (TextView) findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : "+MainActivity.benar+"\n Jawaban Salah : "+MainActivity.salah);
        nilai.setText(""+MainActivity.hasil);
    }
    public void ulangi(View view){
        finish();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}

