package com.skillbox.ConstraintLayout_15_4


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Для того, чтобы хранить состояние формы, создайте класс.

@Parcelize

data class FormState(val valid: Boolean, val message: String) : Parcelable

