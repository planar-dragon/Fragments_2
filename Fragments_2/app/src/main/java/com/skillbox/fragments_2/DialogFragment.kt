package com.skillbox.fragments_2


import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogFragment : DialogFragment() {

    val LOG_TAG: String = "myLogs"

    // Свойство нулябельного интерфейса с геттером для упрощения обращения к интерфейсу
    private val tagSelectListener: TagSelectListener?
        // При обращении к переменной передает содержимое в метеринский фрагмент
        get() = parentFragment.let { it as? TagSelectListener }

    // Создадим пустой список для отфильтрованных индексов тегов
    private val checkedArticleTags: ArrayList<String> = arrayListOf()

    // Переменная со всеми выбрранными тегами
    var checkedTags: BooleanArray = booleanArrayOf(true, true, true, true)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // Создадим список тегов из энум класса ArticleTag
        val articleTag = ArticleTag.values().map { it.name }.toTypedArray()

        return android.app.AlertDialog.Builder(requireActivity())
            .setTitle("Выберите теги статей")
            // добавим в диалог мультивыбор для фильтрации тегов статей
            .setMultiChoiceItems(articleTag, checkedTags) { _, which, isChecked ->
                checkedTags[which] = isChecked
            }
            .setPositiveButton("Применить фильтрацию") { _, _ ->
                // Цикл для сбора выбраных тегов
                for (tag in articleTag.indices) {
                    // Переменная куда сохраняется индекс тега если он Checked
                    val checked = checkedTags[tag]
                    // Если тег выбран он добавляется в список отфильтрованных индексов тегов
                    if (checked) {
                        checkedArticleTags.add(articleTag[tag])
                    }
                }
                onButtonApplyFiltering(checkedTags)

//////////???????????????????????????????????????????
// тут неправильно не знаю как сохранять состояние выбранных тегов и загружать через аргумент в диалог фрагмент
//                checkedTags = savedInstanceState?.getBooleanArray(Constants.KEY_CHECKED_TAG)!!

                Log.d(LOG_TAG, " $checkedTags")
            }
            .setNegativeButton("Отмена", { _, _ -> })
            .create()
    }

//    val tagForDialog = ArticleTag.values().filter {
//        checkedTags[it.ordinal]
//    }.toMutableList()

    // Функция для передачи отфильтрованного списка тегов
    private fun onButtonApplyFiltering(checkedTags: BooleanArray) {
//        Log.d(LOG_TAG, "Отфильтрованы теги: - ${filteredArticleTags}")
        // Обращение к метеринскому фрагменту через функцию интерфейса, в которую передаем список тегов
        tagSelectListener?.onTagSelected(checkedTags)
    }

    companion object {
        fun newIntent(checkedTags: BooleanArray): DialogFragment {
//            val fragment = MainFragment()
//            val args = Bundle().apply {
//                putString(Constants.KEY_MAIN_FRAGMENT, text)
//            }
//            fragment.arguments = args
//            return fragment
            return DialogFragment().withArguments {
                putBooleanArray(Constants.KEY_CHECKED_TAG, checkedTags)
            }
        }
    }
}