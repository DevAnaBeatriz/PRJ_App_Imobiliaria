package com.example.imobiliariaaplicativo.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPropertyForm(snackbarHostState: SnackbarHostState,
                    scope: CoroutineScope,) {
    var propertyType by remember { mutableStateOf(PropertyType.SALE) }
    var address by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var iptu by remember { mutableStateOf("") }
    var installmentValue by remember { mutableStateOf("") }
    var rentType by remember { mutableStateOf(RentType.APARTMENT) }
    var rentAddress by remember { mutableStateOf("") }
    var rentPrice by remember { mutableStateOf("") }
    var squareMeter by remember { mutableStateOf("") }
    var numRooms by remember { mutableStateOf("") }
    var numBathrooms by remember { mutableStateOf("") }

    val propertyTypeOptions = listOf(PropertyType.SALE, PropertyType.RENT)
    val rentTypeOptions = listOf(RentType.APARTMENT, RentType.HOUSE)

    var expandedPropertyType by remember { mutableStateOf(false) }
    var expandedRentType by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = "Informe os dados do Imóvel",
            color = Color.Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().height(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cadastro:",
                color= Color.Black,
                modifier = Modifier.weight(1f)
            )

            RadioButton(
                selected = propertyType == PropertyType.SALE,
                onClick = { propertyType = PropertyType.SALE },
                modifier = Modifier.padding(end = 8.dp),
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
            )
            Text(text = "Venda",
                color= Color.Black,)

            RadioButton(
                selected = propertyType == PropertyType.RENT,
                onClick = { propertyType = PropertyType.RENT },
                modifier = Modifier.padding(start = 16.dp),
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
            )
            Text(text = "Aluguel",
                color= Color.Black,)
        }

        if (propertyType == PropertyType.SALE) {
            Row (modifier = Modifier.fillMaxWidth().height(25.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Imóvel:",
                    color= Color.Black,
                    modifier = Modifier.weight(1f)
                )

                RadioButton(
                    selected = rentType == RentType.APARTMENT,
                    onClick = { rentType = RentType.APARTMENT },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
                )
                Text(text = "Apartamento",
                    color= Color.Black,)

                RadioButton(
                    selected = rentType == RentType.HOUSE,
                    onClick = { rentType = RentType.HOUSE },
                    modifier = Modifier.padding(start = 16.dp),
                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
                )
                Text(text = "Casa",
                    color= Color.Black,)}
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Endereço",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),  keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )


            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Valor",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = iptu,
                onValueChange = { iptu = it },
                label = { Text("IPTU",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = installmentValue,
                onValueChange = { installmentValue = it },
                label = { Text("Valor das Parcelas",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )
            OutlinedTextField(
                value = squareMeter,
                onValueChange = { squareMeter = it },
                label = { Text("Metragem Quadrada",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = numRooms,
                onValueChange = { numRooms = it },
                label = { Text("Número de Quartos",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = numBathrooms,
                onValueChange = { numBathrooms = it },
                label = { Text("Número de Banheiros",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Done)
            )

        } else {
            Row (modifier = Modifier.fillMaxWidth().height(25.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Imóvel:",
                    color= Color.Black,
                    modifier = Modifier.weight(1f)
                )

                RadioButton(
                    selected = rentType == RentType.APARTMENT,
                    onClick = { rentType = RentType.APARTMENT },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
                )
                Text(text = "Apartamento",
                    color= Color.Black,)

                RadioButton(
                    selected = rentType == RentType.HOUSE,
                    onClick = { rentType = RentType.HOUSE },
                    modifier = Modifier.padding(start = 16.dp),
                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF680C0C))
                )
                Text(text = "Casa",
                    color= Color.Black,)}
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Endereço",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),  keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = rentPrice,
                onValueChange = { rentPrice = it },
                label = { Text("Valor do Aluguel",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = squareMeter,
                onValueChange = { squareMeter = it },
                label = { Text("Metragem Quadrada",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = numRooms,
                onValueChange = { numRooms = it },
                label = { Text("Número de Quartos",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Next)
            )

            OutlinedTextField(
                value = numBathrooms,
                onValueChange = { numBathrooms = it },
                label = { Text("Número de Banheiros",
                    color= Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF680C0C),
                    cursorColor = Color(0xFF680C0C),
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Done)
            )
        }
        Button(
            onClick = { scope.launch {
                snackbarHostState.showSnackbar("Imóvel adicionado com sucesso!", duration = SnackbarDuration.Short, withDismissAction = true)
            } },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF680C0C), contentColor = Color.White),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top=16.dp)
                .clip(RoundedCornerShape(2.dp))
                .border(width = 1.dp, color = Color.White)
                .size(width = 200.dp, height = 40.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Adicionar Imóvel",
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}


enum class PropertyType {
    SALE,
    RENT
}

enum class RentType {
    APARTMENT,
    HOUSE
}
