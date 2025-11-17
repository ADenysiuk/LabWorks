package com.ki232.AndriyDenysiuk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val users = ArrayList<User>()
    val userAdapter = Users()
    val switch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val text = it.data?.getStringExtra("second_name")?.split(" ")
            if (text != null) {
                users.add(User(users.size + 1, text?.get(0) ?: "", if (text.size > 1) text.get(1) else ""))
                userAdapter.setUsers(users)
            }
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        }
    }
    private val users1: ArrayList<User>
        get() {
            val users = ArrayList<User>()
            return users
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        users.add(User(3, "Oleksandr", "Blyskavychniy"))
        users.add(User(1, "Andriy", "Denysiuk"))
        users.add(User(2, "Oleg", "Hrigoryv"))
        users.add(User(5, "Vasyliy", "Tremenko"))
        users.add(User(4, "Petro", "Moleskiy"))
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView = findViewById<TextView>(R.id.textview);
        val button = findViewById<Button>(R.id.buttonAdd);
        val intent = Intent(this, SecondActivity::class.java)
        button.setOnClickListener {
            switch.launch(intent)
        }

        /*Toast.makeText(this, "MainActivity: onCreate()", Toast.LENGTH_SHORT).show()

        printMe()
        var a = 3
        var b = 0.33
        var c = "Hello!"
        var d = true
        println("a = " + a + ", b = " + b + ", " + c + ", d is " + d)
        println("Statement that a is even is " + isOdd(a));
        println("If a was a number of a week it would be " + dayOfWeek(a));*/

        users.sortBy { it.name };
        /*for (i in 0..4){
            val user = users.get(i);
            println("User " + user.id + " full name is " + user.name + " " + user.surname)
        }*/

        userAdapter.setUsers(users)
        val recycler = findViewById<RecyclerView>(R.id.users)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = userAdapter
    }
    /*fun dayOfWeek(a: Int): String {
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
    override fun onStart(){
        super.onStart()
        Toast.makeText(this, "MainActivity: onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "MainActivity: onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "MainActivity: onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "MainActivity: onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "MainActivity: onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "MainActivity: onRestart()", Toast.LENGTH_SHORT).show()
    }*/
}

class User(val id: Int, val name: String, val surname: String) {

}