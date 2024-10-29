package br.unipar.gestodeesporte

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroAtletaActivity : AppCompatActivity() {
    // Declaração das variáveis para os campos de entrada (EditText)
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText

    // Método chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout da atividade usando o arquivo XML correspondente
        setContentView(R.layout.activity_cadastro_atleta)

        // Inicializa os campos de entrada localizando-os pelo ID
        etNome = findViewById(R.id.et_nome)
        etIdade = findViewById(R.id.et_idade)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)

        // Define um listener para o botão de salvar
        btnSalvar.setOnClickListener {
            // Obtém os valores inseridos nos campos de nome e idade
            val nome = etNome.text.toString()
            val idade = etIdade.text.toString()

            // Verifica se ambos os campos estão preenchidos
            if (nome.isNotEmpty() && idade.isNotEmpty()) {
                // Cria um Intent para retornar o resultado à atividade anterior
                val intent = intent
                // Adiciona o novo atleta (nome) ao Intent
                intent.putExtra("novoAtleta", nome)
                // Define o resultado da atividade como OK e retorna o Intent
                setResult(Activity.RESULT_OK, intent)
                // Finaliza a atividade e retorna à atividade anterior
                finish()
            } else {
                // Se os campos estiverem vazios, exibe uma mensagem de erro
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
