package com.example.examapplication2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.examapplication2.databinding.FragmentFragment1Binding

class fragment1 : Fragment() {

    private var _binding: FragmentFragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragment1Binding.inflate(inflater, container, false)

        val view = binding.root
        val application = requireNotNull(this.activity).application
        val studentDao = AppDatabase.getInstance(application).studentDao
        val gradeDao = AppDatabase.getInstance(application).gradeDao
        val viewModelFactory = AppViewModelFactory(studentDao, gradeDao)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AppViewModel1::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        val saveButton = view.findViewById<Button>(R.id.savebutton)
        saveButton.setOnClickListener {
            viewModel.addStudent()

            viewModel.getAllGrades().observe(viewLifecycleOwner) { gradesList ->
                var sum = 0f
                var counter = 0

                for (grade in gradesList) {
                    // Convert each grade from String to Float and sum them up
                    sum += grade.courseGrade.toFloatOrNull() ?: 0f
                    counter++
                }

                // Calculate the average
                val average = if (counter > 0) sum / counter else 0f

                val fn = view.findViewById<EditText>(R.id.edit_FirstName)
                val fan = view.findViewById<EditText>(R.id.edit_FamilyName)

                val message1 = fn.text.toString()
                val message2 = fan.text.toString()

                val action = fragment1Directions.actionFragment1ToFragment2(
                    message1,
                    message2,
                    average.toString()
                )
                view.findNavController().navigate(action)
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
