package com.example.socialsparkapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    lateinit var txtTime: EditText
    lateinit var tvTime: TextView
    lateinit var tvResult : TextView
    lateinit var btnSubmit : Button
    lateinit var btnClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtTime = findViewById(R.id.txtTime)
        tvTime = findViewById(R.id.tvTime)
        tvResult = findViewById(R.id.tvResult)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnClear = findViewById(R.id.btnClear)


        btnSubmit.setOnClickListener {
            //making sure the text works even if there are spaces or big letters
            val input = txtTime.text.toString().trim().lowercase()

            //  The main logic
            if (input == "morning") {
                tvResult.text = "Send a 'Good morning' text to family member !"
            } else if (input == "mid-morning") {
                tvResult.text = "Reach out to a colleague with quick ' Thank you ."

            } else if (input == "afternoon") {
                tvResult.text = "Share a funny meme or interesting link with a friend. "

            } else if (input == "afternoon snack time") {
                tvResult.text = "Send a quick 'thinking of you message."

            } else if (input == "dinner") {
                tvResult.text = "call a friend or relative for 5-minute catch-up."

            } else if (input == "night" ||
                input == "after dinner") {
                tvResult.text = "leave a thoughtful comment on a friend's post ."

            } else {
                //  Error Handling
                tvResult.text = "Cora  doesn't recognize ' $input'.Try 'Morning' or 'Dinner'!"
            }
            Log.d("CoraApp", "Cora searched for:$input")

        }

        btnClear.setOnClickListener {
            txtTime.text.clear()
            tvResult.text=""
//        }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets}
            }
        }
    }