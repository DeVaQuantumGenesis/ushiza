package com.example.ushiza.views
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


class HoneViewActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                HomeAppBar()
                FABExample()
            }
        }
    }
}

//アプリバーのコード
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar() {
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "Home")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "HumanIcons",
                        )
                    }
                }
            )
        },
    ) {
        //innerPaddingにスクロール可能なビューなどを適用する場合はmodifier: Modifier = Modifierが必要
        innerPadding ->
        ScrollViewExample(modifier = Modifier.padding( paddingValues = innerPadding))
    }

}

//スクロール可能なビューのコード
@Composable
fun ScrollViewExample(modifier: Modifier = Modifier) {
    //スクロール状態を監視する関数
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) {
        //スクロール可能なビューに配置したい内容
        Text(text = "This is the test app")
    }
}

//FAB(Floating Action Button)に関するコード
@Composable
fun FABExample() {
   Scaffold(
       floatingActionButton = {
           FloatingActionButton(
               //タップ時のアクションを定義
               onClick = {}
           ) {
               //外観のアイコンを定義
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "追加"
               )
           }
       }
   ) {
       //重ねるビューを定義
       contentPadding ->
       ScrollViewExample(modifier = Modifier.padding( paddingValues = contentPadding))
   }
}