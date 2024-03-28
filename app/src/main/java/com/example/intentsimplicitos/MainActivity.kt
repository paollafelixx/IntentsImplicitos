package com.example.intentsimplicitos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* val url = "http://www.example.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)*/
        setContentView(R.layout.activity_main)

        // Encontrando o Spinner pelo ID
        val spinner: Spinner = findViewById(R.id.my_spinner)

        // Criando uma lista de opções para o spinner
        val options = listOf("Opção 1", "Opção 2", "Opção 3")

        // Inicializando um ArrayAdapter com a lista de opções
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        // Especificando o layout a ser usado quando a lista de opções aparece
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Aplicando o adapter ao Spinner
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Um item foi selecionado. Você pode recuperar o item usando
                // parent.getItemAtPosition(pos)
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selecionado: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Nenhuma ação aqui por enquanto.
            }
        }
    }


}

