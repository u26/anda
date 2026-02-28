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
import androidx.compose.ui.unit.sp
import jp.mknod.anda.ui.theme.AndaTopAppBarNoBack

class CheckOutView{

    @Composable
    fun Init(navController: NavController) {

        Column() {
            AndaTopAppBarNoBack("ANDA")
            CheckOutContent(navController)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CheckOutContent(navController: NavController) {

        val scope = rememberCoroutineScope()
//        var _username by rememberSaveable { mutableStateOf("") }
        var total by rememberSaveable { mutableStateOf(0) }

        Column(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 20.dp)
                .background(color = Color(0x00000000)),
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "MOMO CODE:",
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.Companion.height(40.dp))

            Text(
                "*182*3#*0000081*${total}",
                fontSize = 72.sp,
            )

            Spacer(modifier = Modifier.Companion.height(40.dp))

            Button(
                onClick = {
                    scope.launch {
                        val api = InitApi()
                        val st = api.getStatus()
                        Toast.makeText( navController.context,
                                        "METHOD=${st.method} STATUS=${st.status}",
                                        Toast.LENGTH_SHORT).show()

                        Log.i("", st.toString())

                        navController.navigate("THANKS")
                    }
                },
                modifier = Modifier.LargeButton(),
                contentPadding = LargeButtonPadding()
            ) {
                Text("PAYED",
                    fontSize = 20.sp,
                )
            }
        }

    }

}