package com.lnd.salon.presentation.common

import android.content.Context
import com.lnd.salon.presentation.ApplicationClass

class SharedPref {
    companion object{
        private const val TAG = "SHARED_PREFERENCES"
        fun clearSharedPref(context: Context) {
            val appPref =
                context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            appPref.edit().clear().apply()
        }

        fun setApiToken(context: Context?, email: String?) {
            try {
                if (context != null) {
                    val appPref = context.getSharedPreferences(
                        TAG,
                        Context.MODE_PRIVATE
                    )
                    val editor = appPref.edit()
                    if (editor != null) {
                        editor.putString(Constants.PREF_AUTH_KEY, email)
                        editor.apply()
                    }
                }
            }catch (ex:Exception){
                ex.message
            }
        }

        fun getApiToken(): String {
            val appPref =
                ApplicationClass.mInstance?.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            return appPref?.getString(Constants.PREF_AUTH_KEY, "")!!
        }
    }
}