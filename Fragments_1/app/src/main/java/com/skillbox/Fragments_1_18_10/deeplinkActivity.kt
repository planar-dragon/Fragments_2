package com.skillbox.Fragments_1_18_10

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skillbox.Fragments_1_18_10.databinding.ActivityDeeplinkBinding

class deeplinkActivity : AppCompatActivity(R.layout.activity_deeplink) {

    lateinit var bindingClassDeeplink: ActivityDeeplinkBinding

    private val tag3 = "harbActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aктивировать класс Разметки
        bindingClassDeeplink = ActivityDeeplinkBinding.inflate(layoutInflater)

        // Далее вводим ресурс из которого будут браться элементы отрисовки экрана
        setContentView(bindingClassDeeplink.root)
        VerboseLoger.v(tag3, "MAIN_INFO: Жизненный цикл ActivityDeeplink - onCreate, ${hashCode()}")





// Выводит сообщение в открытом активити
        val message = intent.getStringExtra(KEY_DEEPLINK)
        bindingClassDeeplink.deeplinkPage.text = "Вы нажали кнопку $message"
        hanleIntentData()

    }
// https://shikimori.one/animes/34542-inuyashiki
// ункция обрабатывающая deeplink
    private fun hanleIntentData() {
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData: Uri? = intent.data
        if (Intent.ACTION_VIEW == appLinkAction) {
            appLinkData?.lastPathSegment?.let { deeplinkName ->
                bindingClassDeeplink.deeplinkTextView.text = deeplinkName
                    }
            VerboseLoger.v(tag3, "https://shikimori.one/animes/34542-inuyashiki")
            }
        }

    companion object {
        // константу делаем приватной, чтоб никто кроме класса MainActivitySecond
        private const val KEY_DEEPLINK = "deeplink key"

        // константа для сохранения результата
        private const val PHONE_REQUEST_CODE = 321

        // функция для создания Intent
        fun getIntent2(context: Context, message: String?): Intent {
            // возвращаем полностью сформированный intent для запуска активити deeplinkActivity
            return Intent(context, deeplinkActivity::class.java)
                .putExtra(KEY_DEEPLINK, message)
        }


    }

}


