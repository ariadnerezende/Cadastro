package com.example.cadastro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
            private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        amb.inicialSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selUf = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }
        }

        amb.salvarBt.setOnClickListener {
            val nome = amb.campoNome.text.toString()
            val telefone = amb.campoTel.text.toString()
            val email = amb.campoEmail.text.toString()
            val ingressoListaEmail = amb.cbEmail.isChecked
            val sexo = if (amb.rgSexo.checkedRadioButtonId == R.id.masculino) "Masculino" else "Feminino"
            val cidade = amb.campoCidade.text.toString()
            val uf = amb.inicialSp.selectedItem.toString()

            val formulario = Formulario(nome, telefone, email, ingressoListaEmail, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        amb.limparBt.setOnClickListener {
            amb.campoNome.text.clear()
            amb.campoTel.text.clear()
            amb.campoEmail.text.clear()
            amb.campoCidade.text.clear()
            amb.cbEmail.isChecked = false
            amb.rgSexo.check(R.id.masculino)
            amb.inicialSp.setSelection(0)
        }
    }
}