package jp.mknod.anda

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jp.mknod.anda.ui.theme.AndaTheme

import androidx.navigation.compose.rememberNavController

import jp.mknod.anda.LoginView
import jp.mknod.anda.MenuView

import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {

    var loginView = LoginView()
    var menuView = MenuView()
    var checkOutView = CheckOutView()
    var thanksView = ThanksView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AndaTheme(false, false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),// fillMaxSizeは、画面いっぱいに表示するための関数
                    color = MaterialTheme.colorScheme.background// colorSchemeは、Material Designの色を設定するための関数
                ) {
                    AndaNavController()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val SDK_INT = android.os.Build.VERSION.SDK_INT
        if (SDK_INT >= 30) {
            window.insetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else if (SDK_INT >= 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        // 画面を横向きに固定
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

    }
    @Composable
    fun AndaNavController() {

        // navControllerを作成
        val navController = rememberNavController()
        // NavHostを作成
        // startDestinationは最初に表示するページ
        NavHost(navController = navController,
            startDestination = "Login") {

            // 最初に表示するページ
            composable(route = "Login") {
                loginView.Init(navController = navController)
            }
            composable(route = "MENU") {
                menuView.Init(navController = navController)
            }
            composable(route = "CHECKOUT") {
                checkOutView.Init(navController = navController)
            }
            composable(route = "THANKS") {
                thanksView.Init(navController = navController)
            }


        }
    }
}

//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AndaTheme {
//        Greeting("Android")
//    }
//}