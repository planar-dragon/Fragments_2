package com.skillbox.fragments_2

// интерфейс который передает текст нажатой кнопки из фрагмента ListFragment
interface TagSelectListener {

    fun onTagSelected(checkedTags: BooleanArray)
}