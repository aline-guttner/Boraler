package br.com.fiap.boraler.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.boraler.dao.LivroDAO
import br.com.fiap.boraler.samples.sampleLivros
import br.com.fiap.boraler.ui.screens.HomeScreen
import br.com.fiap.boraler.ui.theme.BoralerTheme

class MainActivity : ComponentActivity() {

    private val dao = LivroDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoralerTheme {
                Surface {
                    App(onFabClick = {
                        startActivity(Intent(this, LivroFormActivity::class.java))
                    }){
                        val livros = dao.livros()
                        HomeScreen(livros = livros)
                    }
                }
            }

        }
    }
}

@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}){
    BoralerTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) {paddingValues: PaddingValues ->
                Box(modifier = Modifier.padding(paddingValues)){
                    content()
                }
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    BoralerTheme {
        Surface {
            HomeScreen(sampleLivros)
        }
    }
}
