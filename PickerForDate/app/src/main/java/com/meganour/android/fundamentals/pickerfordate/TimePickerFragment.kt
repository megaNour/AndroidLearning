package com.meganour.android.fundamentals.pickerfordate

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.text.format.Time
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TimePickerFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        (activity as MainActivity).processTimePickerResult(hour, minute)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val hour = Calendar.HOUR_OF_DAY
        val min = Calendar.MINUTE
        val is24 = true
        val listener = this
        return TimePickerDialog(activity, listener, hour, min, is24)
    }
}
