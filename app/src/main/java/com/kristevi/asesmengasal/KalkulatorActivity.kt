package com.kristevi.asesmengasal

import android.content.Intent
import android.icu.text.DecimalFormat
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class KalkulatorActivity : AppCompatActivity() {

    // langkah 1
    // deklarasi variabel
    // baik berupa tipe data maupun komponen
    // variabel nilainya bisa diubah-ubah
    // ada 2 jenis variabel, yaitu global dan lokal

    // komponen
    // variabel global
    lateinit var etResult: EditText
    lateinit var btTambah: Button
    lateinit var btKurang: Button
    lateinit var btBagi: Button
    lateinit var btKali: Button
    lateinit var btBersihkan: Button
    lateinit var btHapus: Button
    lateinit var btKoma: Button
    lateinit var btHasil: Button
    lateinit var btPM: Button
    lateinit var btNol: Button
    lateinit var btSatu: Button
    lateinit var btDua: Button
    lateinit var btTiga: Button
    lateinit var btEmpat: Button
    lateinit var btLima: Button
    lateinit var btEnam: Button
    lateinit var btTujuh: Button
    lateinit var btDelapan: Button
    lateinit var btSembilan: Button
    lateinit var btPersen: Button

    // tipe data
    var NilaiAwal: Double = 0.0
    var aksi: String = ""
    var koma: Boolean = false
    var hasilTerakhir: Double? = null

    // on create adalah sebuah fungsi yang pasti ada
    // karena dia adalah fungsi yang pertama kali dipanggil oleh sistem
    // ketika activity dijalankan
    // fun = function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        // langkah 3
        // memanggil fun init() dari fun onCreate
        init()
        tekan()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // langkah 2
    // membuat fun init ()
    // digunakan untuk mengisikan lateinit
    // yang sudah kita buat pada langkah 1
    fun init() {
        etResult = findViewById(R.id.etResult)
        btBersihkan = findViewById(R.id.btBersihkan)
        btHapus = findViewById(R.id.btHapus)
        btTambah = findViewById(R.id.btTambah)
        btKurang = findViewById(R.id.btKurang)
        btBagi = findViewById(R.id.btBagi)
        btKali = findViewById(R.id.btKali)
        btKoma = findViewById(R.id.btKoma)
        btPM = findViewById(R.id.btPM)
        btHasil = findViewById(R.id.btHasil)
        btNol = findViewById(R.id.btNol)
        btSatu = findViewById(R.id.btSatu)
        btDua = findViewById(R.id.btDua)
        btTiga = findViewById(R.id.btTiga)
        btEmpat = findViewById(R.id.btEmpat)
        btLima = findViewById(R.id.btLima)
        btEnam = findViewById(R.id.btEnam)
        btTujuh = findViewById(R.id.btTujuh)
        btDelapan = findViewById(R.id.btDelapan)
        btSembilan = findViewById(R.id.btSembilan)
        btPersen = findViewById(R.id.btPersen)

    }

    fun IsiData() {
        if (etResult.text.isNotEmpty()) {
            NilaiAwal = etResult.text.toString().toDouble()
            etResult.text.clear()
        } else {
            NilaiAwal = 0.0
        }
    }

    fun operasiMatematika(operasi: (Double, Double) -> Double) {
        if (etResult.text.isNotEmpty()) {
            val decimalFormat = DecimalFormat("#.###")
            val nilaiBaru = etResult.text.toString().toDouble()
            val hasilPerhitungan = operasi(NilaiAwal, nilaiBaru)
            hasilTerakhir = hasilPerhitungan
            val hasilTerformat = decimalFormat.format(hasilTerakhir!!)
            etResult.setText(hasilTerformat)
            aksi = "" // Reset operation after calculation
        }
    }


    // langkah 4
    // membuat fun tekan()
    // digunakan untuk event onCreate
    // aksi ketika tombol kita di tekan
    fun tekan() {
        btBersihkan.setOnClickListener {
            koma = false
            aksi = ""
            etResult.text.clear()
        }
        btHapus.setOnClickListener {
            val currentText = etResult.text.toString()
            if (currentText.isNotEmpty()) {
                etResult.setText(currentText.substring(0, currentText.length - 1))
            }
        }
        btPM.setOnClickListener {
            if (etResult.text.isNotEmpty()) {
                etResult.setText("${-1 * etResult.text.toString().toDouble()}")
            }
        }
        btNol.setOnClickListener {
            if (etResult.text.isNotEmpty()) {
                etResult.setText("${etResult.text}0")
            }
        }
        btSatu.setOnClickListener {
            if (koma) {
                etResult.setText("0.1")
            } else {
                etResult.setText("${etResult.text}1")
            }
        }
        btDua.setOnClickListener {
            if (koma) {
                etResult.setText("0.2")
            } else {
                etResult.setText("${etResult.text}2")
            }
        }
        btTiga.setOnClickListener {
            if (koma) {
                etResult.setText("0.3")
            } else {
                etResult.setText("${etResult.text}3")
            }
        }
        btEmpat.setOnClickListener {
            if (koma) {
                etResult.setText("0.4")
            } else {
                etResult.setText("${etResult.text}4")
            }
        }
        btLima.setOnClickListener {
            if (koma) {
                etResult.setText("0.5")
            } else {
                etResult.setText("${etResult.text}5")
            }
        }
        btEnam.setOnClickListener {
            if (koma) {
                etResult.setText("0.6")
            } else {
                etResult.setText("${etResult.text}6")
            }
        }
        btTujuh.setOnClickListener {
            if (koma) {
                etResult.setText("0.7")
            } else {
                etResult.setText("${etResult.text}7")
            }
        }
        btDelapan.setOnClickListener {
            if (koma) {
                etResult.setText("0.8")
            } else {
                etResult.setText("${etResult.text}8")
            }
        }
        btSembilan.setOnClickListener {
            if (koma) {
                etResult.setText("0.9")
            } else {
                etResult.setText("${etResult.text}9")
            }
        }
        btKoma.setOnClickListener {
            if (etResult.text.isNotEmpty()) {
                etResult.setText("${etResult.text}.")
            } else {
                koma = true
            }
        }
        btTambah.setOnClickListener {
            IsiData()
            aksi = "tambah"
        }
        btKurang.setOnClickListener {
            IsiData()
            aksi = "kurang"
        }
        btBagi.setOnClickListener {
            IsiData()
            aksi = "bagi"
        }
        btKali.setOnClickListener {
            IsiData()
            aksi = "kali"
        }
        btPersen.setOnClickListener {
            if (etResult.text.isNotEmpty()) {
                try {
                    val currentValue = etResult.text.toString().replace(',', '.').toDouble()

                    if (aksi.isNotEmpty() && NilaiAwal != 0.0) {
                        // Skenario: menghitung persen dari operasi sebelumnya
                        when (aksi) {
                            "tambah" -> {
                                // Contoh: 200 + 50% = 200 + (200 * 0.5) = 300
                                val persenValue = NilaiAwal * (currentValue / 100)
                                etResult.setText(persenValue.toString())
                            }
                            "kurang" -> {
                                // Contoh: 200 - 50% = 200 - (200 * 0.5) = 100
                                val persenValue = NilaiAwal * (currentValue / 100)
                                etResult.setText(persenValue.toString())
                            }
                            "kali" -> {
                                // Contoh: 200 * 50% = 200 * 0.5 = 100
                                val persenValue = currentValue / 100
                                etResult.setText(persenValue.toString())
                            }
                            "bagi" -> {
                                // Contoh: 200 / 50% = 200 / 0.5 = 400
                                val persenValue = currentValue / 100
                                etResult.setText(persenValue.toString())
                            }
                        }
                    } else {
                        // Skenario: hanya mengubah angka menjadi persen
                        // Contoh: 50% = 0.5
                        val persenValue = currentValue / 100
                        etResult.setText(persenValue.toString())
                    }
                } catch (e: NumberFormatException) {
                    etResult.setText("Error")
                }
            }
        }
        btHasil.setOnClickListener {
            if (etResult.text.isNotEmpty() && aksi.isNotEmpty()) {
                try {
                    val decimalFormat = DecimalFormat("#.###")
                    val currentValue = etResult.text.toString().toDouble()
                    val hasilPerhitungan = when (aksi) {
                        "tambah" -> NilaiAwal + currentValue
                        "kurang" -> NilaiAwal - currentValue
                        "kali" -> NilaiAwal * currentValue
                        "bagi" -> if (currentValue != 0.0) NilaiAwal / currentValue else Double.NaN
                        else -> currentValue
                    }
                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    etResult.setText(hasilTerformat)
                    aksi = ""
                } catch (e: NumberFormatException) {
                    etResult.setText("Error")
                }
            }
        }
    }

}

