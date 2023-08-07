package com.example.sharedpref_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpref_example.databinding.ActivityMainBinding
import com.example.sharedpref_example.sharedPrefExampleApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputInt = binding.inputInt
        val inputText = binding.inputString
        val inputBool = binding.swBool
        val inputDecimal = binding.inputDouble

        loadValues()

        // Guardar
        binding.btSave.setOnClickListener {
            if (inputInt.text.toString().isEmpty()) binding.inputLayoutInt.error = "Debes ingresar un numero entero valido"
            else binding.inputLayoutInt.error = null

            if (inputText.text.toString().isEmpty()) binding.inputLayoutString.error = "Debes ingresar texto"
            else binding.inputLayoutString.error = null

            if (inputDecimal.text.toString().isEmpty()) binding.inputLayoutDouble.error = "Debes ingresar un numero decimal"
            else binding.inputLayoutDouble.error = null

            if (inputInt.text.toString().isNotEmpty() && inputText.text.toString().isNotEmpty() && inputDecimal.text.toString().isNotEmpty()) {
                prefs.saveValues(inputInt.text.toString().toInt(), inputText.text.toString(), inputBool.isChecked, inputDecimal.text.toString().toFloat())

                loadValues()
            }
        }

        // Borrar
        binding.btDelete.setOnClickListener {
            prefs.deleteAll()
            loadValues()
        }
    }

    fun loadValues() {
        binding.tvSavedInt.text = getString(R.string.saved_int_text, prefs.getInt())
        binding.tvSavedString.text = getString(R.string.stored_string_text, prefs.getString())
        binding.swBool.isChecked = prefs.getBool()
        binding.tvSavedDouble.text = getString(R.string.saved_double_text, prefs.getDecimal())
    }
}