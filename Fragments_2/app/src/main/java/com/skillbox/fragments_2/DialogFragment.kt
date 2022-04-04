package com.skillbox.fragments_2


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.widget.ViewPager2
import com.github.javafaker.Faker
import com.google.android.material.tabs.TabLayout
import com.skillbox.fragments_2.databinding.FragmentDialogBinding

class DialogFragment : DialogFragment() {

    private val color: Int
        get() = requireArguments().getInt(ARG_COLOR)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        AlertDialog.Builder(requireActivity())
            .setTitle("Заголовок")
            .setMessage("Сообщение")
            .setPositiveButton("Применить", {_,_->})
            .setNegativeButton("Отмена", {_,_->})
            .create()






//        val colorItems = resources.getStringArray(R.array.colors)

//        val colorComponents = mutableListOf(
//            Color.red(this.color),
//            Color.green(this.color),
//            Color.blue(this.color)
//        )
//        val checkboxes = colorComponents
//            .map { it > 0 && savedInstanceState == null }
//            .toBooleanArray()

        return AlertDialog.Builder(requireContext())
            .setTitle("Выберите теги")
            .setMultiChoiceItems(colorItems, checkboxes) { dialog, _, _ ->
                // NEW:
                val checkedPositions = (dialog as android.app.AlertDialog).listView.checkedItemPositions
                val color = Color.rgb(
                    booleanToColorComponent(checkedPositions[0]),
                    booleanToColorComponent(checkedPositions[1]),
                    booleanToColorComponent(checkedPositions[2])
                )
                parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_COLOR_RESPONSE to color))
            }
            .setPositiveButton(R.string.action_close, null)
            .create()
    }

    private fun booleanToColorComponent(value: Boolean): Int {
        return if (value) 255 else 0
    }

    companion object {
        @JvmStatic private val TAG = DialogFragment::class.java.simpleName
        @JvmStatic private val KEY_COLOR_RESPONSE = "KEY_COLOR_RESPONSE"
        @JvmStatic private val ARG_COLOR = "ARG_COLOR"

        @JvmStatic val REQUEST_KEY = "$TAG:defaultRequestKey"

        //        fun newViewPagerFragment(text: String): ViewPagerFragment {
////            val fragment = MainFragment()
////            val args = Bundle().apply {
////                putString(Constants.KEY_MAIN_FRAGMENT, text)
////            }
////            fragment.arguments = args
////            return fragment
//            return ViewPagerFragment().withArguments {
//                putString(Constants.KEY_VIEW_PAGER_FRAGMENT, text)
//            }
//        }
        fun show(manager: FragmentManager, color: Int) {
            val dialogFragment = DialogFragment()
            dialogFragment.arguments = bundleOf(ARG_COLOR to color)
            dialogFragment.show(manager, TAG)
        }

        fun setupListener(manager: FragmentManager, lifecycleOwner: LifecycleOwner, listener: (Int) -> Unit) {
            manager.setFragmentResultListener(REQUEST_KEY, lifecycleOwner, FragmentResultListener { _, result ->
                listener.invoke(result.getInt(KEY_COLOR_RESPONSE))
            })
        }

    }
}