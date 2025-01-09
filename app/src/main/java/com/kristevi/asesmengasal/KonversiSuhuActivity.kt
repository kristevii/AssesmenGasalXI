package com.kristevi.asesmengasal

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KonversiSuhuActivity : AppCompatActivity() {
    // langkah 1, inisialisasi
    lateinit var etSuhuAwal: EditText
    lateinit var spSuhuAwal: Spinner
    lateinit var spSuhuAkhir : Spinner
    lateinit var btKonversi : Button
    lateinit var btBersihkan : Button
    lateinit var tvHasilSuhuAkhir : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)
        // langkah 2
        etSuhuAwal = findViewById(R.id.etSuhuAwal)
        spSuhuAwal = findViewById(R.id.spSuhuAwal)
        spSuhuAkhir = findViewById(R.id.spSuhuAkhir)
        tvHasilSuhuAkhir = findViewById(R.id.tvHasilSuhuAkhir)
        btKonversi = findViewById(R.id.btKonversi)
        btBersihkan = findViewById(R.id.btBersihkan)
        // akhir langkah 2

        // awal langkah 4
        // panggil fungsi konversi suhu
        btKonversi.setOnClickListener {
            konversiSuhu()
        }
        btBersihkan.setOnClickListener {
            Bersihkan()
        }
        // akhir langkah 4

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // langkah 3
    fun konversiSuhu() {
        val decimalFormat = DecimalFormat("#.###")
        val suhuAwal = etSuhuAwal.text.toString().toDouble()
        //mengambil jenis suhu awal
        val suhuAwalJenis = spSuhuAwal.selectedItem.toString()
        //mengambil jenis suhu akhir
        val suhuAkhirJenis = spSuhuAkhir.selectedItem.toString()

        //periksa apakah input kosong
        if (suhuAwalJenis.isEmpty()) {
            tvHasilSuhuAkhir.text = "Input suhu tidak boleh kosong."
            return
        }

        //konversi suhu
        var suhuAkhir = suhuAwal

        // Konversi dari Celsius
        if (suhuAwalJenis == "Celsius") {
            when (suhuAkhirJenis) {
                "Celsius" -> suhuAkhir = suhuAwal
                "Fahrenheit" -> suhuAkhir = (suhuAwal * 9 / 5) + 32
                "Kelvin" -> suhuAkhir = suhuAwal + 273.15
            }
        }
        // Konversi dari Fahrenheit
        else if (suhuAwalJenis == "Fahrenheit") {
            when (suhuAkhirJenis) {
                "Celsius" -> suhuAkhir = (suhuAwal - 32) * 5 / 9
                "Fahrenheit" -> suhuAkhir = suhuAwal
                "Kelvin" -> suhuAkhir = (suhuAwal - 32) * 5 / 9 + 273.15
            }
        }
        // Konversi dari Kelvin
        else if (suhuAwalJenis == "Kelvin") {
            when (suhuAkhirJenis) {
                "Celsius" -> suhuAkhir = suhuAwal - 273.15
                "Fahrenheit" -> suhuAkhir = (suhuAwal - 273.15) * 9 / 5 + 32
                "Kelvin" -> suhuAkhir = suhuAwal
            }
        }
        val hasilTerformat = decimalFormat.format(suhuAkhir)
        tvHasilSuhuAkhir.text = hasilTerformat.toString()
    }
    //fungsi untuk membersihkan input
    fun Bersihkan(){
        etSuhuAwal.text.clear()
        tvHasilSuhuAkhir.text=""
    }
}