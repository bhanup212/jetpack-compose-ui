package bhanu.app.jetpackcomposeui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.input.EditorStyle
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Composable
    fun myApp() {
        MaterialTheme {
            //Counter()
            //verticalScrollbar()
            //horizontalScrollView()
            radioGroup()
            //alertDialog()
        }
    }

    @Preview
    @Composable
    fun Counter() {
        val amount = +state { 0 }

        val name = +state { "Enter your name" }
        Stack{
            aligned(Alignment.TopCenter){
                Text(text = "Counter is: ${amount.value}", style = TextStyle(color = Color.Magenta, fontSize = 20.sp))
                TextField(value =name.value,onValueChange = {name.value = it},editorStyle = EditorStyle(selectionColor = Color.Transparent) ,keyboardType = KeyboardType.Text)

            }
            aligned(Alignment.BottomCenter){
                Button(text = "Next",onClick = {amount.value++},style = ContainedButtonStyle())
            }
            aligned(Alignment.BottomRight){
                Padding(padding = 12.dp) {
                    FloatingActionButton(
                            color = Color.Gray,
                            text = "+",
                            textStyle = TextStyle(color = Color.White)
                    )
                }
            }
            aligned(Alignment.Center){
                ColoredRect(
                        width = 50.dp,
                        height = 50.dp,
                        color = Color.Blue
                )
            }
        }

    }

    @Preview
    @Composable
    fun verticalScrollbar(){
        VerticalScroller {
            Column {
                for (i in 0..50){
                    Padding(padding = 20.dp) {
                        Text(text = "Hello World: $i",style = TextStyle(color = Color.Black,fontSize = 20.sp,background = Color.Gray))
                    }

                }
            }
        }
    }
    @Preview
    @Composable
    fun horizontalScrollView(){
        HorizontalScroller {
            Row() {
               for (i in 0..40){
                   Padding(padding = 12.dp) {
                       Text(text = "Hello world: $i")
                   }
               }
            }
        }
    }

    @Preview
    @Composable
    fun radioGroup(){
        val options = listOf("Male","Female","Others")
        val (selectedOption,onOptionSelected) = +state{options[0]}
        Column(crossAxisAlignment = CrossAxisAlignment.Stretch,
            crossAxisSize = LayoutSize.Wrap) {
            toolbar()
            Text(text = "Choose Gender")
            RadioGroup(options = options, selectedOption = selectedOption, onSelectedChange = onOptionSelected)
        }

        Log.d("TAG","onOptionSelected: $selectedOption")
    }
    @Composable
    fun toolbar(){
        Center {
            TopAppBar(title = { Text(text = "Basic info")} )
        }
    }

    @Composable
    fun alertDialog(){
        val openDialog = +state { false }
        Container(alignment = Alignment.BottomCenter) {
            Button(text = "Open Dialog",onClick = {openDialog.value = true})
        }
        if (openDialog.value){
            AlertDialog(onCloseRequest = {openDialog.value=false},
                    title = { Text(text = "Are you sure want to logout?")},
                    text = { Text(text = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting ")},
                    confirmButton = { Button(text = "Logout",onClick = {openDialog.value = false})},
                    dismissButton = { Button(text = "Cancel",onClick = {openDialog.value= false})})
        }
    }
}
