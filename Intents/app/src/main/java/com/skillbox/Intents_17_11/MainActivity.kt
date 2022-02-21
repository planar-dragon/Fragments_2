package com.skillbox.Intents_17_11

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.Intents_17_11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding

    val tag = "MainActivity"

    // Переменная в которую сохраняется формат ошибки
    var stateEmailPassword: FormState? = FormState(false, "Пароль и логин не введены")

    // переназначение функции отрисовки экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindingClass.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentView, LoginFragment.newLoginFragment()).commit()

        VerboseLoger.v(tag, "MAIN_INFO Жизненный цикл Activity - onCreate")

////        val alreadyLoginFragment =
////            supportFragmentManager.findFragmentById(R.id.fragmentView) != null
//
////        if (!alreadyLoginFragment) {
////            supportFragmentManager.beginTransaction()
////                .replace(R.id.fragmentView, LoginFragment.newLoginFragment()).commit()
////
////        } else {
//            bindingClass.loginButton!!.setOnClickListener() {
//
//                val textEmailAddress = bindingClass.textEmailAddress!!.text.toString()
//
//                //создание джава класса, который используем в создании Intent
////            val activityClass: Class<MainActivitySecond> = MainActivitySecond::class.java
//
////            // создадим переменную которая будет создавать Intent и запускать второй активити
////            val secondActivitiIntent = Intent(
////
////                this, activityClass
////            ).putExtra(MainActivitySecond.KEY_MESSAGE, textEmailAddress)
//                // в старт активити передаем созданный интент
////            startActivity(secondActivitiIntent)
//                startActivity(MainActivitySecond.getIntent(this, textEmailAddress))
//                val viewProgressBar: View =
//                    layoutInflater.inflate(
//                        R.layout.activity_main,
//                        bindingClass.containerProgressBar,
//                        false
//                    )
//// Прописываем когда запускается контейнер с Progress Bar
////            viewProgressBar.apply {}
//                login()
//                bindingClass.containerProgressBar!!.addView(viewProgressBar)
//                bindingClass.containerProgressBar!!.removeView(viewProgressBar)
////                validation(stateEmailPassword!!.message)
//                finish()
//
//            }
//
//// создаем переменную TextWatcher для ввода логина и пароля, в которой идет проверка заполнения
//            val loginEmailPassword = object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun afterTextChanged(p0: Editable?) {}
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    verificationEmailPasswordChekbox()
//                }
//            }
//// Слушатели ввода логина и пароля
//            bindingClass.textEmailAddress!!.addTextChangedListener(loginEmailPassword)
//
//            bindingClass.textPassword!!.addTextChangedListener(loginEmailPassword)
//
//// Cлушатель Checkbox, запускающий функцию проверку заполнения полей логина и пароля.
//
//            bindingClass.chekboxExemple!!.setOnCheckedChangeListener() { checkboxView, isChecked ->
//                verificationEmailPasswordChekbox()
//                hideSoftKeyboard()
//
//            }
//
//        }
//
//
//    // создаем константы куда сохраняется значение
////    companion object {
////        private const val KEY_EMAIL_PASS = "EMAIL_PASSWORD"
    }

    override fun onStart() {
        super.onStart()
        VerboseLoger.v(tag, "MAIN_INFO: Жизненный цикл Activity - onStart, ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        VerboseLoger.v(tag, "MAIN_INFO: Жизненный цикл Activity - onResume, ${hashCode()}")
    }

    // функция сохранения состояния
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // внутри( константа для сохранения, переменная которую нужно сохранить)
        outState.putParcelable(Constants.KEY_EMAIL_PASS, stateEmailPassword)
        VerboseLoger.v(
            tag,
            "MAIN_INFO: Сохранение состояния переменных: valid = ${stateEmailPassword!!.valid}, message = ${stateEmailPassword!!.message}"
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        stateEmailPassword = savedInstanceState.getParcelable(Constants.KEY_EMAIL_PASS) ?: error("Ошибка")
        VerboseLoger.v(
            tag,
            "MAIN_INFO: Востановление состояния переменных: valid = ${stateEmailPassword!!.valid}, message = ${stateEmailPassword!!.message}"
        )
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        VerboseLoger.v(
            tag,
            "MAIN_INFO: Жизненный цикл Activity - onTopResumedActivityChanged $isTopResumedActivity, ${hashCode()}"
        )
    }

    override fun onPause() {
        super.onPause()
        VerboseLoger.v(tag, "MAIN_INFO: Жизненный цикл Activity - onPause, ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        VerboseLoger.v(tag, "MAIN_INFO: Жизненный цикл Activity - onStop, ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        VerboseLoger.v(tag, "MAIN_INFO: Жизненный цикл Activity - onDestroy, ${hashCode()}")
    }

//// Функция проверки заполнения полей логина и пароля.
//
//    private fun verificationEmailPasswordChekbox() {
//        when {
//            bindingClass.textEmailAddress!!.text.isEmpty() && bindingClass.textPassword!!.text.isEmpty()
//            -> {
//                stateEmailPassword = FormState(false, "Не введен логин и пароль!")
//                VerboseLoger.v(tag!!, "MAIN_INFO: Не введен логин и пароль!")
//            }
//
//            bindingClass.textEmailAddress!!.text.isEmpty()
//            -> {
//                stateEmailPassword = FormState(false, "Не введен логин!")
//                VerboseLoger.v(tag, "MAIN_INFO: Не введен логин!")
//            }
//
//            bindingClass.textPassword!!.text.isEmpty()
//            -> {
//                stateEmailPassword = FormState(false, "Не введен пароль!")
//                VerboseLoger.v(tag, "MAIN_INFO: Не введен пароль!")
//            }
//
//            !bindingClass.chekboxExemple!!.isChecked
//            -> {
//                stateEmailPassword = FormState(false, "Примите соглашение!")
//                VerboseLoger.v(tag, "MAIN_INFO: Примите соглашение!")
//            }
//
//            bindingClass.textEmailAddress!!.text.isNotEmpty() && bindingClass.textPassword!!.text.isNotEmpty() && bindingClass.chekboxExemple!!.isChecked
//            -> {
//                stateEmailPassword = FormState(true, "Валидация прошла успешно!")
//                VerboseLoger.v(tag, "MAIN_INFO: Валидация прошла успешно!")
//            }
//        }
//    }
//
//// Функция запуска кнопки "Вход", поля логин и пароль, Checkbox деактивируются.
//
//    private fun login() {
//        bindingClass.textEmailAddress!!.isEnabled = false
//        bindingClass.textPassword!!.isEnabled = false
//        bindingClass.chekboxExemple!!.isEnabled = false
//        bindingClass.operationProgress!!.visibility = View.VISIBLE
//        VerboseLoger.v(tag, "MAIN_INFO: Вход в никуда совершен!")
//// оповещение об активации кнопки
//// что происходит = метод создания оповещения. показать текст(контекст, ресурс текста, время показа), отобразить оповещение.
//
//        Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show()
//
//        Handler().postDelayed({
//            bindingClass.textEmailAddress!!.isEnabled = true
//            bindingClass.textPassword!!.isEnabled = true
//            bindingClass.chekboxExemple!!.isEnabled = true
//            bindingClass.operationProgress!!.visibility = View.INVISIBLE
//
//
//            Toast.makeText(this, R.string.toast_login, Toast.LENGTH_SHORT).show()
//        }, 2000)
//    }
//
//    // функция вывода текста в View
////    private fun validation(mess: String) {
////        bindingClass.errorForm?.text = mess
////    }
//
//    // функция убирает клавиатуру когда нажат чекбокс
//    fun hideSoftKeyboard() {
//        currentFocus?.let {
//            val inputMethodManager =
//                ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
//            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
//        }
//    }
}

object VerboseLoger {
    fun v(tag: String, message: String) {
        Log.v(tag, message)
    }
}













