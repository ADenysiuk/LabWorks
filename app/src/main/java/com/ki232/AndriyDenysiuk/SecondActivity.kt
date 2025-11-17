package com.ki232.AndriyDenysiuk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val edittext = findViewById<EditText>(R.id.edittext);
        val textView = findViewById<TextView>(R.id.textview);
        val button = findViewById<Button>(R.id.button);

        textView.setText(intent.getStringExtra("name"))
        button.setOnClickListener {
            val intent = Intent()
            if (!edittext.text.toString().isEmpty())
                intent.putExtra("second_name", edittext.text.toString())
            else
                textView.setText("Введіть текст!")
            setResult(Activity.RESULT_OK, intent);
            finish()
        }
        Toast.makeText(this, "SecondActivity: onCreate()", Toast.LENGTH_SHORT).show()
    }
    override fun onStart(){
        super.onStart()
        Toast.makeText(this, "SecondActivity: onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "SecondActivity: onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "SecondActivity: onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "SecondActivity: onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "SecondActivity: onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "SecondActivity: onRestart()", Toast.LENGTH_SHORT).show()
    }


}