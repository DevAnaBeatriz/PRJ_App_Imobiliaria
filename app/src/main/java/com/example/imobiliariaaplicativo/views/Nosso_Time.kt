package com.example.imobiliariaaplicativo.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imobiliariaaplicativo.R
import com.example.imobiliariaaplicativo.components.CasaNovaCard
import com.example.imobiliariaaplicativo.components.CorretorCard


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Nosso_TimeScreen(navController: NavController) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Nosso Time",
                        color = Color.White,
                        fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF680C0C)

                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack() // Navegar de volta à tela anterior
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White,
                        )
                    }
                },
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
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()

                            .background(Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        item {

                            Spacer(modifier = Modifier.height(90.dp))
                            CorretorCard(corretor = "Andreia Pereira",
                                email = "andreia@gmail.com",
                                especializacao = "FATEC - Vendas e Negociações",
                                phone = "(11) 92025 - 2546",
                                foto=R.drawable.foto1,
                                navController = navController)
                            CorretorCard(corretor = "Suzane Rosana",
                                email = "suzane@gmail.com",
                                especializacao = "UNESP - Marketing",
                                phone = "(11) 95227 - 4541",
                                foto=R.drawable.foto2,
                                navController = navController)
                            CorretorCard(corretor = "Luciane Santana",
                                email = "luciane@gmail.com",
                                especializacao = "USP - Marketing e Administração",
                                phone = "(11) 94748 - 3614",
                                foto=R.drawable.foto3,
                                navController = navController)
                            CorretorCard(corretor = "Helena Soares",
                                email = "helena@gmail.com",
                                especializacao = "UNICID - Vendas e Negociações",
                                phone = "(11) 91587 - 8874",
                                foto=R.drawable.foto4,
                                navController = navController)
                            Spacer(modifier = Modifier.height(110.dp))
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
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold)
            }
        }
    )
}

@Preview
@Composable
fun PreviewNosso_TimeScreen() {

    val navController = rememberNavController()
    Nosso_TimeScreen(navController)
}


