package com.example.imobiliariaaplicativo.components

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imobiliariaaplicativo.R
import java.net.URLEncoder

@Composable
fun CasaVendaCard(
    image: Int,
    nome: String,
    valor: String,
    iptu: String,
    valorParcelas: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0E5F11),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {  navController.navigate("detalhes") }
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null, // Descrição de conteúdo nula, pois é uma imagem
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )

            Text(
                text = nome,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                text = "Valor: R$ $valor",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )

            Text(
                text = "IPTU: R$ $iptu",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )

            Text(
                text = "Parcelas: R$ $valorParcelas/mês",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            )
            Button(
                onClick = { navController.navigate("nossotime") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.White),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 6.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .border(width = 1.dp, color = Color.White)
                    .size(width = 200.dp, height = 40.dp)
            ) {
                Text(
                    text = "Tenho Interesse!",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun CasaAluguelCard(
    image: Int,
    nome: String,
    valorAluguel: String,
    quartos: Int,
    banheiros: Int,
    tamanho: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF200C68),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp

        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {  navController.navigate("detalhes") }
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )

            Text(
                text = nome,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                text = "Valor do Aluguel: R$ $valorAluguel/mês",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )

            Row {
                TextWithIcon(
                    text = "$tamanho",
                    icon = painterResource(id = R.drawable.area),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Text(text = "|",  color = Color.White,)
                TextWithIcon(
                    text = "Quartos: $quartos",
                    icon = painterResource(id = R.drawable.quarto),
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp, bottom = 8.dp)
                )
                Text(text = "|",  color = Color.White,)
                TextWithIcon(
                    text = "Banheiros: $banheiros",
                    icon = painterResource(id = R.drawable.banheiro),
                    modifier = Modifier.padding(start = 8.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            Button(
                onClick = { navController.navigate("nossotime") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.White),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .border(width = 1.dp, color = Color.White)
                    .size(width = 200.dp, height = 40.dp)
            ) {
                Text(
                    text = "Tenho Interesse!",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun CasaNovaCard(
    image: Int,
    nome: String,
    estado: String,
    metrosQuadrados: String,
    quartos: Int,
    banheiros: Int,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD5B82D),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {  navController.navigate("detalhes") }
        ) {
            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Novo",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(Color(0xFFD5B82D))
                            .padding(4.dp)
                    )
                }
            }

            Text(
                text = nome,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            Row {
                TextWithIcon(
                    text = metrosQuadrados,
                    icon = painterResource(id = R.drawable.area),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Text(text = "|",  color = Color.White,)
                TextWithIcon(
                    text = "Quartos: $quartos",
                    icon = painterResource(id = R.drawable.quarto),
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp, bottom = 8.dp)
                )
                Text(text = "|",  color = Color.White,)
                TextWithIcon(
                    text = "Banheiros: $banheiros",
                    icon = painterResource(id = R.drawable.banheiro),
                    modifier = Modifier.padding(start = 8.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            Button(
                onClick = {
                          if (estado=="Alugar"){
                              navController.navigate("alugar")
                          }else{
                              navController.navigate("comprar")
                          }
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.White),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .border(width = 1.dp, color = Color.White)
                    .size(width = 110.dp, height = 40.dp)
            ) {
                Text(
                    text = "$estado",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }


        }
    }
}
@Composable
fun TextWithIcon(
    text: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text,
            color = Color.White,
            fontSize = 14.sp)
    }
}
@Composable
fun CorretorCard(corretor: String,
                 email: String,
                 especializacao:String,
                 phone:String,
                 foto: Int,
                 navController: NavController) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            navController.navigate("home")
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xC1680C0C),
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = foto),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .border(1.dp, color = Color.White, shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Button(
                    onClick = {
                        val phoneNumber = "+55 (11) 910372413"
                        val message = "Olá, estou interessado em um imóvel. Podemos conversar?"
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse("https://wa.me/$phoneNumber/?text=${URLEncoder.encode(message, "UTF-8")}")
                        }
                        launcher.launch(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.White),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .border(width = 1.dp, color = Color.White)
                        .size(width = 180.dp, height = 40.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = "Entrar em Contato")
                }
            }
            Text(
                text = "$corretor",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Row {
                TextWithIcon(
                    text = "$especializacao",
                    icon = painterResource(id = R.drawable.livro),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            Row {
                TextWithIcon(
                    text = "Telefone: $phone",
                    icon = painterResource(id = R.drawable.tel),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            Row {
                TextWithIcon(
                    text = "Email: $email",
                    icon = painterResource(id = R.drawable.email),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
            }
        }
    }
}

