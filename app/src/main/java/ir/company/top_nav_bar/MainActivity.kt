package ir.company.top_nav_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.company.top_nav_bar.ui.theme.Top_Nav_BarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TopNavBar()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopNavBar() {


    @Composable
    fun InfoTab() {
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(500.dp)
                .background(Color(0xFF52B788))
                .border(1.dp, Color(0xFF2C6B43))
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(18.dp)
                    .background(Color(0xFF52B788))
                    .fillMaxSize()
            ) {
                item {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(Color(0xFF52B788), Color(0xFFB7E4C7))
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painter = painterResource(R.drawable.ananymous),
                                            contentDescription = "profile",
                                            modifier = Modifier
                                                .size(50.dp)
                                                .clip(CircleShape)
                                        )
                                        Text(
                                            "مهدیار برزگر",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF1E5A43),
                                            modifier = Modifier.padding(6.dp, top = 16.dp)
                                        )
                                    }

                                    Text(
                                        "09133890740",
                                        fontSize = 16.sp,
                                        color = Color(0xFF1E5A43),
                                        modifier = Modifier.padding(6.dp, top = 16.dp)
                                    )
                                }
                            }
                        }

                        val items = listOf(
                            R.drawable.circle_user_round to "پروفایل کاربری",
                            R.drawable.list_todo to "سفارشات من",
                            R.drawable.headset to "پشتیبانی",
                            R.drawable.scale to "قوانین و مقررات",
                            R.drawable.users to "درباره ما",
                            R.drawable.phone to "ارتباط با ما"
                        )

                        items.forEach { (icon, label) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp, top = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(icon),
                                    contentDescription = "",
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                                Text(
                                    label,
                                    color = Color(0xFF2A7D55),
                                    fontWeight = FontWeight(600)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    Column {


        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun TopAppBarView(onMenuClick: () -> Unit, isExpanded: Boolean) {
            val context = LocalContext.current

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(57.dp)
                    .background(Color.White)
                    .padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.logo_not_script),
                        contentDescription = null,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "GreenRose",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF034206),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.about),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(end = 10.dp),
                        tint = Color(0xFF034206)
                    )
                    AnimatedContent(targetState = isExpanded, transitionSpec = {
                        fadeIn(animationSpec = tween(400)) with fadeOut(animationSpec = tween(400))
                    }) { expanded ->
                        Icon(
                            imageVector = if (expanded) Icons.Default.Close else Icons.Default.Menu,
                            contentDescription = "",
                            tint = Color(0xFF034206),
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) { onMenuClick() }
                        )
                    }

                }
            }
        }

        @Composable
        fun DropDownPanel(isExpanded: Boolean) {
            val density = LocalDensity.current
            val offsetY = with(density) { 70.dp.roundToPx() }

            AnimatedVisibility(
                visible = isExpanded,
                enter = slideInVertically(
                    initialOffsetY = { -offsetY },
                    animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(500)),
                exit = slideOutVertically(
                    targetOffsetY = { -offsetY },
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(400)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp),
                    color = Color(0xFFE0F7FA),
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
                    shadowElevation = 4.dp
                ) {
                    InfoTab()
                }
            }
        }


        @Composable
        fun TopNavBar() {
            var isExpanded by remember { mutableStateOf(false) }

            TopAppBarView(onMenuClick = {
                isExpanded = !isExpanded
            }, isExpanded)

            DropDownPanel(isExpanded = isExpanded)
        }
        TopNavBar()
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Top_Nav_BarTheme {

    }
}