package br.com.fiap.boraler.ui.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.boraler.model.Livro
import br.com.fiap.boraler.samples.sampleLivros
import br.com.fiap.boraler.ui.components.ListaLivros
import br.com.fiap.boraler.ui.components.ListaLivrosUiState
import br.com.fiap.boraler.ui.theme.BoralerTheme

@Composable
fun HomeScreen(livros: List<Livro>){
    BoralerTheme {
        Surface {
            ListaLivros(livros = livros)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface {
        ListaLivros(sampleLivros)
    }
}