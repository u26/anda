package jp.mknod.anda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jp.mknod.anda.ui.theme.AndaTheme
import jp.mknod.anda.ui.theme.AndaTopAppBarNoBack
import jp.mknod.anda.ui.theme.LargeButton
import jp.mknod.anda.ui.theme.LargeButtonPadding
//import jp.mknod.anda.data.hashSHA1String
import kotlinx.coroutines.launch

import androidx.compose.material3.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import jp.mknod.anda.ui.theme.SmallButton
import jp.mknod.anda.ui.theme.SmallButtonPadding
import kotlin.toString

//import androidx.compose.foundation.layout.Arrangement

class MenuView {

    @Composable
    fun Init(navController: NavController) {

        Column() {
            AndaTopAppBarNoBack("ANDA")
            MenuViewContent(navController)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MenuViewContent(navController: NavController) {

        var _username by rememberSaveable { mutableStateOf("") }
        var _passwd by rememberSaveable { mutableStateOf("") }

        MenuLayout(navController)
    }
}







@Composable
fun MenuLayout(navController: NavController, modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    var total by rememberSaveable { mutableStateOf(0) }

    Row(modifier = Modifier.fillMaxSize()) {

        // ### LEFT SIDE
        //
        Row(
            modifier = Modifier
                .weight(7.0f)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xffdddddd)),
        ) {
            Column(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(all = 20.dp)
                    .background(color = Color(0xffdddddd)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                FlowRow(
                    modifier = Modifier.fillMaxSize()
                        .padding(10.dp),
                    maxItemsInEachRow = 3,
                    horizontalArrangement = Arrangement.Start
                ) {

                    var mi =  ArrayList<MenuItem>()
                    mi.add(
                        MenuItem("1",
                        "TEST1",
                        1000,
                        "https://www.underconsideration.com/brandnew/archivesg/android_2019_logo_inverse.png") )
                    mi.add(
                        MenuItem("2",
                            "TEST2",
                            2000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("3",
                            "TEST3",
                            3000,
                            "https://www.underconsideration.com/brandnew/archives/dandroid_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("4",
                            "TEST4",
                            4000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("4",
                            "TEST4",
                            4000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("4",
                            "TEST4",
                            4000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("4",
                            "TEST4",
                            4000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    mi.add(
                        MenuItem("4",
                            "TEST4",
                            4000,
                            "https://www.underconsideration.com/brandnew/archives/android_2019_logo_inverse.png") )

                    for (m in mi) {
                        MenuItemCard(navController, m)
                    }
                }
                Spacer(modifier = Modifier.Companion.height(40.dp))
            }
        }

        // ### RIGHT SIDE
        //
        Row(
            modifier = Modifier.Companion
                .weight(2.9f)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0x00000000)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
//                        .padding(10.dp,20.dp,10.dp,20.dp)
                    .background(color = Color(0x00000000)),
            ) {

                // ORDER ITEMS
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp,10.dp,10.dp,0.dp)
                        .verticalScroll(rememberScrollState())
                        .background(color = Color(0xffCCCCCC)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    var mi =  ArrayList<MenuItem>()
                    mi.add( MenuItem("0", "TEST1",1000,"") )
                    mi.add( MenuItem("1", "TEST2",2000,"") )

                    for (i: Int in 1..mi.size) {
                        OrderItem()
                    }
                }

                // SUB TOTAL
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp)
                        .background(color = Color(0xffAAAAAA)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Spacer(modifier = Modifier.Companion.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = SpaceBetween,
                        modifier = Modifier.background(color = Color(0xffffffff))
                    ) {
                        Text(
                            "Sub Total:",
                            fontSize = 18.sp,
                        )
                        Text(
                            "${total}",
                            fontSize = 22.sp,
                        )
                        Text(
                            ".Rwf",
                            fontSize = 16.sp,
                        )
                    }

                    Spacer(modifier = Modifier.Companion.height(10.dp))
                    Button(
                        onClick = {
                            scope.launch {
                            }
                        },
                        modifier = Modifier.LargeButton(),
                        contentPadding = LargeButtonPadding()
                    ) {
                        Text(
                            "Order",
                            fontSize = 20.sp,
                        )
                    }
                }

                // TOTAL
                Column(
                    modifier = Modifier
                        .weight(1.0f)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp)
                        .background(color = Color(0x0ffffff)),
                    horizontalAlignment = Alignment.Companion.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = SpaceBetween
                    ) {
                        Text(
                            "Total:",
                            fontSize = 18.sp,
                        )
                        Text(
                            "${total}",
                            fontSize = 22.sp,
                        )
                        Text(
                            ".Rwf",
                            fontSize = 16.sp,
                        )
                    }

                    Spacer(modifier = Modifier.Companion.height(10.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                navController.navigate("CHECKOUT")
                            }
                        },
                        modifier = Modifier.LargeButton(),
                        contentPadding = LargeButtonPadding()
                    ) {
                        Text(
                            "Check Out",
                            fontSize = 20.sp,
                        )
                    }
                }

            }
        }
    }
}



