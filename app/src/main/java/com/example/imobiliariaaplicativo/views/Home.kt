package com.example.imobiliariaaplicativo.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import com.example.imobiliariaaplicativo.R

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imobiliariaaplicativo.components.MenuButton

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Imobiliária",
                    color = Color.White,
                    fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF680C0C)

                )
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fundo), // Substitua com o ID de sua imagem de fundo
                    contentDescription = null, // Descrição de conteúdo nula, pois é uma imagem de fundo
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    item {

//                        Text(text = "Menu de Opções",
//                            modifier=Modifier.padding(8.dp),
//                            color = Color(0xFF680C0C),
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 35.sp)

                        Row {
                            MenuButton(
                                icon = R.drawable.comprar,
                                title = "Comprar",
                                onClick = { navController.navigate("comprar") },
                                cor = 0xFF0E5F11
                            )
                            MenuButton(
                                icon = R.drawable.alugar,
                                title = "Alugar",
                                onClick = { navController.navigate("alugar") },
                                cor = 0xFF200C68
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            MenuButton(
                                icon = R.drawable.novos,
                                title = "Novos",
                                onClick = { navController.navigate("novos") },
                                cor = 0xFFD5B82D
                            )
                            MenuButton(
                                icon = R.drawable.anunciar,
                                title = "Anuncie no app",
                                onClick = { navController.navigate("anunciar") },
                                cor = 0xFFDD4D1F
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            MenuButton(
                                icon = R.drawable.time,
                                title = "Nosso time",
                                onClick = { navController.navigate("nossotime") },
                                cor = 0xFF680C0C
                            )
                            MenuButton(
                                icon = R.drawable.sobre,
                                title = "Sobre nós",
                                onClick = { navController.navigate("sobrenos") },
                                cor = 0xFF0E6B77
                            )
                        }
                    }
                }
            }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF680C0C),

            ) {
                Text(text = "Desenvolvido por: Ana Beatriz Martins Batista RM: 22284",
                    fontSize= 12.sp,
                    textAlign = TextAlign.Center,
                    modifier= Modifier.fillMaxSize().padding(25.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold)
            }
        }
    )
}



@Preview
@Composable
fun PreviewMenuScreen() {

    val navController = rememberNavController()
    HomeScreen(navController)
}
