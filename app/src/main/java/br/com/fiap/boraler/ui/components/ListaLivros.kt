package br.com.fiap.boraler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.boraler.model.Livro
import br.com.fiap.boraler.samples.sampleLivros
import br.com.fiap.boraler.ui.screens.HomeScreen
import br.com.fiap.boraler.ui.theme.bgColor1
import br.com.fiap.boraler.ui.theme.fontSizeTitulo
import br.com.fiap.boraler.ui.theme.fontWeightTitulo

class ListaLivrosUiState(
    val titulo: String= "",
    val searchText: String = "",
    val livrosBuscados: List<Livro> = emptyList(),
    val onSearchChange: (String) -> Unit = {}){
}

@Composable()
fun ListaLivros(livros: List<Livro>){
    var text by remember {
        mutableStateOf("")
    }

    val livrosBuscados = remember(text, livros) {
        livros.filter { livro ->
            livro.titulo.contains(text, true) ||
                    livro.descricao.contains(text, true) ||
                    livro.generos.contains(text, true)
        }
    }
    val state = remember(livros, text){
        ListaLivrosUiState(
            titulo = "Todos os livros",
            searchText = text,
            livrosBuscados = livrosBuscados,
            onSearchChange = {
                text = it
            })
    }

    ListaLivros(state = state)
}

@Composable
fun ListaLivros(
    state: ListaLivrosUiState = ListaLivrosUiState()
) {
    Column() {
        var text = state.searchText
        var livrosBuscados = state.livrosBuscados

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = bgColor1)
        ) {
            Text(
                text = state.titulo,
                fontSize = fontSizeTitulo,
                fontWeight = fontWeightTitulo,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }

        SearchTextField(searchText = text, onSearchChange = state.onSearchChange)

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxHeight()
        ) {
            items(livrosBuscados) { livro ->
                LivroItem(livro = livro)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaLivrosPreview() {
    ListaLivros(ListaLivrosUiState("Todos os livros", "", sampleLivros))
}

