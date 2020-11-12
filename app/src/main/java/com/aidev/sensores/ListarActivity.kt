package com.aidev.sensores

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_listar.*

//activity para listar os sensores disponiveis no aparelho
class ListarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)


        var intent = intent
        var lista = intent.getStringArrayListExtra("sensores") as MutableList<String>

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)

        listaSensores.adapter = adapter


    }
}