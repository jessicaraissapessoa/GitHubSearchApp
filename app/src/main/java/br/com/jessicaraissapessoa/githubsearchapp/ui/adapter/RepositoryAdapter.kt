package br.com.jessicaraissapessoa.githubsearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jessicaraissapessoa.githubsearchapp.R
import br.com.jessicaraissapessoa.githubsearchapp.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // Cria uma nova view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repositories.size // Pega a quantidade de repositórios da lista

    // Pega o conteúdo da view e troca pela informação de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        //val atributo: TextView

        //init {
        //    view.apply {
        //        atributo = findViewById(R.id.item_view)
        //    }

    }
}