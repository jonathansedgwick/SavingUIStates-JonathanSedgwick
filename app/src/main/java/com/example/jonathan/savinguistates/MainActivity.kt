package com.example.jonathan.savinguistates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var numDisplay: TextView
    lateinit var checkBox: CheckBox
    lateinit var dataSwitch: Switch

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numDisplay = findViewById(R.id.hello_text)
        checkBox = findViewById(R.id.check_box)
        dataSwitch = findViewById(R.id.data_switch)


        numDisplay.text = number.toString()

        button.setOnClickListener {
            number++
            numDisplay.text = number.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("saved_number", numDisplay.text.toString())
        outState.putInt("current_value", number)
        outState.putBoolean("check_data", checkBox.isChecked)
        outState.putBoolean("switch_data", dataSwitch.isChecked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        numDisplay.text = savedInstanceState.getString("saved_number")
        number = savedInstanceState.getInt("current_value")
        checkBox.isChecked = savedInstanceState.getBoolean("check_data")
        dataSwitch.isChecked = savedInstanceState.getBoolean("switch_data")


    }

}