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


        // создаем обьект следящий за заполнением текста в полях
//        val loginEmailPassword = object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//            override fun afterTextChanged(p0: Editable?) {}
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
////                    if (textEmail.isNotEmpty() && textPass.isNotEmpty() && checkBox.isChecked)
////                        buttonLogin.isEnabled = true
//            }


 // создаем слушателя для ввода текста, который запускаест функцию проверки заполнения полей

        val loginEmailPassword = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                verificationEmailPasswordChekbox()
            }
        }

        bindingClass.chekboxExemple.setOnCheckedChangeListener { checkboxView, check ->
        }

        bindingClass.loginButton.setOnClickListener {
            login()
        }

    }
// функция проверки полей, если поля и чекбокс активны, включается кнопка
    fun verificationEmailPasswordChekbox() {

        bindingClass.loginButton.isEnabled = false

        if (bindingClass.textEmailAddress.toString()
                .isNotEmpty() && bindingClass.textPassword.toString()
                .isNotEmpty() && bindingClass.chekboxExemple.isChecked
        )
            bindingClass.loginButton.isEnabled = true
            login()
    }

    private fun login() {
        bindingClass.loginButton.isEnabled = false
        bindingClass.operationProgress.visibility = View.VISIBLE
        bindingClass.textEmailAddress.isEnabled = false
        bindingClass.textPassword.isEnabled = false
        bindingClass.chekboxExemple.isEnabled = false


        // оповещение об активации кнопки
        // что происходит = метод создания оповещения. показать текст(контекст, ресурс текста, время показа), отобразить оповещение.
        Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            bindingClass.loginButton.isEnabled = true
            bindingClass.operationProgress.visibility = View.INVISIBLE
            bindingClass.textEmailAddress.isEnabled = true
            bindingClass.textPassword.isEnabled = true
            bindingClass.chekboxExemple.isEnabled = true

            Toast.makeText(this, R.string.toast_login, Toast.LENGTH_SHORT).show()
        }, 2000)
    }
// При нажатии кнопки должна деактивироваться кнопка,
    }










