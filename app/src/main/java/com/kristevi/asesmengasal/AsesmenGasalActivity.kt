package com.kristevi.asesmengasal

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class AsesmenGasalActivity : AppCompatActivity() {
    // langkah 1, inisialisasi
    lateinit var card1 : CardView
    lateinit var card2 : CardView
    lateinit var card3 : CardView
    lateinit var card4 : CardView
    lateinit var card5 : CardView
    lateinit var card6 : CardView
    lateinit var card7 : CardView
    lateinit var card8 : CardView
    lateinit var tvDashboard : TextView
    lateinit var tvSapa : TextView
    lateinit var tvMateri : TextView
    lateinit var tvAplikasi : TextView
    lateinit var cardDash : CardView
    lateinit var img5 : ImageView
    lateinit var img6 : ImageView
    lateinit var img7 : ImageView
    lateinit var img8 : ImageView
    lateinit var tvcard1 : TextView
    lateinit var tvcard2 : TextView
    lateinit var tvcard3 : TextView
    lateinit var tvcard4 : TextView
    lateinit var tvcard5 : TextView
    lateinit var tvcard6 : TextView
    lateinit var tvcard7 : TextView
    lateinit var tvcard8 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_asesmen_gasal)

        // menghubungkan cardview dari layout
        val card5 : CardView = findViewById(R.id.card5)
        card5.setOnClickListener {
            // membuat  intent untuk memulai activity kelima
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val card6 : CardView = findViewById(R.id.card6)
        card6.setOnClickListener {
            // membuat  intent untuk memulai activity keenam
            val intent = Intent(this, KonversiSuhuActivity::class.java)
            startActivity(intent)
        }
        val card7 : CardView = findViewById(R.id.card7)
        card7.setOnClickListener {
            // membuat  intent untuk memulai activity ketujuh
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }
        val card8 : CardView = findViewById(R.id.card8)
        card8.setOnClickListener {
            // membuat  intent untuk memulai activity kedelapan
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun init() {
        cardDash = findViewById(R.id.cardDash)
        tvDashboard = findViewById(R.id.tvDashboard)
        tvSapa = findViewById(R.id.tvSapa)
        tvMateri = findViewById(R.id.tvMateri)
        tvAplikasi = findViewById(R.id.tvAplikasi)
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)
        card3 = findViewById(R.id.card3)
        card4 = findViewById(R.id.card4)
        card5 = findViewById(R.id.card5)
        card6 = findViewById(R.id.card6)
        card7 = findViewById(R.id.card7)
        card8 = findViewById(R.id.card8)
        img5 = findViewById(R.id.img5)
        img6 = findViewById(R.id.img6)
        img7 = findViewById(R.id.img7)
        img8 = findViewById(R.id.img8)
        tvcard1 = findViewById(R.id.tvcard1)
        tvcard2 = findViewById(R.id.tvcard2)
        tvcard3 = findViewById(R.id.tvcard3)
        tvcard4 = findViewById(R.id.tvcard4)
        tvcard5 = findViewById(R.id.tvcard5)
        tvcard6 = findViewById(R.id.tvcard6)
        tvcard7 = findViewById(R.id.tvcard7)
        tvcard8 = findViewById(R.id.tvcard8)
    }
}