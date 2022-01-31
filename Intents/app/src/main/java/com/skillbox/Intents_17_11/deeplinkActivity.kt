package com.skillbox.Intents_17_11

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.Intents_17_11.databinding.ActivityHarbBinding

class harbActivity : AppCompatActivity(R.layout.activity_harb) {

    lateinit var bindingClassHerb: ActivityHarbBinding

    private val tag3 = "harbActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // aктивировать класс Разметки
        bindingClassHerb = ActivityHarbBinding.inflate(layoutInflater)
        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClassHerb.root)
        val message = intent.getStringExtra(KEY_DEEPLINK)
        bindingClassHerb.deeplinkPage.text = message
        hanleIntentData()
    }


    // https://shikimori.one/animes

    private fun hanleIntentData() {
        intent.data?.lastPathSegment?.let { herbName ->
            VerboseLoger.v(tag3, "MAIN_INFO: https://shikimori.one/animes")
            bindingClassHerb.harbTextView.text = herbName
        }
    }

    companion object {
        // константу делаем приватной, чтоб никто кроме класса MainActivitySecond
        private const val KEY_DEEPLINK = "message key"

        // константа для сохранения результата
        private const val PHONE_REQUEST_CODE = 321

        // функция для создания Intent
        fun getIntent2(context: Context, message: String?): Intent {
            // возвращаем полностью сформированный intent для запуска второго активити
            return Intent(context, harbActivity::class.java)
                .putExtra(KEY_DEEPLINK, message)
        }


    }

}


