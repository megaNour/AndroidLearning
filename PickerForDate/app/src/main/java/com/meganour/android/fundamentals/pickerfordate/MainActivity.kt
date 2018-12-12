package com.meganour.android.fundamentals.pickerfordate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePicker(view: View) {
        val datePickerFragment = DatePickerFragment()
        datePickerFragment.show(supportFragmentManager, "datePicker")
    }

    fun showTimePicker(view: View) {
        val timePickerFragment = TimePickerFragment()
        timePickerFragment.show(supportFragmentManager, "timePicker")
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
//        val month_string = Integer.toString(month + 1)
//        val day_string = Integer.toString(day)
//        val year_string = Integer.toString(year)
//        val dateMessage = month_string +
//                "/" + day_string + "/" + year_string
        val dayString = Integer.toString(day)
        val monthString = Integer.toString(month)
        val yearString = Integer.toString(year)
        val dateString = "$day/$month/$year"
        Toast.makeText(this, dateString, Toast.LENGTH_SHORT)
            .show()
    }

    fun processTimePickerResult(hour: Int, minute: Int) {
        val hourString = Integer.toString(hour)
        val minuteString = Integer.toString(minute)
        val timeString = "$hourString:$minuteString"
        Toast.makeText(this, timeString, Toast.LENGTH_SHORT)
            .show()
    }
}
