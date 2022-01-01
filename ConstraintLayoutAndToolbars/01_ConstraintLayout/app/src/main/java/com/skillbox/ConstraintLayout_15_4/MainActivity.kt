package com.skillbox.ConstraintLayout_15_4

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.skillbox.ViewAndLayout1.R
import com.skillbox.ViewAndLayout1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    // чтоб не использовать поиск по id, создаем переменную которая включает в себя все ссылки из activity_main.xml
    // это переменная включающая в себя класс Разметки
    lateinit var bindingClass: ActivityMainBinding
    var loginEmail: String = ""
    var loginPassword: String = ""

//    lateinit var bindingClassDinamic: ActivityDynamicBinding

    // переназначение функции отрисовки экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aктивировать класс Разметки
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClass.root)

// Вью ProgressBar запустится после нажатия кнопки "Вход"
// В переменную записываем контейнер в котором содержится Progress Bar
// inflate - создает view из ресурса разметки (ресурс, контейнер разметки, автоматический вывод)
        bindingClass.loginButton.setOnClickListener() {
            val viewProgressBar: View =
                layoutInflater.inflate(R.layout.activity_main, containerProgressBar, false)
// Прописываем когда запускается контейнер с Progress Bar
            viewProgressBar.apply {}
            login()
            containerProgressBar.addView(viewProgressBar)
        }

// создаем переменную TextWatcher для ввода логина и пароля, в которой идет проверка заполнения
        val loginEmailPassword = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                verificationEmailPasswordChekbox()
            }
        }
// Слушатели ввода логина и пароля
        bindingClass.textEmailAddress.addTextChangedListener(loginEmailPassword)

        bindingClass.textPassword.addTextChangedListener(loginEmailPassword)

// Cлушатель Checkbox, запускающий функцию проверку заполнения полей логина и пароля.

        bindingClass.chekboxExemple.setOnCheckedChangeListener() { checkboxView, isChecked ->
            verificationEmailPasswordChekbox()
            hideSoftKeyboard()

        }
    }

// Функция проверки заполнения полей логина и пароля.

    private fun verificationEmailPasswordChekbox() {
        if (bindingClass.textEmailAddress.text.isNotEmpty() && bindingClass.textPassword.text.isNotEmpty() && bindingClass.chekboxExemple.isChecked)
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

    // функция убирает клавиатуру когда нажат чекбокс
    fun Activity.hideSoftKeyboard() {
        currentFocus?.let {
            val inputMethodManager =
                ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}











