package com.example.imobiliariaaplicativo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imobiliariaaplicativo.R

data class ImobiliariaInfo(
    val name: String,
    val address: String,
    val phone: String,
    val email: String,
    val logo: Int
)

val imobiliariaData = ImobiliariaInfo(
    name = "Imobiliária TETO",
    address = "Rua da Jabutucaba, 783",
    phone = "(11) 9234-5678",
    email = "contato@teto.com",
    logo = R.drawable.imobiliarialogo // Substitua com o ID do recurso da imagem da imobiliária
)


@Composable
fun ImobiliariaHeader(imobiliariaInfo: ImobiliariaInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(190.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            ImobiliariaLogo(painterResource(id = imobiliariaInfo.logo))
        }
        Text(
            text = imobiliariaInfo.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = imobiliariaInfo.address,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = imobiliariaInfo.phone,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = imobiliariaInfo.email,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ImobiliariaPage(imobiliariaInfo: ImobiliariaInfo) {
    Column (modifier = Modifier.padding(10.dp)){


        ImobiliariaHeader(imobiliariaInfo)

        Text(
            text = "Sobre a Imobiliária",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Somos a imobiliária líder no mercado, oferecendo as melhores opções de imóveis para compra e aluguel. Nossa missão é ajudar você a encontrar o lar dos seus sonhos.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Descrição da Imobiliária",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "A Imobiliária TETO é uma das melhores imobiliárias do mercado, com anos de experiência em ajudar nossos clientes a encontrar as propriedades ideais. Nosso compromisso é fornecer um serviço excepcional e orientação durante todo o processo de compra ou aluguel de imóveis.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "História da Imobiliária",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Fundada em 2005, a Imobiliária TETO cresceu de forma constante e estabeleceu uma reputação sólida no mercado imobiliário. Nossa equipe de corretores altamente qualificados está pronta para ajudar você a realizar seus sonhos imobiliários.",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(90.dp))
    }
}


@Composable
fun ImobiliariaLogo(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}
