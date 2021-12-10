package com.skillbox.ViewAndLayout1

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClass.root)

        // Для отривовки элементов их надо найти в ресурсах по id.
        // val TextView(элемент экрана) = findViewById(поиск)<TextView>(класс элемента)(R.id.TextView)(путь для поиска в ресурсах)
//        val textView = findViewById<TextView>(R.id.TextView)
        // изменение текста на другой
//        textView.text="new text"
        // изменение текста на другой, взятый из строки
//        textView.setText(R.string.TextView)

//        val inputTextEmailAddress = findViewById<EditText>(R.id.textEmailAddress)

//        val inputTextPassword = findViewById<EditText>(R.id.textPassword)
        // Создаем переменную куда сохраняется техст ввода логин
//        val inputNameText = findViewById<TextView>(R.id.greetingsText)


        // создаем слушателя для ввода текста

        bindingClass.textEmailAddress.addTextChangedListener(object : TextWatcher {
            var textEmail: Boolean = true
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                // кнопка включается когда поле ввода заполнено (проверка заполненности, если заполненно то включено)
                bindingClass.loginButton.isEnabled = p0?.let {it.isNotEmpty()} ?:false

            }
        }
        )

        bindingClass.textPassword.addTextChangedListener(object : TextWatcher {
            var textPass: Boolean = true
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                // кнопка включается когда поле ввода заполнено (проверка заполненности, если заполненно то включено)
                bindingClass.loginButton.isEnabled = p0?.let {it.isNotEmpty()} ?:false
            }
        }
        )

        bindingClass.chekboxExemple.setOnCheckedChangeListener { checkboxView, check ->
        }

        if (bindingClass.textEmailAddress.text.isNotEmpty() && bindingClass.textPassword.text.isNotEmpty() && bindingClass.chekboxExemple.isChecked) {
            bindingClass.loginButton.isEnabled = true
        }

        // создаем слушателя для кнопки:
        // 1. прогресс бар становится видимым
        // 2. поля ввода становятся неактивными
        // 3. чек бокс становятся неактивным
        // 4. кнопка становятся неактивной

        bindingClass.loginButton.setOnClickListener {
            bindingClass.operationProgress.visibility = View.VISIBLE
            bindingClass.textEmailAddress.isEnabled = false
            bindingClass.textPassword.isEnabled = false
            bindingClass.loginButton.isEnabled = false
            bindingClass.chekboxExemple.isEnabled = false

            // оповещение об активации кнопки
            // что происходит = метод создания оповещения. показать текст(контекст, ресурс текста, время показа), отобразить оповещение.
            Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                bindingClass.operationProgress.visibility = View.GONE
                bindingClass.textEmailAddress.isEnabled = true
                bindingClass.textPassword.isEnabled = true
                bindingClass.loginButton.isEnabled = true
                bindingClass.chekboxExemple.isEnabled = true
                Toast.makeText(this, R.string.toast_login, Toast.LENGTH_SHORT).show()
            }, 2000)
        }

    }
}