@Composable
fun OrderItem() {
    Row( modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
//                .padding(0.dp,0.dp,0.dp, 10.dp)
            .background(color = Color(0x00000000)),
            verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            "Title goes here",
            fontSize = 18.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth()
                .weight(6f)
                .background(color = Color(0xffffffff)),

            )
        Text(
            "1",
            fontSize = 18.sp,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .background(color = Color(0xfffffff)),
            )

        Button(
            onClick = {
            },
            modifier = Modifier.SmallButton(),
//                contentPadding = SmallButtonPadding()
        ) {
            Text(
                "+",
                fontSize = 20.sp,
            )
        }
        Button(
            onClick = {
            },
            modifier = Modifier.SmallButton(),
//                contentPadding = SmallButtonPadding()
        ) {
            Text(
                "-",
                fontSize = 20.sp,
            )
        }

    }
}

@Composable
fun MenuItemCard( navController: NavController ,mi: MenuItem) {

    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }
    var num by remember { mutableStateOf(0) }

    if (showDialog) {
        Dialog(
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            ),
            onDismissRequest = {
                // ダイアログがキャンセルになった時の処理
                showDialog = false
            },
            content = {
                Card( modifier = Modifier
                    .widthIn(max = 1000.dp)
                    .wrapContentWidth()
                    .size(1000.dp,600.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(color = Color(0xffdddddd)),
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(mi.img)
                                .crossfade(true)
                                .build(),
                            contentDescription = "IMG",
                            modifier = Modifier
                                .weight(5.0f)
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            //                                    .aspectRatio(ratio = 3f),
                            alignment = Alignment.Center,
                            //                                contentScale = ContentScale.FillHeight,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.ic_launcher_background),       // An error drawable
                        )

                        Box(
                            Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .weight(5.0f)
                                .fillMaxHeight()
                        ){
                            Column(
                                Modifier
                                    .padding(20.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Top
                            ) {
                                IconButton(
                                    modifier = Modifier.size(50.dp),
                                    onClick = {
                                    showDialog=false
                                }) {
                                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                                }
                            }

                            Column(
                                Modifier
                                    .background(color = Color(0x00000000))
                                    .padding(40.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    mi.title,
                                    fontSize = 24.sp,
                                    style = MaterialTheme.typography.titleLarge
                                )

                                Spacer(modifier = Modifier.Companion.height(20.dp))
                                Text(
                                    text = mi.price.toString() + ".rwf",
                                    fontSize = 24.sp,
                                    style = MaterialTheme.typography.bodyLarge
                                )

                                Spacer(modifier = Modifier.Companion.height(30.dp))
                                Text(
                                    text="あのイーハトーヴォのすきとおった風、夏でも底に冷たさをもつ青いそら、うつくしい森で飾られたモリーオ市、郊外のぎらぎらひかる草の波。\n",
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.titleLarge
                                )

                                Spacer(modifier = Modifier.Companion.height(20.dp))

                                Row(
                                    modifier = Modifier
                                        .height(60.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment=Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center) {
                                    Text(
                                        modifier = Modifier.width(60.dp),
                                        text = num.toString(),
                                        fontSize = 40.sp,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                    Spacer(modifier = Modifier.Companion.height(10.dp))

                                    IconButton(
                                        modifier = Modifier.size(60.dp),
                                        onClick = {
                                            num++
//                                            showDialog=false
                                        }) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = "Close")
                                    }

                                    Spacer(modifier = Modifier.Companion.height(20.dp))
                                    IconButton(
                                        modifier = Modifier.size(60.dp),
                                        onClick = {
                                            num--
                                            if(num<=0){
                                                num=0
                                            }
//                                            showDialog=false
                                        }) {
                                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Close")
                                    }

                                }


                            }

                            Column(
                                Modifier
                                    .padding(20.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Button(
                                    onClick = {
                                    },
                                    modifier = Modifier.LargeButton(),
                                    contentPadding = LargeButtonPadding(),
                                ) {
                                    Text(
                                        "ADD",
                                        fontSize = 20.sp,
                                    )
                                }
                            }
                        }
                    }
                }

            }
        )
    }

    Card(
        onClick = {
            showDialog = true
        },
        modifier = Modifier
            .size(280.dp, 280.dp)
            .padding(15.dp)
    ) {
        CardContent(mi)
    }
}

@Composable
fun DialogContent(mi:MenuItem, showDialog: Boolean){


}

@Composable
fun CardContent(mi:MenuItem){
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(mi.img)
                .crossfade(true)
                .build(),
            contentDescription = "IMG",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1.5f),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_launcher_background),       // An error drawable
        )

        Column(Modifier.padding(16.dp)) {
            Text(
                "Title goes here",
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                "1000.rwf",
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndaTheme {
        // rememberNavController() を使ってダミーのコントローラーを作成
        val mockNavController = rememberNavController()
        MenuLayout(mockNavController)
    }
}
