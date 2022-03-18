package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.ListFragmentBinding

class ListFragment( ) : Fragment(R.layout.list_fragment)
{

    private lateinit var listFragmentBinding: ListFragmentBinding

// Свойство нулябельного интерфейса с геттером для упрощения обращения к интерфейсу
    private val itemSelectListener: ItemSelectListener?
    // При обращении к переменной передает содержимое в метеринский фрагмент
        get() = parentFragment.let { it as? ItemSelectListener }

    val LOG_TAG: String = "myLogs"

    // компаньон обьект для создания нового фрагмента, с сохраненным аргументом
    companion object {

        fun newListFragment(text: String): ListFragment {
            return ListFragment().withArguments {
                putString(Constants.KEY_LIST, text)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragmentBinding = ListFragmentBinding.inflate(inflater, container, false)

        return listFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // преобразуем корневую вью в вью группу
        view.let { it as ViewGroup }
            // обращаемся к дочерним элементам
            .children
            // на входе сущность дочерней вью, на выходе список сущностей которые не null
            // все дочерние элементы преобразуются к кнопке, используется только то что можно преобразовать к кнопке
            .mapNotNull { it as? Button }
            // создадим цикл по списку кнопок
            // в качестве it в forEach будет выступать Button а не View
            .forEach { button ->
                button.setOnClickListener {
                    onButtonClick(button.text.toString())

                }
            }
        Log.d(LOG_TAG, "ListFragment: onViewCreated")

    }


    // метод обработки нажатия по кнопкам списка листа ( На входе текст нажатой кнопки)
    private fun onButtonClick(buttonText: String) {
        Log.d(LOG_TAG, "ListFragment: Нажата кнопка $buttonText")
// Обращение к метеринскому фрагменту через функцию интерфейса, в которую передаем текст кнопки
        itemSelectListener?.onItemSelected(buttonText)
//        (parentFragment as? ItemSelectListener)?.onItemSelected(buttonText)
        Log.d(LOG_TAG, "ListFragment: Открывает DetailFragment для $buttonText")

    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.d(LOG_TAG, "ListFragment: onAttach")
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(LOG_TAG, "ListFragment: onCreate")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d(LOG_TAG, "ListFragment: onDestroyView")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(LOG_TAG, "ListFragment: onDestroy")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.d(LOG_TAG, "ListFragment: onDetach")
//    }


}
