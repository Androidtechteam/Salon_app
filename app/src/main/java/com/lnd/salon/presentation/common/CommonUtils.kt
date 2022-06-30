package com.lnd.salon.presentation.common

import android.content.Context
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject

class CommonUtils {
    companion object {
        fun toast(context: Context?, message: String?) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun getErrorMsg(result: String?): String {
            var error = ""
            try {
                val jsonObject = result?.let { JSONObject(it) }
                if (jsonObject != null) {
                    if (jsonObject.has("data")) {
                        val jsonArray = JSONArray(jsonObject.getString("data"))
                        for (i in 0 until jsonArray.length()) {
                            error += """
                                ${jsonArray[i]}
                                
                                """.trimIndent()
                        }
                    } else {
                        error = jsonObject.getString("message")
                    }
                }
            } catch (ex: Exception) {
                ex.message
            }
            return error
        }
    }
}