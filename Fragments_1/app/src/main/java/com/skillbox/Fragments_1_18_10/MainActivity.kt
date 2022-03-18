package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var mainActivityBinding: ActivityMainBinding

    val LOG_TAG: String = "myLogs"

// Фрагмент который занимает контейнер в данный момент

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.containerFragment)!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainActivityBinding.root)

//проверяем есть ли сохраненное состояние если его нет, запускается фрагмент логин

        if (savedInstanceState == null) {
            Log.d(LOG_TAG, "Приложение запущено в первый раз, сохранений нет")

            supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, LoginFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.containerFragment,
                    LoginFragment.newLoginFragment(Constants.KEY_LOGIN)
                )
                .commit()
        }
        Log.d(LOG_TAG, "LoginFragment: beginTransaction")

    }

    override fun onBackPressed() {
        val count = currentFragment.childFragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
            Log.d(LOG_TAG, "Сохранений в BackStack $count - выход из приложения")
        } else {
            currentFragment.childFragmentManager.popBackStack()
            Log.d(LOG_TAG, "Сохранено в BackStack $count - возврат к предыдущему фрагменту")

        }



    }

}

















