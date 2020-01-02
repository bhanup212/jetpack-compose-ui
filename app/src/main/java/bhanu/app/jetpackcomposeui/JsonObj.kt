package bhanu.app.jetpackcomposeui

import androidx.compose.Model
import androidx.compose.state
import androidx.compose.unaryPlus

@Model
class JsonObj {
    var isChecked = +state { false }
    var input: String = "enter name here"
}