package com.example.mythirdcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mythirdcomposeapp.MyAlertDialog
import com.example.mythirdcomposeapp.ui.theme.MyThirdComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyThirdComposeAppTheme() {
                //MyConstraintLayout()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    //SuperHeroView()
                    //SuperHeroViewScroll()
                    SuperHeroViewScroll2()
                    //SuperHeroGridView()
                }

                /**
                var sliderPosition by rememberSaveable { mutableStateOf(0f) }

                var openAlert by rememberSaveable { mutableStateOf(false) }

                Column(horizontalAlignment =
                Alignment.CenterHorizontally) {
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it
                            if (sliderPosition > 90f) openAlert = true},
                        valueRange = 0f..100f,
                        steps = 9
                    )
                    Text(text = "%.0f".format(sliderPosition))
                }
                if(openAlert) {
                    MyAlertDialog(
                        onConfirm = { sliderPosition = 80f
                            openAlert = false},
                        onDismiss = { openAlert = false }
                    )
                }
                **/
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyConstraintLayout()
{
    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()

        val glTop = createGuidelineFromTop(0.15f)
        val glBottom = createGuidelineFromBottom(300.dp)
        val glStart = createGuidelineFromStart(0.25f)
        val glEnd = createGuidelineFromEnd(0.15f)

        Box(modifier = Modifier.size(125.dp)
            .background(Color.Red)
            .constrainAs(ref = boxRed)
            {
                top.linkTo(glTop)
                start.linkTo(glStart)
                end.linkTo(glEnd)
                bottom.linkTo(glBottom)
            })

        Box(modifier = Modifier.size(150.dp)
            .background(Color.Blue)
            .constrainAs(ref = boxBlue)
            {
                bottom.linkTo(boxRed.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier.size(100.dp)
            .background(Color.Yellow)
            .constrainAs(ref = boxYellow)
            {
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxBlue.bottom)
                end.linkTo(boxBlue.start)
            })

        Box(modifier = Modifier.size(125.dp)
            .background(Color.Magenta)
            .constrainAs(ref = boxMagenta)
            {
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
    }
}


