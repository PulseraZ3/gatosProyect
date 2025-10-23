package com.leoanrdo.gatosproyecto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnboardingAdapter
    private lateinit var btnNext: MaterialButton
    private lateinit var btnSkip: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        viewPager = findViewById(R.id.viewPagerOnboarding)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)

        val pantallas = listOf(
            OnboardingItem(R.drawable.ic_dog, "Explora", "Descubre publicaciones de gatos adorables."),
            OnboardingItem(R.drawable.ic_dog, "Comparte", "Publica tus propias fotos y comenta."),
            OnboardingItem(R.drawable.ic_dog, "Conecta", "Sigue a otros amantes de los gatos.")
        )

        adapter = OnboardingAdapter(pantallas)
        viewPager.adapter = adapter

        btnSkip.setOnClickListener { irAlLogin() }

        btnNext.setOnClickListener {
            if (viewPager.currentItem + 1 < pantallas.size) {
                viewPager.currentItem += 1
            } else {
                irAlLogin()
            }
        }
    }

    private fun irAlLogin() {
        getSharedPreferences("GatosPref", MODE_PRIVATE)
            .edit()
            .putBoolean("onboarding_visto", true)
            .apply()

        startActivity(Intent(this, ListaPostActivity::class.java))
        finish()
    }
}