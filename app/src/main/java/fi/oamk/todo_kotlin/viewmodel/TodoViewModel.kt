package fi.oamk.todo_kotlin.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.oamk.todo_kotlin.model.Todo
import fi.oamk.todo_kotlin.model.TodosApi
import kotlinx.coroutines.launch


class TodoViewModel: ViewModel() {
    var todos = mutableStateListOf<Todo>()
        private set
    init {
        getTodosList()
    }
    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("ERROR",e.message.toString())
            }
        }
    }

}