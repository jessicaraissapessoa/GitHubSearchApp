package br.com.jessicaraissapessoa.githubsearchapp.data

import br.com.jessicaraissapessoa.githubsearchapp.domain.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
interface GitHubService {

    @GET("users/{user}/repos")
    fun getAllRepositoriesByUser(@Path("user") user: String): Call<List<Repository>>

}