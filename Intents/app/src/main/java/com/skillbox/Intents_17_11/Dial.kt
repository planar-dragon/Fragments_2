package com.skillbox.Intents_17_11

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract

//public static class Dial extends: ActivityResultContract<String, Boolean>() {
//    override fun createIntent(context: Context, ringtoneType: Int) =
//        Intent(Call).apply {
//            putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, ringtoneType)
//        }
//
//    override fun parseResult(resultCode: Int, result: Intent?) : Uri? {
//        if (resultCode != Activity.RESULT_OK) {
//            return null
//        }
//        return result?.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
//    }
//}