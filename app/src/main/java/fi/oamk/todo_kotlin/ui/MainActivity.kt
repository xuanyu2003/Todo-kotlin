package fi.oamk.todo_kotlin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.oamk.todo_kotlin.model.Todo
import fi.oamk.todo_kotlin.ui.theme.TodokotlinTheme
import fi.oamk.todo_kotlin.viewmodel.TodoViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodokotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel =
    TodoViewModel()) {
    TodoList(modifier,todoViewModel.todos)
}


@Composable
fun TodoList(modifier: Modifier = Modifier,  todos: List<Todo>) {
    LazyColumn (
        modifier = modifier
    )
    {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    TodokotlinTheme {
        TodoScreen()
    }
}

