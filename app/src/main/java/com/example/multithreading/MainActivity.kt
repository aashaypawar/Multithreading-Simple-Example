package com.example.multithreading

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1 = findViewById<TextView>(R.id.tv1)
        val tv2 = findViewById<TextView>(R.id.tv2)
        val tv3 = findViewById<TextView>(R.id.tv3)
        val btn = findViewById<Button>(R.id.btnStart)

        var boolbtn = false

        btn.setOnClickListener {
            boolbtn = !boolbtn

            if(!boolbtn){
                tv1.text = "Stopped1"
                tv2.text = "Stopped2"
                tv3.text = "Stopped3"
                btn.text = "Start"
            }

            else{
                btn.text = "Stop"

                Thread(Runnable {
                    while(boolbtn){
                        runOnUiThread{
                            tv1.text = "Started1"
                        }
                        Thread.sleep(1000)
                        runOnUiThread{
                            tv1.text = "Activity1"
                        }
                        Thread.sleep(1000)
                    }
                }).start()

                Thread(Runnable {
                    while(boolbtn){
                        runOnUiThread{
                            tv2.text = "Started2"
                        }
                        Thread.sleep(1000)
                        runOnUiThread{
                            tv2.text = "Activity2"
                        }
                        Thread.sleep(1000)
                    }
                }).start()

                Thread(Runnable {
                    while(boolbtn){
                        runOnUiThread{
                            tv3.text = "Started3"
                        }
                        Thread.sleep(1000)
                        runOnUiThread{
                            tv3.text = "Activity3"
                        }
                        Thread.sleep(1000)
                    }
                }).start()
            }

        }
    }
}