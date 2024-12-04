package com.xfhy.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.xfhy.composedemo.ui.theme.ComposeDemoTheme

/**
 * 展示一个列表,类似于RecycleView
 */
class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(top = innerPadding.calculateTopPadding())) {
                        DynamicListScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun DynamicListScreen() {
    // 状态变量，用于存储列表数据
    var items by remember {
        mutableStateOf(listOf("点我添加item点我添加item点我添加item点我添加item点我添加itemItem 1", "Item 2"))
    }
    // 按钮点击时添加新项目到列表
    val addButton = @Composable {
        Button(onClick = { items = items + ("Item ${items.size + 1}") }) {
            Text(text = "点我添加item")
        }
    }
    // LazyColumn用于展示列表  类似RecycleView
    LazyColumn {
        item { addButton() }
        itemsIndexed(items) { index, item ->
            // 分割线
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.White)
            )
            // item
            Text(
                text = item,
                fontSize = 16.sp,
                color = Color.Red,
                maxLines = 1,
                // 展示不完时,在末尾添加省略号
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Blue)
                    // 宽  占满
                    .fillMaxWidth()
            )
        }
    }
}
