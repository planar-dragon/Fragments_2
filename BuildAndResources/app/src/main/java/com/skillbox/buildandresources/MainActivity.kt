package com.skillbox.buildandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Переменная визуализации экрана. findViewById - поиск нужного текста по id в ресурсах (R.id.textView)
        val textView = findViewById<TextView>(R.id.textView)
// Заполнение найденной области на экране
        textView.text = """
        Build type = ${BuildConfig.BUILD_TYPE}
        Flavor = ${BuildConfig.FLAVOR}
        
        """
    }
}