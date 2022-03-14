package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.ListFragmentBinding

class ListFragment( ) : Fragment(R.layout.list_fragment) {

    private var listFragmentBinding: ListFragmentBinding? = null

    private val binding get() = listFragmentBinding!!

    private val itemSelectListener: ItemSelectListener?
        get() = activity?.let {it as? ItemSelectListener}

//    val listFragment: Fragment = MainFragment()
//    val parentActivity: Activity? = activity

    companion object{

        fun newListFragment(text: String): ListFragment{
            return ListFragment().withArguments {
                putString(Constants.KEY_TEXT_LIST, text)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragmentBinding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
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
            .forEach {button ->
                button.setOnClickListener {
                    onButtonClick(button.text.toString())
                }
            }

    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        listFragmentBinding = null
//    }

    // метод обработки нажатия по кнопкам списка листа
    private fun onButtonClick(buttonText: String){
        itemSelectListener?.onItemSelected(buttonText)

    }



}