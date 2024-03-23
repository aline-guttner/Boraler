package br.com.fiap.boraler.model

import androidx.annotation.DrawableRes

data class Livro(
    val titulo: String,
    val generos: String,
    val descricao :String,
    val capa: String?
) {
}
