package fi.oamk.todo_kotlin.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Define the data model for Todo
data class Todo(
    var uID: Int,
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

// Define the TodosApi interface for Retrofit
interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        private var todosService: TodosApi? = null

        // Create or return existing instance of TodosApi
        fun getInstance(): TodosApi {
            if (todosService == null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TodosApi::class.java)
            }
            return todosService!!
        }
    }
}
