package com.xfhy.composedemo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.xfhy.composedemo.ui.theme.ComposeDemoTheme

/**
 * Compose中添加Android View
 */
class ViewInComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier, context: Context) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        // 添加已有的View
        AndroidView({
            Button(context).apply {
                setText("卧槽")
                setTextColor(R.color.black)
                setOnClickListener {
                    Toast.makeText(context, "卧槽", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    ComposeDemoTheme {
//        Greeting2("Android")
//    }
//}