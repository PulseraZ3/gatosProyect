package com.leoanrdo.gatosproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    lateinit var btnAdios: Button
    lateinit var btnNuevo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnAdios = findViewById(R.id.btnPrincipal)
        btnNuevo = findViewById(R.id.btnNuevo)

        btnAdios.setOnClickListener {
            val intent = Intent(this, ListaPostActivity::class.java)
            startActivity(intent)
        }
        btnNuevo.setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
    }

}