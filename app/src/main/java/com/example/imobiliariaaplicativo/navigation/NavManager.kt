package com.example.imobiliariaaplicativo.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imobiliariaaplicativo.components.imobiliariaData
import com.example.imobiliariaaplicativo.views.AlugarScreen
import com.example.imobiliariaaplicativo.views.AnunciarScreen
import com.example.imobiliariaaplicativo.views.ComprarScreen
import com.example.imobiliariaaplicativo.views.DetalharScreen
import com.example.imobiliariaaplicativo.views.HomeScreen
import com.example.imobiliariaaplicativo.views.Nosso_TimeScreen
import com.example.imobiliariaaplicativo.views.NovosScreen
import com.example.imobiliariaaplicativo.views.Sobre_NosScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationM(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("alugar"){
            AlugarScreen(navController)
        }

        composable("anunciar"){
            AnunciarScreen(navController)
        }

        composable("comprar"){
           ComprarScreen(navController)
        }

        composable("home"){
            HomeScreen(navController)
        }

        composable("nossotime"){
            Nosso_TimeScreen(navController)
        }

        composable("novos"){
            NovosScreen(navController)
        }

        composable("sobrenos"){
            Sobre_NosScreen(navController, imobiliariaData)
        }

        composable("detalhes"){
            DetalharScreen(navController)
        }

    }

}



@Preview(showBackground = true)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    HomeScreen(navController)
}