package com.skillbox.Fragments_1_18_10

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
import com.skillbox.Fragments_1_18_10.databinding.LoginFragmentBinding

class LoginFragment() : Fragment(R.layout.login_fragment) {

    private lateinit var loginFragmentBinding: LoginFragmentBinding

    private val binding get() = loginFragmentBinding

    private var stateEmailPassword: FormState? = FormState(false, "Пароль и логин не введены")



    companion object {

        fun newLoginFragment(text: String): LoginFragment {
//            val fragment = LoginFragment()
//            val args = Bundle().apply {
//                putString(Constants.KEY_TEXT_LOGIN, text)
//            }
//            fragment.arguments = args
//            return fragment
            return LoginFragment().withArguments {
                putString(Constants.KEY_TEXT_LOGIN, text)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginFragmentBinding.anrButton.setOnClickListener {
            Thread.sleep(10000)
        }

        loginFragmentBinding.loginButton.setOnClickListener {

            val viewProgressBar: View =
                layoutInflater.inflate(R.layout.activity_main, loginFragmentBinding.containerProgressBar, false)
// Прописываем когда запускается контейнер с Progress Bar
            login()
            loginFragmentBinding.containerProgressBar.addView(viewProgressBar)
            loginFragmentBinding.containerProgressBar.removeView(viewProgressBar)
            validation(stateEmailPassword!!.message)
        }

        val loginEmailPassword = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                verificationEmailPasswordChekbox()
            }
        }
// Слушатели ввода логина и пароля
        loginFragmentBinding.textEmailAddress.addTextChangedListener(loginEmailPassword)

        loginFragmentBinding.textPassword.addTextChangedListener(loginEmailPassword)

// Cлушатель Checkbox, запускающий функцию проверку заполнения полей логина и пароля.

        loginFragmentBinding.chekboxExemple.setOnCheckedChangeListener { checkboxView, isChecked ->
            verificationEmailPasswordChekbox()


        }
    }
    // не знаю как сохранить состояние
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (savedInstanceState != null) {
            savedInstanceState.putParcelable(Constants.KEY_EMAIL_PASS, stateEmailPassword)
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        loginFragmentBinding = null!!
//    }


// Функция проверки заполнения полей логина и пароля.

    private fun verificationEmailPasswordChekbox() {
        when {
            loginFragmentBinding.textEmailAddress.text.isEmpty() && loginFragmentBinding.textPassword.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен логин и пароль!")
            }

            loginFragmentBinding.textEmailAddress.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен логин!")
            }

            loginFragmentBinding.textPassword.text.isEmpty()
            -> {
                stateEmailPassword = FormState(false, "Не введен пароль!")
            }

            !loginFragmentBinding.chekboxExemple.isChecked
            -> {
                stateEmailPassword = FormState(false, "Примите соглашение!")
            }

            loginFragmentBinding.textEmailAddress.text.isNotEmpty() && loginFragmentBinding.textPassword.text.isNotEmpty() && loginFragmentBinding.chekboxExemple.isChecked
            -> {
                stateEmailPassword = FormState(true, "Валидация прошла успешно!")
            }
        }
    }

// Функция запуска кнопки "Вход", поля логин и пароль, Checkbox деактивируются.

    private fun login() {
        loginFragmentBinding.textEmailAddress.isEnabled = false
        loginFragmentBinding.textPassword.isEnabled = false
        loginFragmentBinding.chekboxExemple.isEnabled = false
        loginFragmentBinding.operationProgress.visibility = View.VISIBLE

// оповещение об активации кнопки
// что происходит = метод создания оповещения. показать текст(контекст, ресурс текста, время показа), отобразить оповещение.

        Handler().postDelayed({
            loginFragmentBinding.textEmailAddress.isEnabled = true
            loginFragmentBinding.textPassword.isEnabled = true
            loginFragmentBinding.chekboxExemple.isEnabled = true
            loginFragmentBinding.operationProgress.visibility = View.INVISIBLE

        }, 2000)
    }

    // функция вывода текста в View
    private fun validation(mess: String) {
        loginFragmentBinding.errorForm.text = mess
    }
}