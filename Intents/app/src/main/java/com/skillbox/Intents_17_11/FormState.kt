package com.skillbox.Intents_17_11


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Для того, чтобы хранить состояние формы, создайте класс.

@Parcelize

data class FormState(val valid: Boolean, val message: String) : Parcelable

