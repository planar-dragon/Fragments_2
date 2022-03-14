package com.skillbox.Fragments_1_18_10

import android.graphics.Insets.add
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            .addToBackStack(null)
            .commit()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.containerFragment,ListFragment.newListFragment(text = "Key_Text_List"))
//            .commit()

    }

//    fun onClick(v: View) {
//        fTrans = supportFragmentManager.beginTransaction()
//        when (v.id) {
//            R.id.btnAdd -> fTrans.add(R.id.frgmCont, frag1)
//            R.id.btnRemove -> fTrans.remove(frag1)
//            R.id.btnReplace -> fTrans.replace(R.id.frgmCont, frag2)
//            else -> {}
//        }
//        if (chbStack.isChecked()) fTrans.addToBackStack(null)
//        fTrans.commit()
//    }
}













