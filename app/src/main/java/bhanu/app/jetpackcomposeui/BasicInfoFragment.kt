package bhanu.app.jetpackcomposeui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class BasicInfoFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as ViewGroup).setContent {
            appBar()
        }
    }

    @Composable
    fun appBar(data:JsonObj = JsonObj()) {

        MaterialTheme {

            Column {
                TopAppBar(title = { Text(text = "Basic info") })
                Column(crossAxisAlignment = CrossAxisAlignment.Start, modifier = Spacing(30.dp)) {
                    Text(text = "isChecked: ${data.isChecked.value}")
                    Row {
                        Checkbox(checked = data.isChecked.value ,onCheckedChange = {newState -> data.isChecked.value = newState})
                        Text(text = "Rented home")
                    }
                    
                }
            }

        }
    }
}