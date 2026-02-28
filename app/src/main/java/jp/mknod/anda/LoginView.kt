package jp.mknod.anda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import jp.mknod.anda.ui.theme.LargeButton
import jp.mknod.anda.ui.theme.LargeButtonPadding
//import jp.mknod.anda.data.hashSHA1String
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import jp.mknod.anda.AndaAPI

import android.widget.Toast

class LoginView{

    @Composable
    fun Init(navController: NavController) {

        Column() {
//            AndaTopAppBarNoBack("ANDA")
            LoginContent(navController)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginContent(navController: NavController) {

        val scope = rememberCoroutineScope()
        var _username by rememberSaveable { mutableStateOf("") }
        var _passwd by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .padding(all = 20.dp)
                .background(color = Color(0x00000000)),
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = _username,
                onValueChange = { newText ->
                    _username = newText
                },
                label = { Text("Username") },
                singleLine = true
            )
            Spacer(modifier = Modifier.Companion.height(20.dp))
            OutlinedTextField(
                value = _passwd,
                onValueChange = { newText ->
                    _passwd = newText
                },
                label = { Text("Password") },
                singleLine = true
            )
            Spacer(modifier = Modifier.Companion.height(40.dp))

            Button(
                onClick = {
                    scope.launch {
//                        var _pass = hashSHA1String(_passwd)
//                        var _u: List<UserData>? = db?.user?.get(_username, _pass)
//                        if (_u != null && _u.size > 0) {
//                            println("login")
                            navController.navigate("MENU")
//                        }
                    }
                },
                modifier = Modifier.LargeButton(),
                contentPadding = LargeButtonPadding()
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.Companion.height(20.dp))

            Button(
                onClick = {
                    scope.launch {
                        val api = InitApi()
                        val st = api.getStatus()
                        Toast.makeText( navController.context,
                                        "METHOD=${st.method} STATUS=${st.status}",
                                        Toast.LENGTH_SHORT).show()

                        Log.i("", st.toString())
                    }
                },
                modifier = Modifier.LargeButton(),
                contentPadding = LargeButtonPadding()
            ) {
                Text("API TEST")
            }

        }

    }

}