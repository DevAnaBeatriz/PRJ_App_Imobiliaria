package com.example.imobiliariaaplicativo.components

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imobiliariaaplicativo.R
import java.net.URLEncoder


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DetalhesImoveScreen(navController:NavController) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            navController.navigate("detalhes")
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageSlider()
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fundo3), // Substitua com o ID de sua imagem de fundo
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
        // Descrição
        Text(
            text = "Descrição",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 23.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
                Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Este encantador imóvel é a combinação perfeita de luxo e " +
                    "comodidade. Situado em uma localização privilegiada, esta " +
                    "residência oferece uma vista deslumbrante da cidade e uma" +
                    " ampla variedade de comodidades modernas. ",
            color = Color(0xFF680C0C),

            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Esta propriedade representa o equilíbrio " +
                    "perfeito entre estilo de vida urbano e serenidade," +
                    " tornando-a uma opção única no mercado imobiliário.",
            color = Color(0xFF680C0C),

            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )}}
        Spacer(modifier = Modifier.height(16.dp))

// Principais Características
        Text(
            text = "Principais Características:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Espaçosa casa com bela vista",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Localizada em uma vizinhança tranquila",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

// Características do Bairro
        Text(
            text = "Características do Bairro:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Bairro seguro e familiar",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Próximo a parques e áreas verdes",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

// Localização
        Text(
            text = "Localização:",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Endereço: R. Pascoal Bianco, Pinheiros",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        Text(
            text = "- Cidade: São Paulo - SP",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val phoneNumber = "+55 (11) 910372413"
                val message = "Olá, estou interessado em um imóvel. Podemos agendar uma visita?"
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://wa.me/$phoneNumber/?text=${URLEncoder.encode(message, "UTF-8")}")
                }
                launcher.launch(intent) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF811010), contentColor = Color.White,  ),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
                .clip(RoundedCornerShape(2.dp))
                .border(width = 1.dp, color = Color.White)
                .size(width = 200.dp, height = 40.dp)
        ) {
            Text(
                text = "Agendar Visita",
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.sala,
        R.drawable.cozinha,
        R.drawable.quarto1,
        R.drawable.banheiro2,
        R.drawable.banheiro3
    )
    val pagerState = rememberPagerState(pageCount = {images.size})

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Box(modifier = Modifier.weight(1f)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp)
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        PagerIndicator(pagerState = pagerState)
        }
    }


}




private val imageResources = listOf(
    R.drawable.foto1,
    R.drawable.foto2,
    R.drawable.foto3,
    R.drawable.foto4,
    R.drawable.novo1
)











@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    indicatorCount: Int = 5,
    indicatorSize: Dp = 16.dp,
    indicatorShape: Shape = CircleShape,
    space: Dp = 8.dp,
    activeColor: Color = Color(0xFF811010),
    inActiveColor: Color = Color.LightGray,
    orientation: IndicatorOrientation = IndicatorOrientation.Horizontal,
    onClick: ((Int) -> Unit)? = null
) {

    val listState = rememberLazyListState()

    val totalWidth: Dp = indicatorSize * indicatorCount + space * (indicatorCount - 1)
    val widthInPx = LocalDensity.current.run { indicatorSize.toPx() }

    val currentItem by remember {
        derivedStateOf {
            pagerState.currentPage
        }
    }

    val itemCount = pagerState.pageCount

    LaunchedEffect(key1 = currentItem) {
        val viewportSize = listState.layoutInfo.viewportSize
        if (orientation == IndicatorOrientation.Horizontal) {
            listState.animateScrollToItem(
                currentItem,
                (widthInPx / 2 - viewportSize.width / 2).toInt()
            )
        } else {
            listState.animateScrollToItem(
                currentItem,
                (widthInPx / 2 - viewportSize.height / 2).toInt()
            )
        }

    }

    if (orientation == IndicatorOrientation.Horizontal) {
        LazyRow(
            modifier = modifier.width(totalWidth),
            state = listState,
            contentPadding = PaddingValues(vertical = space),
            horizontalArrangement = Arrangement.spacedBy(space),
            userScrollEnabled = false
        ) {
            indicatorItems(
                itemCount,
                currentItem,
                indicatorCount,
                indicatorShape,
                activeColor,
                inActiveColor,
                indicatorSize,
                onClick
            )
        }
    } else {
        LazyColumn(
            modifier = modifier.height(totalWidth),
            state = listState,
            contentPadding = PaddingValues(horizontal = space),
            verticalArrangement = Arrangement.spacedBy(space),
            userScrollEnabled = false
        ) {
            indicatorItems(
                itemCount,
                currentItem,
                indicatorCount,
                indicatorShape,
                activeColor,
                inActiveColor,
                indicatorSize,
                onClick
            )
        }
    }

}

private fun LazyListScope.indicatorItems(
    itemCount: Int,
    currentItem: Int,
    indicatorCount: Int,
    indicatorShape: Shape,
    activeColor: Color,
    inActiveColor: Color,
    indicatorSize: Dp,
    onClick: ((Int) -> Unit)?
) {
    items(itemCount) { index ->

        val isSelected = (index == currentItem)

        // Index of item in center when odd number of indicators are set
        // for 5 indicators this is 2nd indicator place
        val centerItemIndex = indicatorCount / 2

        val right1 =
            (currentItem < centerItemIndex &&
                    index >= indicatorCount - 1)

        val right2 =
            (currentItem >= centerItemIndex &&
                    index >= currentItem + centerItemIndex &&
                    index < itemCount - centerItemIndex + 1)
        val isRightEdgeItem = right1 || right2

        // Check if this item's distance to center item is smaller than half size of
        // the indicator count when current indicator at the center or
        // when we reach the end of list. End of the list only one item is on edge
        // with 10 items and 7 indicators
        // 7-3= 4th item can be the first valid left edge item and
        val isLeftEdgeItem =
            index <= currentItem - centerItemIndex &&
                    currentItem > centerItemIndex &&
                    index < itemCount - indicatorCount + 1

        Box(
            modifier = Modifier
                .graphicsLayer {
                    val scale = if (isSelected) {
                        1f
                    } else if (isLeftEdgeItem || isRightEdgeItem) {
                        .5f
                    } else {
                        .8f
                    }
                    scaleX = scale
                    scaleY = scale

                }

                .clip(indicatorShape)
                .size(indicatorSize)
                .background(
                    if (isSelected) activeColor else inActiveColor,
                    indicatorShape
                )
                .then(
                    if (onClick != null) {
                        Modifier
                            .clickable {
                                onClick.invoke(index)
                            }
                    } else Modifier
                )
        )
    }
}

enum class IndicatorOrientation {
    Horizontal, Vertical
}