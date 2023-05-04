package com.example.lemonedaapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonedaapps.ui.theme.LemonedaAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonedaAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {

                    AppLimoneda()

                }
            }
        }
    }
}


@Preview
@Composable
fun AppLimoneda(){

    var image by remember { mutableStateOf(1) }


    when (image) {
        1 -> LemonImage(
            R.string.limoeiro,
            R.drawable.lemon_tree,
            onImageClick = {
                image = 2
            }
        )
        2 -> LemonImage(
            R.string.limao,
            R.drawable.lemon_squeeze,
            onImageClick = {
                image = 3
            }
        )
        3 -> LemonImage(
            R.string.limonada,
            R.drawable.lemon_drink,
            onImageClick = {
                image = 4
            }
        )
        4 -> LemonImage(
            R.string.vazio,
            R.drawable.lemon_restart,
            onImageClick = {
                image = 1
            }
        )
    }



}


@Composable
fun LemonImage(recursoTextId: Int, recursoImageId: Int, onImageClick:()-> Unit){

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(recursoTextId),
            color = Color.Black,
            modifier = Modifier
                .padding(5.dp)
                .padding(20.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif
        )

        Image(
            painter = painterResource(id = recursoImageId),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .border(
                    BorderStroke(2.dp, Color.Cyan),
                    RoundedCornerShape(5.dp)
                )
                .clickable(onClick = onImageClick)

        )

    }

}