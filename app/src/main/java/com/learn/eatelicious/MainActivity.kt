package com.learn.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.eatelicious.ui.theme.EateliciousTheme
import com.learn.eatelicious.ui.theme.Purple40

data class Restaurant(val name: String, val tagLine: String, val imageId: Int)

val restaurants = listOf(
    Restaurant("Belgian Waffles", "The best in town!", R.drawable.restaurant_01),
    Restaurant("Stomachful", "Never leave hungry", R.drawable.restaurant_02),
    Restaurant("Big Belly Noodles", "Delicious noodles", R.drawable.restaurant_03),
    Restaurant("Cakery", "Cakes for every occasion", R.drawable.restaurant_04),
    Restaurant("Pan Asia", "The best Asian food", R.drawable.restaurant_05),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EateliciousTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantList(restaurants = restaurants)
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 3.dp,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = restaurant.imageId),
                contentDescription = "Restaurant Image",
                modifier = Modifier.size(120.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Purple40,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = restaurant.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 2.dp)
                )
                Text(
                    text = restaurant.tagLine,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 2.dp, bottom = 32.dp)
                )
            }
        }
    }
}

@Composable
fun RestaurantList(restaurants: List<Restaurant>) {
    Column(verticalArrangement = Arrangement.Top) {
        for (restaurant in restaurants) {
            RestaurantCard(restaurant = restaurant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurantCard() {
    EateliciousTheme {
        RestaurantCard(
            Restaurant(
                "Belgian Waffles",
                "For the sweet-tooth's!",
                R.drawable.restaurant_01
            )
        )
    }
}