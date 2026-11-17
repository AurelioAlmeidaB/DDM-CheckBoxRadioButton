package com.example.ddm8

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ddm8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnviar.setOnClickListener {
            binding.txtResultado.text = binding.txtProduto.text.toString()
            verificaCheckBox()
            verificaRadioButton()
        }
    }

    private fun verificaCheckBox() {
        val caixa = listOf(binding.cbBranco, binding.cbPreto, binding.cbVerde)

        val elementos = caixa.filter { it.isChecked }
            .map { it.text.toString() }
        binding.txtCores.text = elementos.toString()
    }

    private fun verificaRadioButton() {
        val idSelecionado = binding.rgTamanho.checkedRadioButtonId
        if (idSelecionado != -1) {
            val radioButton = findViewById<RadioButton>(idSelecionado)
            binding.txtTamanho.text = radioButton.text.toString()
        } else {
            binding.txtTamanho.text = "Nenhum tamanho selecionado"
        }
    }
}
