package com.learn.eatelicious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.eatelicious.ui.theme.EateliciousTheme

data class Restaurant(val name: String, val tagLine: String)

val restaurants = listOf(
    Restaurant("Belgian Waffles", "The best in town!"),
    Restaurant("Stomachful", "Never leave hungry"),
    Restaurant("Big Belly Noodles", "Delicious noodles"),
    Restaurant("Cakery", "Cakes for every occasion"),
    Restaurant("Pan Asia", "The best Asian food"),
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
        color = Color.LightGray
    ) {
        Column {
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

@Composable
fun RestaurantList(restaurants: List<Restaurant>) {
    Column {
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
                "For the sweet-tooth's!"
            )
        )
    }
}