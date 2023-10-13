package br.com.jessicaraissapessoa.githubsearchapp.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.jessicaraissapessoa.githubsearchapp.R
import br.com.jessicaraissapessoa.githubsearchapp.data.GitHubService
import br.com.jessicaraissapessoa.githubsearchapp.domain.Repository
import br.com.jessicaraissapessoa.githubsearchapp.ui.adapter.RepositoryAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var nomeUsuario: EditText
    lateinit var btnConfirmar: Button
    lateinit var listaRepositories: RecyclerView
    lateinit var githubApi: GitHubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayShowHomeEnabled(true) //Habilitando exibição do ícone do app

        setContentView(R.layout.activity_main)
        setupView()
        setupRetrofit()
        setupListeners()
        showUserName()
        getAllReposByUserName()
    }

    fun setupView() { // Método responsável por realizar o setup da view e recuperar os Ids do layout
        nomeUsuario = findViewById(R.id.et_nome_usuario)
        btnConfirmar = findViewById(R.id.btn_pesquisar)
        listaRepositories = findViewById(R.id.rv_lista_repositories)
    }

    fun setupRetrofit() { //Método responsável por fazer a configuração base do Retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        githubApi = retrofit.create(GitHubService::class.java)

    }

    private fun setupListeners() { // Método responsável por configurar os listeners click da tela
        btnConfirmar.setOnClickListener {
            getAllReposByUserName()
        }
    }

    fun getAllReposByUserName() { //Método responsável por buscar todos os repositórios do usuário fornecido

        val nomeUsuarioInformado = nomeUsuario.text.toString()

        if (nomeUsuarioInformado.isNotEmpty()) {
            githubApi.getAllRepositoriesByUser(nomeUsuarioInformado)
                .enqueue(object : Callback<List<Repository>> {
                    override fun onResponse(
                        call: Call<List<Repository>>,
                        response: Response<List<Repository>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                setupAdapter(it)
                                saveUserLocal(nomeUsuarioInformado)
                            }
                        } else {
                            val context = applicationContext
                            Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG)
                                .show()
                        }
                    }

                    override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                        val context = applicationContext
                        Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG).show()
                    }

                })

            saveUserLocal(nomeUsuarioInformado)
            Log.d("chegou aqui", "chegou")
        }
    }

    private fun saveUserLocal(nomeInformado : String) { // Método responsável por salvar o usuário preenchido no EditText utilizando uma SharedPreferences

        val sharedPreference = getSharedPreferences(nomeInformado,Context.MODE_PRIVATE) ?: return
        with(sharedPreference.edit()) {
            putString("saved_username", nomeInformado)
            apply()
            Log.d("nome salvo", nomeInformado)
        }
    }

    private fun getSharedPref(nome: String) : String? { //Método que pega preferência salva em SharedPreference

        val sharedPreference = getSharedPreferences(nome, Context.MODE_PRIVATE)
        Log.d("pegou salvo", sharedPreference.toString())

        return sharedPreference.getString("saved_username", "")
    }

    private fun showUserName() { //Método que exibe o que foi salvo na SharedPreference
        val nomeUsuarioPesquisado = getSharedPref("saved_username")
        nomeUsuario.setText(nomeUsuarioPesquisado)
        if (nomeUsuarioPesquisado != null) {
            Log.d("exibindo nome salvo:", nomeUsuarioPesquisado)
        } else Log.d("sem nome salvo", "")
    }

    fun setupAdapter(list: List<Repository>) { // Método responsável por realizar a configuração do adapter

        val repositoryAdapter = RepositoryAdapter(list)

        listaRepositories.apply {
            isVisible = true
            adapter = repositoryAdapter
        }

        // TODO: terminar implementação
    }


    // Método responsável por compartilhar o link do repositório selecionado
    // @Todo 11 - Colocar esse metodo no click do share item do adapter
    fun shareRepositoryLink(urlRepository: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, urlRepository)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    // Método responsável por abrir o browser com o link informado do repositório

    // @Todo 12 - Colocar esse metodo no click item do adapter
    fun openBrowser(urlRepository: String) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(urlRepository)
            )
        )

    }

}