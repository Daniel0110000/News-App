package com.example.newsapp.ui.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.domain.repository.NewsRepository
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        changeTheme()
        initNavigationView()
        binding.searchNews.setOnClickListener {
            startActivity(Intent(this, SearchNews::class.java))
        }
    }

    private fun initNavigationView() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        binding.openDrawer.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        val navView = findViewById<NavigationView>(R.id.nav_drawer)
        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }

    private fun changeTheme() {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}