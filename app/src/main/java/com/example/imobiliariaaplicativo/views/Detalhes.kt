package com.example.imobiliariaaplicativo.views

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imobiliariaaplicativo.components.DetalhesImoveScreen
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalharScreen(navController: NavController) {
    var isFavorite by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                Snackbar(
                    modifier = Modifier.padding(16.dp),
                    shape = RoundedCornerShape(8.dp),
                    snackbarData = snackbarData,
                    containerColor = Color(0xFF680C0C),
                    contentColor = Color.White,
                    actionColor = Color(0xFF333536),
                    dismissActionContentColor = Color.White,

                    )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detalhes do Imóvel",
                        color = Color.White,
                        fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF680C0C),


                ),
                actions = {
                    IconButton(
                        onClick = { isFavorite = !isFavorite
                            if(isFavorite){
                            scope.launch {
                                snackbarHostState.showSnackbar("Imóvel adicionado aos favoritos!", duration = SnackbarDuration.Short, withDismissAction = true)
                            }}else{
                                scope.launch {
                                    snackbarHostState.showSnackbar("Imóvel removido dos favoritos!", duration = SnackbarDuration.Short, withDismissAction = true)
                                }
                            }
                        }
                    ) {
                        val favoriteIcon = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder
                        Icon(imageVector = favoriteIcon, contentDescription = null, tint= Color.White)
                    }
                },
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
                    .background(color= Color.White)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.Top,
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




                            DetalhesImoveScreen( navController = navController)



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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewDetalharScreen() {

    val navController = rememberNavController()
    DetalharScreen(navController)
}
