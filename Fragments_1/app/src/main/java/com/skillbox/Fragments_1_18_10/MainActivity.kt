package com.skillbox.Fragments_1_18_10

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewbinding.BuildConfig
import com.skillbox.Fragments_1_18_10.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainActivityBinding.root)
//проверяем заполнен ли контейнер
        val alreadyHasFragment = supportFragmentManager.findFragmentById(R.id.containerFragment) != null

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment,LoginFragment.newLoginFragment(text = "Key_Text_Login"))
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment,ListFragment.newListFragment(text = "Key_Text_List"))
            .commit()

    }
}













