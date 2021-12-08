package com.skillbox.ViewAndLayout1

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.ViewAndLayout1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // чтоб не использовать поиск по id, создаем переменную которая включает в себя все ссылки из activity_main.xml
    // это переменная включающая в себя класс Разметки
    lateinit var bindingClass: ActivityMainBinding

    // переназначение функции отрисовки экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aктивировать класс Разметки
        bindingClass = ActivityMainBinding.inflate(LayoutInflater) {

        }
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClass.root)


        // Для отривовки элементов их надо найти в ресурсах по id.
        // val TextView(элемент экрана) = findViewById(поиск)<TextView>(класс элемента)(R.id.TextView)(путь для поиска в ресурсах)
//        val textView = findViewById<TextView>(R.id.TextView)
        // изменение текста на другой
//        textView.text="new text"
        // изменение текста на другой, взятый из строки
//        textView.setText(R.string.TextView)

        val inputTextEmailAddress = findViewById<EditText>(R.id.textEmailAddress)

        val inputTextPassword = findViewById<EditText>(R.id.textPassword)

        val inputNameText = findViewById<TextView>(R.id.greetingsText)
        // создаем слушателя для ввода текста
        inputTextEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                inputNameText.text = p0?.takeIf { it.isNotBlank() }
                    ?.let { login -> resources.getString(R.string.greetingsText, login) }
            }


        })

        bindingClass.loginButton.setOnClickListener {
            bindingClass.textEmailAddress.setText("")
        Toast.makeText(this,R.string.progress_Bar, Toast.LENGTH_SHORT).show()
        }
    }



}