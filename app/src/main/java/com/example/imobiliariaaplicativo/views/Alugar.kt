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
import com.example.imobiliariaaplicativo.components.CasaAluguelCard


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlugarScreen(navController: NavController) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Alugar",
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
                           CasaAluguelCard(
                               image = R.drawable.aluguel1,
                               nome = "Casa - R. César Ladeira, Vila Cruzeiro",
                               valorAluguel = "900",
                               quartos = 2,
                               banheiros = 2,
                               tamanho = "50 m²",
                               navController = navController
                           )
                            CasaAluguelCard(
                                image = R.drawable.aluguel4,
                                nome = "Casa - R. Odorico Mendes, Mooca",
                                valorAluguel = "1500",
                                quartos = 3,
                                banheiros = 2,
                                tamanho = "100 m²",
                                navController = navController
                            )
                            CasaAluguelCard(
                                image = R.drawable.aluguel2,
                                nome = "Casa - R. Benedito Otoni",
                                valorAluguel = "1500",
                                quartos = 3,
                                banheiros = 3,
                                tamanho = "100 m²",
                                navController = navController
                            )
                            CasaAluguelCard(
                                image = R.drawable.aluguel3,
                                nome = "Apartamento - R. Isabel Godim, Saúde",
                                valorAluguel = "850",
                                quartos = 2,
                                banheiros = 1,
                                tamanho = "60 m²",
                                navController = navController
                            )
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
fun PreviewAlugarScreen() {

    val navController = rememberNavController()
    AlugarScreen(navController)
}