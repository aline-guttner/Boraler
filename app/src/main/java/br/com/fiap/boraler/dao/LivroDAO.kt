package br.com.fiap.boraler.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.fiap.boraler.model.Livro
import br.com.fiap.boraler.samples.sampleLivros

class LivroDAO {
    companion object{
        private val livros = mutableStateListOf<Livro>(*sampleLivros.toTypedArray())
    }

    fun livros() = livros.toList()

    fun salvar(livro: Livro) {
        livros.add(livro)
    }
}