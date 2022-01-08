package com.skillbox.toolbar_15_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.skillbox.toolbar_15_8.databinding.ActivityToolbarBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingToolbar: ActivityToolbarBinding

    private val bookmarks = listOf(
        "bookmark1",
        "bookmark2",
        "bookmark3",
        "bookmark4",
        "bookmark5",
        "bookmark6",
        "bookmark7",
        "bookmark8",
        "bookmark9",
        "bookmark10",
        "bookmark11",
        "bookmark12",
        "other"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingToolbar = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(bindingToolbar.root)
        initToolbar()

    }
    // функция обработчик нажатия на элемент меню для вывода Toast сообщения

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    // функция обработчик нажатия на элемент меню

    private fun initToolbar() {
    // при нажатии кнопки навигации запускается функция отображения Toast

        bindingToolbar.toolbar.setNavigationOnClickListener {
            toast("Навигация")
        }
    // слушатель нажатия выпадающего меню

        bindingToolbar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_1 -> {
                    toast("Активировано Действие 1")
                    true
                }
                R.id.action_2 -> {
                    toast("Активировано Действие 2")
                    true
                }
                R.id.bookmark -> {
                    toast("Заметки")
                    true
                }
                R.id.action_search -> {
                    toast("Поиск")
                    true
                }

                else -> false
            }

        }

        val searchItem = bindingToolbar.toolbar.menu.findItem(R.id.action_search)
        // слушатель заполнения поля поиска

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                bindingToolbar.expandTextView.text = "Поиск активен"
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                bindingToolbar.expandTextView.text = "Поиск прекращен"
                return true
            }

        })
        // поиск текста в поле среди содержимого списка
        (searchItem.actionView as SearchView).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                // поиск при нажатии
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }
                // поиск при заполнении
                override fun onQueryTextChange(newText: String?): Boolean {
                    bookmarks.filter { it.contains(newText ?: "", true) }
                // список в одну строку
                        .joinToString()
                        .let {
                            bindingToolbar.searchResult.text = it
                        }
                    return true
                }

            })

    }







}