package com.skillbox.Intents_17_11

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Intents_17_11.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var bindingLoginFragment: LoginFragmentBinding

    var stateEmailPassword: FormState? = FormState(false, "Пароль и логин не введены")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingLoginFragment = LoginFragmentBinding.inflate(inflater)
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onCreateView")

        return bindingLoginFragment.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onAttach")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onActivityCreated")

        bindingLoginFragment.loginButton.setOnClickListener() {

            val textEmailAddress = bindingLoginFragment.textEmailAddress.text.toString()

            startActivity(MainActivitySecond.getIntent(this, textEmailAddress))
            val viewProgressBar: View =
                layoutInflater.inflate(
                    R.layout.activity_main,
                    bindingLoginFragment.containerProgressBar,
                    false
                )

            login()
            bindingLoginFragment.containerProgressBar.addView(viewProgressBar)
            bindingLoginFragment.containerProgressBar.removeView(viewProgressBar)
//                validation(stateEmailPassword!!.message)
//            finish()

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
        bindingLoginFragment.textEmailAddress.addTextChangedListener(loginEmailPassword)

        bindingLoginFragment.textPassword.addTextChangedListener(loginEmailPassword)

// Cлушатель Checkbox, запускающий функцию проверку заполнения полей логина и пароля.

        bindingLoginFragment.chekboxExemple.setOnCheckedChangeListener() { checkboxView, isChecked ->
            verificationEmailPasswordChekbox()
//            hideSoftKeyboard()

        }
    }

// Функция запуска кнопки "Вход", поля логин и пароль, Checkbox деактивируются.

    fun login() {
        bindingLoginFragment.textEmailAddress.isEnabled = false
        bindingLoginFragment.textPassword.isEnabled = false
        bindingLoginFragment.chekboxExemple.isEnabled = false
        bindingLoginFragment.operationProgress.visibility = View.VISIBLE
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Вход в никуда совершен!")

        Handler().postDelayed({
            bindingLoginFragment.textEmailAddress.isEnabled = true
            bindingLoginFragment.textPassword.isEnabled = true
            bindingLoginFragment.chekboxExemple.isEnabled = true
            bindingLoginFragment.operationProgress.visibility = View.INVISIBLE

        }, 2000)
    }

    fun verificationEmailPasswordChekbox() {
        when {
            bindingLoginFragment.textEmailAddress.text.isEmpty() && bindingLoginFragment.textPassword.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен логин и пароль!")
                Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Не введен логин и пароль!")
            }

            bindingLoginFragment.textEmailAddress.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен логин!")
                Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Не введен логин!")
            }

            bindingLoginFragment.textPassword.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен пароль!")
                Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Не введен пароль!")
            }

            !bindingLoginFragment.chekboxExemple.isChecked
            -> {
                stateEmailPassword = FormState(false, "Примите соглашение!")
                Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Примите соглашение!")
            }

            bindingLoginFragment.textEmailAddress.text.isNotEmpty() && bindingLoginFragment.textPassword.text.isNotEmpty() && bindingLoginFragment.chekboxExemple.isChecked
            -> {
                stateEmailPassword = FormState(true, "Валидация прошла успешно!")
                Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: Валидация прошла успешно!")
            }
        }
    }

    // функция вывода текста в View
    fun validation(mess: String) {
        bindingLoginFragment.errorForm.text = mess
    }

    // функция убирает клавиатуру когда нажат чекбокс
//    fun Activity.hideSoftKeyboard() {
//        currentFocus?.let {
//            val inputMethodManager =
//                ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
//            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
//        }
//    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onStart, ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onResume, ${hashCode()}")
    }

    // функция сохранения состояния
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // внутри( константа для сохранения, переменная которую нужно сохранить)
        outState.putParcelable(Constants.KEY_EMAIL_PASS, stateEmailPassword)
        Log.d(
            tag,
            "MAIN_INFO Жизненный цикл Fragment: Сохранение состояния переменных: valid = ${stateEmailPassword!!.valid}, message = ${stateEmailPassword!!.message}"
        )
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        stateEmailPassword =
//            savedInstanceState.getParcelable(Constants.KEY_EMAIL_PASS) ?: error("Ошибка")
//        Log.d(
//            tag,
//            "MAIN_INFO Жизненный цикл Fragment: Востановление состояния переменных: valid = ${stateEmailPassword!!.valid}, message = ${stateEmailPassword!!.message}"
//        )
//    }
//
//    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
//        super.onTopResumedActivityChanged(isTopResumedActivity)
//        Log.d(
//            tag,
//            "MAIN_INFO Жизненный цикл Fragment: onTopResumedActivityChanged $isTopResumedActivity, ${hashCode()}"
//        )
//    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onPause, ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onStop, ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onDestroy, ${hashCode()}")
    }

    override fun onDestroyView() {
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onDestroyView ${hashCode()}")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d(tag, "MAIN_INFO Жизненный цикл Fragment: onDetach ${hashCode()}")
        super.onDetach()
    }

    companion object {

        @JvmStatic
        fun newLoginFragment() = LoginFragment()
    }
}