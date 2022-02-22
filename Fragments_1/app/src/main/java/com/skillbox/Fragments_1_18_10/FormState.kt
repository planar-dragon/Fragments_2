package com.skillbox.Fragments_1_18_10


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Для того, чтобы хранить состояние формы, создайте класс.

@Parcelize

data class FormState(val valid: Boolean, val message: String) : Parcelable

