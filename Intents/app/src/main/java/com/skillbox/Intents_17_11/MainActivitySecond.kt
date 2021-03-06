package com.skillbox.Intents_17_11

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.Intents_17_11.databinding.ActivitySecondBinding


class MainActivitySecond : AppCompatActivity(R.layout.activity_second) {

    lateinit var bindingClassSecond: ActivitySecondBinding

    private val tag2 = "MainActivitySecond"

    lateinit var plouncher: ActivityResultLauncher<String>

    // Ланчер (Контракт) для запуска активити звонка
    private val launcherDial =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultDial: ActivityResult ->
            if (resultDial.resultCode == Activity.RESULT_CANCELED) {
// результат запуска активити звонка
                val resultDialActivity = resultDial.data

                VerboseLoger.v(tag2, "MAIN_INFO: Получили результат звонка - $resultDialActivity")

                toast("Получили результат звонка - $resultDialActivity")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aктивировать класс Разметки
        bindingClassSecond = ActivitySecondBinding.inflate(layoutInflater)

        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClassSecond.root)

        val message = intent.getStringExtra(Constants.KEY_MESSAGE)
        bindingClassSecond.phoneNumberVerificationView.text = message

        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onCreate")

        bindingClassSecond.phoneDialing.setOnClickListener {
            dial()
        }
    }

// функция вызова номера, где внутри происходит валидация номера и запускается функция набора номера

    @SuppressLint("QueryPermissionsNeeded")
    private fun dial() {

        // Переменная куда сохраняется введенный номер телефона
        val phoneNumber = bindingClassSecond.phoneNumberView.text.toString()

// Переменная где сохранили шаблон (Pattern) набора номера телефона
        val patternPhone =
            Regex(pattern = """^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}${'$'}""")

// Проверка соответствия введенного номера шаблону
        val isPhoneValid = patternPhone.matches(phoneNumber)

// Если номер некорректный выводится сообщение
        if (!isPhoneValid) {
            toast("Введите корректный номер телефона")
            VerboseLoger.v(tag2,"MAIN_INFO: ActivitySecond - Введите корректный номер телефона, ${hashCode()}")

// Если все верно запускается окно вызова
        } else {
            dialingNumber(phoneNumber)
        }
    }

    // функция проверки компонентов для дозвона и набора номера
    private fun dialingNumber(phoneNumber: String) {

// Переменная в которой сохранен интент дозвона
        val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")

            VerboseLoger.v(tag2, "MAIN_INFO: ActivitySecond - Запускается окно вызова, ${hashCode()}")
        }
// проверим, что существует компонент, который может обработать созданный неявный интент.
        if (phoneIntent.resolveActivity(packageManager) != null) {

            VerboseLoger.v(tag2,"MAIN_INFO: ActivitySecond - Проверка наличия компонентов для обработки интента, ${hashCode()}")

// Запускаем Контракт набора номера
            launcherDial.launch(phoneIntent)

        } else {
            toast("Нет компонента для обработки звонка")
            VerboseLoger.v(tag2,"MAIN_INFO:  ActivitySecond - Нет компонента для обработки звонка, ${hashCode()}")
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onStart, ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onResume, ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onPause, ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onStop, ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        VerboseLoger.v(tag2, "MAIN_INFO: Жизненный цикл ActivitySecond - onDestroy, ${hashCode()}")
    }

    companion object {

// функция для создания Intent
        fun getIntent(context: MainActivity, message: String?): Intent {

// возвращаем полностью сформированный intent для запуска второго активити
            return Intent(context, MainActivitySecond::class.java)
                .putExtra(Constants.KEY_MESSAGE, message)
        }
    }
}