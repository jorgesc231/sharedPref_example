package com.example.sharedpref_example

import android.content.Context
import android.content.SharedPreferences

class SPrefsHelper (val context : Context) {

    private val PREFS_NAME : String = "com.pref_example.values"
    private val prefs : SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        const val ENTERO_KEY = "entero_key"
        const val TEXTO_KEY = "texto_key"
        const val BOOL_KEY = "bool_key"
        const val DECIMAL_KEY = "decimal_key"
    }


    fun saveValues(entero : Int, string : String, bool : Boolean, decimal : Float) {
        prefs.edit().putInt(ENTERO_KEY, entero).apply()
        prefs.edit().putString(TEXTO_KEY, string).apply()
        prefs.edit().putBoolean(BOOL_KEY, bool).apply()
        prefs.edit().putFloat(DECIMAL_KEY, decimal).apply()
    }

    fun getInt() : Int {
        return prefs.getInt(ENTERO_KEY, 0)
    }

    fun getString() : String {
        return prefs.getString(TEXTO_KEY, "")!!
    }

    fun getBool() : Boolean {
        return prefs.getBoolean(BOOL_KEY, false)
    }

    fun getDecimal() : Float {
        return prefs.getFloat(DECIMAL_KEY, 0.0f)
    }

    fun deleteAll() {
        prefs.edit().clear().apply()
    }
}