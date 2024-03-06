package com.example.cdv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var dinamicoEt: EditText

    private companion object{ //singleton interno
        const val ciclo_pdm = "ciclo_pdm"
        const val conteudo = "conteudo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        Log.v(ciclo_pdm,  "onCreate iniciando ciclo completo")

        val parametrosView= LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        parametrosView.setMargins(0,10,0,0)

        dinamicoEt = EditText(this)
        dinamicoEt.hint = "EditText dinamico"
        dinamicoEt.layoutParams = parametrosView
        amb.root.addView(dinamicoEt)

    }

    override fun onStart() {
        super.onStart()
        Log.v(ciclo_pdm,  "onStart iniciando ciclo visível")

    }

    override fun onResume() {
        super.onResume()
        Log.v(ciclo_pdm,  "onResume iniciando ciclo Primeiro plano")

    }

    override fun onPause() {
        super.onPause()
        Log.v(ciclo_pdm,  "onPause finalizando ciclo em Primeiro plano")

    }

    override fun onStop() {
        super.onStop()
        Log.v(ciclo_pdm,  "onStop finalizando ciclo visível")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(ciclo_pdm,  "onDestroy finalizando ciclo completo!")

    }

    // OPCIONAL!!
    override fun onRestart() {
        super.onRestart()
        Log.v(ciclo_pdm,  "onRestart fazendo seila oq")

    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(conteudo, dinamicoEt.text.toString())
        Log.v(ciclo_pdm,  "Salvando dados da instancia. . . .")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(conteudo)?.let{
            dinamicoEt.setText(it)

        }
        Log.v(ciclo_pdm,  "Restaurando dados da instancia ! ! !")
        Toast.makeText(this, "restaurando dados", Toast.LENGTH_SHORT).show()

    }
}