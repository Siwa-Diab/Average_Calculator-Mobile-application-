package com.example.examapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

class fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment2, container, false)

        val message1 = fragment2Args.fromBundle(requireArguments()).firstname
        val message2 = fragment2Args.fromBundle(requireArguments()).familyname
        val average = fragment2Args.fromBundle(requireArguments()).average

        val textviewfirstname = view.findViewById<TextView>(R.id.edit_fname)
        val textviewfamilyname = view.findViewById<TextView>(R.id.edit_faname)
        val textviewaverage = view.findViewById<TextView>(R.id.edit_average)

        textviewfirstname.text = message1
        textviewfamilyname.text = message2
        textviewaverage.text = average

        val comment=view.findViewById<TextView>(R.id.comment)

        val averageValue = average.toFloatOrNull()

        // Check if averageValue is not null and greater than or equal to 50
        if (averageValue != null && averageValue >= 50) {
            if (averageValue >= 80){
            comment.text = "Spectacular , youre average is amazing !!!"
            }else{
            comment.text = "Congratulations, you have succeeded :)"
            }
        } else {
            comment.text = "Sorry, you have failed  :("
        }


        return view
     }
}
