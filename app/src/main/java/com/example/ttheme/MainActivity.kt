package com.example.ttheme

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.example.ttheme.Keys.KEY_CURRENT_THEME
import com.example.ttheme.Keys.KEY_THEME_GREEN
import com.example.ttheme.Keys.KEY_THEME_PINK
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var sharedPref: SharedPreferences
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(Keys.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE)
        val currentTheme = sharedPref.getString(KEY_CURRENT_THEME, KEY_THEME_PINK)
        switchTheme.isChecked = currentTheme == KEY_THEME_PINK
        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                sharedPref.edit().putString(KEY_CURRENT_THEME, KEY_THEME_PINK).apply()
            else
                sharedPref.edit().putString(KEY_CURRENT_THEME, KEY_THEME_GREEN).apply()
            recreate()
        }
        button.setOnClickListener { Dialog().show(supportFragmentManager, "dialog") }
    }
}
