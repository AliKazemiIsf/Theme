package com.example.ttheme

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ttheme.Keys.KEY_CURRENT_THEME
import com.example.ttheme.Keys.KEY_PREFERENCE_NAME
import com.example.ttheme.Keys.KEY_THEME_PINK

open class BaseActivity: AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    private var currentTheme: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTTheme()
    }

    private fun getTTheme() {
        sharedPref = getSharedPreferences(KEY_PREFERENCE_NAME, Context.MODE_PRIVATE)
        currentTheme = sharedPref.getString(KEY_CURRENT_THEME, KEY_THEME_PINK)
        if (currentTheme.equals(KEY_THEME_PINK))
            setTheme(R.style.AppTheme_PINK)
        else
            setTheme(R.style.AppTheme_GREEN)
    }

    override fun onRestart() {
        super.onRestart()
        val theme = sharedPref.getString(KEY_CURRENT_THEME, KEY_THEME_PINK)
        currentTheme?.let {
            if (currentTheme != theme)
                recreate()
        }
    }
}