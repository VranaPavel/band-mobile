package com.crowthedev.band

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.crowthedev.band.data.Name
import com.crowthedev.band.data.NameViewModel
import com.crowthedev.band.ui.theme.BandTheme
import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BandTheme {
                Surface(
                    modifier = Modifier,
                    color = Color.hsl(1f, 0f, 0.13f),
                ) {
                    Text(
                        text = "BAND",
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        fontSize = 50.sp,
                        fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                        modifier = Modifier
                            .padding(start = 125.dp, top = 20.dp, end = 125.dp, bottom = 30.dp)
                            .fillMaxSize(),
                        color = Color.White
                    )

                    val current = LocalDate.now()
                    Text(
                        text = "Today is ${current.dayOfMonth}.${current.monthValue}.${current.year}",
                        modifier = Modifier.padding(start = 30.dp, top = 200.dp),
                        color = Color.White
                    )

                    var reader = BufferedReader(InputStreamReader(assets.open("birthdays.csv")))
                    var name = ""
                    val names: MutableList<String> = mutableListOf()
                    getNames(reader, names, true)

                    if (names.size == 1) {
                        name = names[0]
                        Text(
                            text = "Today has birthday: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 250.dp),
                            color = Color.White
                        )
                    }
                    else if (names.size > 1)
                    {
                        name = names[0]
                        var i = 1
                        while (i < names.size)
                        {
                            name = name + ", " + names[i]
                            i++
                        }
                        Text(
                            text = "Today has birthday: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 250.dp),
                            color = Color.White
                        )
                    }
                    else
                    {
                        name = ""
                        Text(
                            text = "Today is noone who you know's birthday",
                            modifier = Modifier.padding(start = 30.dp, top = 250.dp),
                            color = Color.White
                        )
                    }

                    val mNameViewModel: NameViewModel = ViewModelProvider(this)[NameViewModel::class.java]
                    var input = Name(0, name)
                    mNameViewModel.addName(input)
                    reader.close()
                    reader = BufferedReader(InputStreamReader(assets.open("birthdays.csv")))
                    names.clear()
                    getNames(reader, names, false)

                    if (names.size == 1) {
                        name = names[0]
                        Text(
                            text = "Tomorrow has birthday: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 300.dp),
                            color = Color.White
                        )
                    }
                    else if (names.size > 1)
                    {
                        name = names[0]
                        var i = 1
                        while (i < names.size)
                        {
                            name = name + ", " + names[i]
                            i++
                        }
                        Text(
                            text = "Tomorrow has birthday: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 300.dp),
                            color = Color.White
                        )
                    }
                    else
                    {
                        name = ""
                        Text(
                            text = "Tomorrow is noone who you know's birthday",
                            modifier = Modifier.padding(start = 30.dp, top = 300.dp),
                            color = Color.White
                        )
                    }

                    input = Name(1, name)
                    mNameViewModel.addName(input)
                    reader.close()
                    reader = BufferedReader(InputStreamReader(assets.open("namedays.csv")))
                    names.clear()
                    getNames(reader, names, true)

                    if (names.size == 1) {
                        name = names[0]
                        Text(
                            text = "Today has name day: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 400.dp),
                            color = Color.White
                        )
                    }
                    else if (names.size > 1)
                    {
                        name = names[0]
                        var i = 1
                        while (i < names.size)
                        {
                            name = name + ", " + names[i]
                            i++
                        }
                        Text(
                            text = "Today has name day: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 400.dp),
                            color = Color.White
                        )
                    }
                    else
                    {
                        name = ""
                        Text(
                            text = "Today is noone who you know's name day",
                            modifier = Modifier.padding(start = 30.dp, top = 400.dp),
                            color = Color.White
                        )
                    }

                    input = Name(2, name)
                    mNameViewModel.addName(input)
                    reader.close()
                    reader = BufferedReader(InputStreamReader(assets.open("namedays.csv")))
                    names.clear()
                    getNames(reader, names, false)

                    if (names.size == 1) {
                        name = names[0]
                        Text(
                            text = "Tomorrow has name day: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 450.dp),
                            color = Color.White
                        )
                    }
                    else if (names.size > 1)
                    {
                        name = names[0]
                        var i = 1
                        while (i < names.size)
                        {
                            name = name + ", " + names[i]
                            i++
                        }
                        Text(
                            text = "Tomorrow has name day: $name",
                            modifier = Modifier.padding(start = 30.dp, top = 450.dp),
                            color = Color.White
                        )
                    }
                    else
                    {
                        name = ""
                        Text(
                            text = "Tomorrow is noone who you know's name day",
                            modifier = Modifier.padding(start = 30.dp, top = 450.dp),
                            color = Color.White
                        )
                    }

                    input = Name(3, name)
                    mNameViewModel.addName(input)
                    reader.close()
                }
            }
        }
    }
}






// design functions

    //TODO: Greeting function
    /* @Composable
    fun Greeting(surname: String, gender: String, modifier: Modifier = Modifier) {
        BandTheme {
            // Welcome screen
            if (gender == "man") {
            Text(
                text = "Welcome back sir $surname!",
                modifier = modifier.padding(30.dp),
                color = Color.White
            )
        } else if (gender == "woman") {
            Text(
                text = "Welcome back lady $surname!",
                modifier = modifier.padding(30.dp),
                color = Color.White
            )
        }
        }
    } */

    @Composable
    fun Names(data: List<String>, modifier: Modifier = Modifier) {
        if (data.isEmpty()) {
            return
        } else if (data.size > 1) {
            data.forEach() { i ->
                Surface(color = Color.hsl(1f, 0f, 0.13f), modifier = modifier) {
                    Text(
                        text = i,
                        modifier = Modifier.padding(30.dp),
                    )
                }
                if (i != data.last()) {
                    Surface(color = Color.hsl(1f, 0f, 0.13f), modifier = modifier) {
                        Text(
                            text = ", ",
                            modifier = Modifier.padding(30.dp),
                        )
                    }
                }
            }
        } else {
            Surface(color = Color.hsl(1f, 0f, 0.13f), modifier = modifier) {
                Text(
                    text = data[0],
                    modifier = Modifier.padding(30.dp),
                    color = Color.hsl(1f, 0f, 0.13f)
                )
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BandTheme {
    }
}