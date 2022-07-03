package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {
    private  var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)

        val name = this::class.simpleName!!
        with(binding){
            settingsButton.setOnClickListener{
                findNavController().navigate(R.id.action_newsFragment_to_settingsFragment, SettingsFragment.createBundle(name))
            }
        }
    }
}