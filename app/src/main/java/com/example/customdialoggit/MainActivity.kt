package com.example.customdialoggit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.customdialoggit.databinding.ActivityMainBinding
import com.example.dialoggit.classes.BasicDialog
import com.example.dialoggit.classes.DateAndTimeDialog

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.basicDialog.setOnClickListener {
            basicDialog()
        }

        binding.dateDialog.setOnClickListener {
            dateDialog()
        }


    }

    private fun dateDialog() {
        val dialog = DateAndTimeDialog()

        dialog.show(supportFragmentManager, "date_dialog")
        dialog.setOnOkButtonClicked(object : DateAndTimeDialog.OnButtonClicked{
            override fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker) {
                val date = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}  " +
                        "${timePicker.hour}:${timePicker.minute}"
                Toast.makeText(this@MainActivity, date, Toast.LENGTH_SHORT).show()
            }


        })
    }

    private fun basicDialog() {
        val basicDialog = BasicDialog(this)
        basicDialog.createDialog(
            "What's your name?", " override fun onCreate(savedInstanceState: Bundle?) {\n" +
                    "        super.onCreate(savedInstanceState)\n" +
                    "        binding = ActivityMainBinding.inflate(layoutInflater)\n" +
                    "        setContentView(binding.root)\n" +
                    "\n" +
                    "        binding.basicDialog.setOnClickListener {\n" +
                    "            basicDialog()\n" +
                    "        }", "Agree", "Disagree"
        )
        basicDialog.show(supportFragmentManager, "basic_dialog")
        basicDialog.setOnButtonClickListener(object : BasicDialog.BasicDialogListeners {
            override fun okButtonClicked() {
                Toast.makeText(this@MainActivity, "DISAGREE", Toast.LENGTH_SHORT).show()

            }

            override fun cancelButtonClicked() {
                Toast.makeText(this@MainActivity, "AGREE", Toast.LENGTH_SHORT).show()

            }

        })
    }
}