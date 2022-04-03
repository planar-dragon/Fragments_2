package com.skillbox.fragments_2

import android.os.Bundle
import androidx.fragment.app.Fragment

// Расширение позволяет создать новый фрагмент с переданным в него аргументами

fun <T: Fragment> T.withArguments(action: Bundle.() -> Unit): T {
    return apply {
        val args = Bundle().apply(action)
        arguments = args
    }
}