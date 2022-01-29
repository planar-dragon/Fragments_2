package com.skillbox.Intents_17_11

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class MainActivitySecond : AppCompatActivity(R.layout.activity_second) {

    private val tag2 = "MainActivitySecond"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra(KEY_MESSAGE)
        phoneNumberVerificationView.text = message
        VerboseLoger.v(tag2, "MAIN_INFO Жизненный цикл ActivitySecond - onCreate")

        phoneDialing.setOnClickListener() {

// Переменная куда сохраняется введенный номер телефона
            val phoneNumber = phoneNumberView.text.toString()

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
                startActivity(phoneIntent)
            }
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
        // константу делаем приватной, чтоб никто кроме класса MainActivitySecond
        private const val KEY_MESSAGE = "message key"

        // функция
        fun getIntent(context: Context, message: String?): Intent {
            // возвращаем полностью сформированный intent для запуска второго активити
            return Intent(context, MainActivitySecond::class.java)
                .putExtra(KEY_MESSAGE, message)
        }
    }
}