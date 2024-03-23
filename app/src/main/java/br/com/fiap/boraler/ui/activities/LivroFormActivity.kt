package br.com.fiap.boraler.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.boraler.R
import br.com.fiap.boraler.dao.LivroDAO
import br.com.fiap.boraler.model.Livro
import br.com.fiap.boraler.ui.theme.BoralerTheme
import coil.compose.AsyncImage

class LivroFormActivity : ComponentActivity() {

    val dao = LivroDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoralerTheme {
                Surface {
                    LivroFormScreen(onSaveClick = { livro ->
                        dao.salvar(livro)
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun LivroFormScreen(
    onSaveClick: (Livro) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(text = "Adicionar livro", modifier = Modifier.fillMaxWidth(), fontSize = 28.sp)

        var url by remember {
            mutableStateOf("")
        }

        if(url.isNotBlank()){
            AsyncImage(model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit,
                placeholder = painterResource(id = R.drawable.download),
                error = painterResource(id = R.drawable.download)
            )
        }

        TextField(value = url, onValueChange = {
            url = it
        }, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Url da capa")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Uri,
            imeAction = ImeAction.Next
        ))

        var titulo by remember {
            mutableStateOf("")
        }
        TextField(value = titulo, onValueChange = {
            titulo = it
        }, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Título")
        }, keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.Sentences
        ))

        var generos by remember {
            mutableStateOf("")
        }
        TextField(value = generos, onValueChange = {
            generos = it
        }, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Gêneros")
        }, keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.Words
        ))

        var descricao by remember {
            mutableStateOf("")
        }

        TextField(value = descricao, onValueChange = {
            descricao = it
        }, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            }, keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ))

        Button(onClick = {
            val livro = Livro(
                titulo = titulo,
                capa = url,
                descricao = descricao,
                generos = generos
            )
            onSaveClick(livro)
        }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
fun LivroFormScreenPreview() {
        Surface {
            LivroFormScreen()
        }
}