package br.com.jessicaraissapessoa.githubsearchapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        showUserName()
        setupRetrofit()
        setupListeners()
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
            val nomePesquisar = nomeUsuario.text.toString()
            getAllReposByUserName(nomePesquisar)
            saveUserLocal()
        }
    }

    fun getAllReposByUserName(userName: String) { //Método responsável por buscar todos os repositórios do usuário fornecido

        if (userName.isNotEmpty()) {

            githubApi.getAllRepositoriesByUser(userName)
                .enqueue(object : Callback<List<Repository>> {

                    override fun onResponse(
                        call: Call<List<Repository>>,
                        response: Response<List<Repository>>
                    ) {
                        if (response.isSuccessful) {

                            val repositories = response.body()
                            Log.d("MainActivity", "Resposta da API: ${repositories.toString()}")


                            repositories?.let {
                                setupAdapter(repositories)
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

            Log.d("chegou aqui", "chegou")
        }
    }

    fun setupAdapter(list: List<Repository>) { // Método responsável por realizar a configuração do adapter

        val adapter = RepositoryAdapter(
            this, list)

        listaRepositories.adapter = adapter

        Log.d("adapter", adapter.toString())
    }

    private fun saveUserLocal() { // Método responsável por salvar o usuário preenchido no EditText utilizando uma SharedPreferences

        val usuarioInformado = nomeUsuario.text.toString()

        val sharedPreference = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPreference.edit()) {
            putString("saved_username", usuarioInformado)
            apply()
        }
    }

    private fun showUserName() { //Método que exibe o que foi salvo na SharedPreference

        val sharedPreference = getPreferences(MODE_PRIVATE) ?: return
        val ultimoPesquisado = sharedPreference.getString("saved_username", null)

        if (!ultimoPesquisado.isNullOrEmpty()) {
            nomeUsuario.setText(ultimoPesquisado)
        }
    }

}