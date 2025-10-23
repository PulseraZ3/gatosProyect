package com.leoanrdo.gatosproyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch

class ListaPostActivity : AppCompatActivity() {
    lateinit var database: AppDatabase
    lateinit var postDao: PostDao
    lateinit var rvLista: RecyclerView
    lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_post)

        database = AppDatabase.getOrCreateInstance(this)
        postDao = database.postDao()

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Para ti"))
        tabLayout.addTab(tabLayout.newTab().setText("Siguendo"))
        tabLayout.addTab(tabLayout.newTab().setText("Comunidades"))

        rvLista = findViewById(R.id.rvLista)
        rvLista.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch{
            val lista = postDao.obtenerLista()
            adapter = PostAdapter(lista)
            rvLista.adapter = adapter
        }

    }
}