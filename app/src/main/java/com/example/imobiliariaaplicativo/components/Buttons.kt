package com.example.imobiliariaaplicativo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuButton(icon: Int, title: String, onClick: () -> Unit, cor: Long) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color(cor)),
        onClick = onClick,
        modifier = Modifier
            .width(170.dp)
            .height(170.dp)
            .padding(3.dp)
            .clip(RoundedCornerShape(2.dp)) // Definindo bordas arredondadas com um raio de 8.dp
            .background(Color(cor)), // Definindo a cor de fundo vermelha
        contentPadding = PaddingValues(0.dp), // Removendo preenchimento interno padrão
    ) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.clip(RoundedCornerShape(8.dp)) ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.size(70.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    fontSize = 20.sp,
                    text = title,
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}