package br.unipar.gestodeesporte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // Lista mutável para armazenar os nomes dos atletas
    private val atletas = mutableListOf<String>()

    // Método chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout da atividade usando o arquivo XML correspondente
        setContentView(R.layout.activity_main)

        // Localiza os botões no layout através de seus IDs
        val btnCadastroAtletas = findViewById<Button>(R.id.btn_cadastro_atletas)
        val btnListagemAtletas = findViewById<Button>(R.id.btn_listagem_atletas)

        // Define um listener para o botão de cadastro de atletas
        btnCadastroAtletas.setOnClickListener {
            // Cria um Intent para iniciar a atividade de cadastro de atletas
            val intent = Intent(this, CadastroAtletaActivity::class.java)
            // Passa a lista de atletas como uma ArrayList para a próxima atividade
            intent.putStringArrayListExtra("atletas", ArrayList(atletas))
            // Inicia a atividade e espera um resultado de volta
            startActivityForResult(intent, 1)
        }

        // Define um listener para o botão de listagem de atletas
        btnListagemAtletas.setOnClickListener {
            // Cria um Intent para iniciar a atividade de listagem de atletas
            val intent = Intent(this, ListagemAtletaActivity::class.java)
            // Passa a lista de atletas como uma ArrayList para a próxima atividade
            intent.putStringArrayListExtra("atletas", ArrayList(atletas))
            // Inicia a atividade sem esperar um resultado de volta
            startActivity(intent)
        }
    }

    // Método chamado quando uma atividade iniciada com startActivityForResult retorna
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Verifica se o resultado é referente ao cadastro de atleta e se foi bem-sucedido
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Obtém o novo atleta retornado pela atividade de cadastro
            val novoAtleta = data?.getStringExtra("novoAtleta")
            // Se um novo atleta foi retornado, adiciona à lista e exibe uma mensagem de confirmação
            novoAtleta?.let {
                atletas.add(it) // Adiciona o novo atleta à lista
                // Mostra uma mensagem Toast informando que o atleta foi cadastrado
                Toast.makeText(this, "$it cadastrado!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
