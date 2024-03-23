package br.com.fiap.boraler.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.boraler.ui.theme.bgColor3

@Composable
fun SearchTextField(searchText: String, onSearchChange: (String) -> Unit){
   // var text by remember { mutableStateOf(searchText) }
    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        label = {
            Text(text = "Título")
        },
        placeholder = {
            Text("O que você procura?")
        },
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .fillMaxWidth()
            .background(color = bgColor3, shape = RoundedCornerShape(10.dp)),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Ícone de busca")
        },
        shape = RoundedCornerShape(10.dp)
    )
}