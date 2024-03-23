package br.com.fiap.boraler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.boraler.R
import br.com.fiap.boraler.model.Livro
import br.com.fiap.boraler.ui.theme.fontSizeTitulo
import br.com.fiap.boraler.ui.theme.fontWeightTitulo
import br.com.fiap.boraler.ui.theme.primaryTextColor
import coil.compose.AsyncImage

@Composable
fun LivroItem(livro: Livro) {
    Surface(shape = RoundedCornerShape(10.dp), shadowElevation = 4.dp) {
        Row(
            Modifier
                .heightIn(80.dp, 95.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column {
                AsyncImage(
                    model = livro.capa,
                    contentDescription = "Capa do livro",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(60.dp),
                    placeholder = painterResource(id = R.drawable.download)
                )
            }
            Column(
                Modifier
                    .padding(horizontal = 8.dp, vertical = 5.dp)
            ) {
                Text(
                    text = livro.titulo,
                    fontSize = fontSizeTitulo,
                    fontWeight = fontWeightTitulo,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 15.sp,
                    color = primaryTextColor
                )
                Text(
                    text = livro.generos,
                    fontSize = 12.sp,
                    color = Color(0xFF999999),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 15.sp
                )
                Text(
                    text = livro.descricao,
                    fontSize = 14.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 15.sp,
                    color = primaryTextColor
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun LivroItemPreview() {
    LivroItem(
        Livro(
            titulo = "Harry Potter e a Pedra filosofal",
            generos = "Gêneros: Fantasia, Aventura",
            descricao = "Harry Potter é um garoto órfão que vive infeliz com seus tios, os Dursleys. Ele recebe uma carta contendo um convite para ingressar em Hogwarts, uma famosa escola especializada em formar jovens bruxos. ",
            capa = "https://pt-br.imgbb.com/"
        )
    )
}
