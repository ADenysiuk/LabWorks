package com.ki232.AndriyDenysiuk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        findViewById<Button>(R.id.button).setOnClickListener {
            val text = findViewById<EditText>(R.id.edittext).text.toString()
            val textView = findViewById<TextView>(R.id.textview)
            if (text.isEmpty())
                textView.setText("Введіть текст!")
            else
                textView.setText(text)
            findViewById<ImageView>(R.id.imageview).setImageDrawable(resources.getDrawable(R.drawable.image))
        }
        printMe()
        var a = 3
        var b = 0.33
        var c = "Hello!"
        var d = true
        println("a = " + a + ", b = " + b + ", " + c + ", d is " + d)
        println("Statement that a is even is " + isOdd(a));
        println("If a was a number of a week it would be " + dayOfWeek(a));
        val users = ArrayList<User>()
        users.add(User(3, "Oleksandr", "Blyskavychniy"))
        users.add(User(1, "Andriy", "Denysiuk"))
        users.add(User(2, "Oleg", "Hrigoryv"))
        users.add(User(5, "Vasyliy", "Tremenko"))
        users.add(User(4, "Petro", "Moleskiy"))
        users.sortBy { it.name };
        for (i in 0..4){
            val user = users.get(i);
            println("User " + user.id + " full name is " + user.name + " " + user.surname)
        }
    }
    fun dayOfWeek(a: Int): String {
        when (a) {
            1 -> return "Monday"
            2 -> return "Tuesday"
            3 -> return "Wednesday"
            4 -> return "Thursday"
            5 -> return "Friday"
            6 -> return "Saturday"
            7 -> return "Sunday"
            else -> return dayOfWeek(a - 7)
        };
    }
    fun isOdd(a: Int): Boolean {
        return (a % 2 == 0);
    }
    fun printMe(){
        println("Hello, Andriy Denysiuk from KI-23-2!")
    }
}