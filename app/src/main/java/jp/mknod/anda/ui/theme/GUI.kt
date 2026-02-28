package jp.mknod.anda.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndaTopAppBarNoBack(titlename: String) {

    Column {
        TopAppBar(
            // TopAppBarの色を設定する
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.background,
            ),
//            colors = TopAppBarDefaults.largeTopAppBarColors(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                titleContentColor = MaterialTheme.colorScheme.primary,
//            ),
            // TopAppBarのタイトルを設定する
            title = {
                Text(titlename)

            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndaTopAppBar(titlename: String, navigateBack: () -> Unit) {

//    Column {
    TopAppBar(
        // TopAppBarの色を設定する
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        },
        // TopAppBarのタイトルを設定する
        title = {
            Text(titlename)

        }
    )
//    }
}


fun Modifier.SmallButton(): Modifier = this
    .width(55.dp)
    .height(55.dp)

fun SmallButtonPadding(): PaddingValues =
    PaddingValues(
        start = 8.dp,
        top = 8.dp,
        end = 8.dp,
        bottom = 8.dp
    )


fun Modifier.LargeButton(): Modifier = this
    .width(220.dp)
    .height(60.dp)


fun LargeButtonPadding(): PaddingValues =
    PaddingValues(
        start = 20.dp,
        top = 12.dp,
        end = 20.dp,
        bottom = 12.dp
    )
