package com.skillbox.ViewAndLayout1

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.ViewAndLayout1.databinding.ActivityDynamicBinding
import com.skillbox.ViewAndLayout1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_dynamic.*
import kotlinx.android.synthetic.main.activity_dynamic.operationProgress

class MainActivity : AppCompatActivity() {
    // чтоб не использовать поиск по id, создаем переменную которая включает в себя все ссылки из activity_main.xml
    // это переменная включающая в себя класс Разметки
    lateinit var bindingClass: ActivityMainBinding
    lateinit var loginEmail: String
    lateinit var loginPassword: String

//    lateinit var bindingClassDinamic: ActivityDynamicBinding

    // переназначение функции отрисовки экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aктивировать класс Разметки
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClass.root)
//        bindingClassDinamic = ActivityDynamicBinding.inflate(layoutInflater)
//        setContentView(bindingClassDinamic.root)

// создаем переменную в которую поместим Вью ProgressBar
// inflate - создает view из ресурса разметки (ресурс, контейнер разметки, автоматический вывод)

        val viewProgressBar = layoutInflater.inflate(R.layout.activity_dynamic,containerProgressBar,true)

//// Вью ProgressBar запустится после нажатия кнопки "Вход"

        viewProgressBar.apply {
            bindingClass.loginButton.setOnClickListener() {
                val bindingClassDinamic = ActivityDynamicBinding.inflate(layoutInflater)
                setContentView(bindingClassDinamic.root)
                login()
            }
        }
        containerProgressBar.addView(viewProgressBar)

// Слушатели ввода логина и пароля

        bindingClass.textEmailAddress.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginEmail = this.toString()
            }
        })

        bindingClass.textPassword.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginPassword = this.toString()
            }
        })

// Cлушатель Checkbox, запускающий функцию проверку заполнения полей логина и пароля.

        bindingClass.chekboxExemple.setOnCheckedChangeListener() {checkboxView, isChecked ->
            verificationEmailPasswordChekbox()
        }

// Cлушатель кнопки "Вход", запускающий функцию login.

//        bindingClass.loginButton.setOnClickListener {
//            login()
//        }
    }

// Функция проверки заполнения полей логина и пароля.

    private fun verificationEmailPasswordChekbox() {
        if (loginEmail.isNotEmpty() && loginPassword.isNotEmpty() && bindingClass.chekboxExemple.isChecked)
            bindingClass.loginButton.isEnabled = true
    }

// Функция запуска кнопки "Вход", поля логин и пароль, Checkbox деактивируются.

    private fun login() {
        bindingClass.loginButton.isEnabled = false
        bindingClass.textEmailAddress.isEnabled = false
        bindingClass.textPassword.isEnabled = false
        bindingClass.chekboxExemple.isEnabled = false
        operationProgress.visibility = View.VISIBLE

// оповещение об активации кнопки
// что происходит = метод создания оповещения. показать текст(контекст, ресурс текста, время показа), отобразить оповещение.

        Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            bindingClass.loginButton.isEnabled = true
            bindingClass.textEmailAddress.isEnabled = true
            bindingClass.textPassword.isEnabled = true
            bindingClass.chekboxExemple.isEnabled = true
            operationProgress.visibility = View.INVISIBLE


            Toast.makeText(this, R.string.toast_login, Toast.LENGTH_SHORT).show()
        }, 2000)
    }

// Функция запуска ProgressBar

//    fun addProgressBar() {
//        operationProgress.visibility = View.VISIBLE
//
//        Handler().postDelayed({ operationProgress.visibility = View.INVISIBLE }, 2000)
//    }
}











