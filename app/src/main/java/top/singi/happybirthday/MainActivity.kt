package top.singi.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.singi.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    生日祝福
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_sam),
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*
* 生日祝福语
* */
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

/*
* 生日贺卡
* */
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message, from,
            Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

/*
* 文章页
* */
@Composable
fun Article(modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

/*
* 结果页
* */
@Composable
fun Result(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(text = "Nice work!", fontSize = 16.sp)
    }
}

/*
* 四象限布局
* */
@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantText(
                title = "Text composable",
                content = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier
                    .background(
                        Color(0xFFEADDFF)
                    )
                    .weight(1f)
            )
            QuadrantText(
                title = "Image composable",
                content = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .background(
                        Color(0xFFD0BCFF)
                    )
                    .weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantText(
                title = "Row composable",
                content = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .background(
                        Color(0xFFB69DF8)
                    )
                    .weight(1f)
            )
            QuadrantText(
                title = "Column composable",
                content = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .background(
                        Color(0xFFF6EDFF)
                    )
                    .weight(1f)
            )
        }
    }
}

/*
* 四象限内容
* */
@Composable
fun QuadrantText(title: String, content: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = content, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            GreetingImage(message = stringResource(R.string.happy_birthday_sam),
                from = stringResource(R.string.signature_text),
                modifier = Modifier.padding(innerPadding))

//            Article()

//            Result()

//            Quadrant(
//                modifier = Modifier.padding(innerPadding)
//            )
        }
    }
}