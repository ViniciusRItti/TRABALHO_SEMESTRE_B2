package br.unipar.gestodeesporte

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListagemAtletaActivity : AppCompatActivity() {
    // Método chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout da atividade usando o arquivo XML correspondente
        setContentView(R.layout.activity_listagem_atleta)

        // Localiza a ListView no layout através de seu ID
        val listViewAtletas = findViewById<ListView>(R.id.list_view_atletas)

        // Recebe a lista de atletas passada pela MainActivity
        // Se a lista estiver nula, inicializa como uma lista vazia
        val atletas = intent.getStringArrayListExtra("atletas") ?: arrayListOf()

        // Cria um ArrayAdapter para exibir os nomes dos atletas na ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, atletas)
        // Define o adaptador da ListView
        listViewAtletas.adapter = adapter
    }
}
