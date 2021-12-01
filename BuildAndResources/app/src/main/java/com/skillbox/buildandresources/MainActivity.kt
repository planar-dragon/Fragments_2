package com.skillbox.buildandresources

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Переменная визуализации экрана. findViewById - поиск нужного текста по id в ресурсах (R.id.textView)
        val textView = findViewById<TextView>(R.id.textView)

        val count = 1
        val pluralString = resources.getQuantityString(R.plurals.main_quantity_string, count, count)
// доступ к ресурсу, для получения множественной строки с идентификатором main_quantity_string
// 2 значение - строка которая соответствует переменной count
// 3 значение - строка значение которое будет вставленно в слот отображения значения
// Устанавливаем в параметр текста переменнцю с изменяемой строкой
        textView.text = pluralString

// Заполнение найденной области на экране, редыдущее использование textView.text перекроется
        textView.text = """
        Build type = ${BuildConfig.BUILD_TYPE}
        Flavor = ${BuildConfig.FLAVOR}
        VersionCode =${BuildConfig.VERSION_CODE}
        VersionName =${BuildConfig.VERSION_NAME}
        """
    }
}