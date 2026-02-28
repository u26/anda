package jp.mknod.anda

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun InitApi(): AndaAPI {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(AndaAPI::class.java)
}

class User{
    val id : String = ""
    val name: String = ""
    val email: String = ""
    val password: String = ""
}

data class MenuItem(
    val id : String = "",
    val title: String = "",
    val price: Int = 0,
    val img: String = "",
)

class Status{
    val status: String = ""
    val method: String = ""
}


interface AndaAPI {

    @GET("users")
    suspend fun getUsers(): List<User> // Coroutineで非同期処理

    @GET("test")
    suspend fun getStatus(): Status // Coroutineで非同期処理

    @GET("menuitem")
    suspend fun getMenuItem(): List<MenuItem> // Coroutineで非同期処理


}
