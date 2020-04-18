package com.example.kuisnirkabel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[]pertanyaan_kuis = new String[]{
     "1. Virus Corona (COVID-19) yang menyerang manusia muncul di negara ... pada awal tahun 2020.",
        "2. COVID-19 bisa masuk melalui anggota-anggota tubuh di bawah ini, kecuali...",
        "3. Dibawah ini adalah media penyebaran virus Corona, kecuali....",
        "4.  COVID-19 tidak bisa hidup di beberapa jenis cairan di bawah ini, kecuali...",
        "5.  Cuci tangan yang paling baik dilakukan dengan menggunakan sabun pada..."

    };

    String[] pilihan_jawaban = new String[]{
         "Cina","Amerika","Italia","Indonesia",
         "Mata","Telinga","Mulut","Hidung",
         "Bersalaman/Sentuhan tangan","Percikan batuk dan bersin","Udara","Benda-benda Padat",
         "Air panas","Cuka/asam", "Air dingin/tawar", "Air asin",
         "Air mengalir","Air dalam wadah","Air kolam","Air Es",

    };

    String[] jawaban_benar = new String[]{
         "Cina",
         "Telinga",
         "Udara",
         "Air dingin/tawar",
         "Air mengalir",

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView) findViewById(R.id.pertanyaan);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;


    }

    public  void next(View view){
     if(PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() ||PilihanD.isChecked()) {
         RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
         String ambil_jawaban_user = jawaban_user.getText().toString();
         rg.check(0);
         if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
         else salah++;
         nomor++;
         if (nomor < pertanyaan_kuis.length) {
             pertanyaan.setText(pertanyaan_kuis[nomor]);
             PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
             PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
             PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
             PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);


         } else {
             hasil = benar * 20;
             Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
             startActivity(selesai);
         }
     }
        else {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
