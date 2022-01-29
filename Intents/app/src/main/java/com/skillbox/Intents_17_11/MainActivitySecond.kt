package com.skillbox.Intents_17_11

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.Intents_17_11.databinding.ActivitySecondBinding


class MainActivitySecond : AppCompatActivity(R.layout.activity_second) {
    lateinit var bindingClassSecond: ActivitySecondBinding
    private val tag2 = "MainActivitySecond"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aктивировать класс Разметки
        bindingClassSecond = ActivitySecondBinding.inflate(layoutInflater)
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClassSecond.root)



        val message = intent.getStringExtra(KEY_MESSAGE)
        bindingClassSecond.phoneNumberVerificationView.text = message
        VerboseLoger.v(tag2, "MAIN_INFO Жизненный цикл ActivitySecond - onCreate")

        bindingClassSecond.phoneDialing.setOnClickListener {
            dial()
        }
    }

// функция набора номера, где внутри происходит проверка номера и создается

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

// Если все верно запускается окно вызова
        } else {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
// проверим, что существует компонент, который может обработать созданный неявный интент.
            if (phoneIntent.resolveActivity(packageManager) != null) {
// Запускаем Интент Набора номера сохраненный в переменную, чтоб получить результат работы активити
                startActivityForResult(phoneIntent, PHONE_REQUEST_CODE)
            } else {
                toast("Нет компонента для обработки звонка")
            }
        }
    }


    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    // колбэк (код который сохраняется при запуске активити, проверка было ли действие произведено успешно, данные в интенте data

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // сравение requestCode
        if (requestCode == PHONE_REQUEST_CODE) {
            // поверка успешности запуска
            if (resultCode == Activity.RESULT_OK) {
                toast("Звонок запущен!")
            } else {
                toast("Звонок отменен!")
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
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
        // константу делаем приватной, чтоб никто кроме класса MainActivitySecond
        private const val KEY_MESSAGE = "message key"

        // константа для сохранения результата
        private const val PHONE_REQUEST_CODE = 321

        // функция для создания Intent
        fun getIntent(context: Context, message: String?): Intent {
            // возвращаем полностью сформированный intent для запуска второго активити
            return Intent(context, MainActivitySecond::class.java)
                .putExtra(KEY_MESSAGE, message)
        }
    }
}