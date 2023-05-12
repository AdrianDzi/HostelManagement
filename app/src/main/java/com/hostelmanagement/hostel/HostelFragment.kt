package com.hostelmanagement.hostel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import com.hostelmanagement.R



class HostelFragment : Fragment() {
    private lateinit var numberPicker: NumberPicker

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hostel, container, false)

        numberPicker = view.findViewById(R.id.np_pickNumber)
        numberPicker.minValue = 0
        numberPicker.maxValue = 100
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            updateTextView(newVal)
        }
        return view
    }
    private fun updateTextView(value: Int) {
        val textView = view?.findViewById<TextView>(R.id.tv_number)
        textView?.text = "Number of Hostels:  $value"
    }
}