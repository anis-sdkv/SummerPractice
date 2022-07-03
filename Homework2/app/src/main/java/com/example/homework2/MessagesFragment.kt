package com.example.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment(R.layout.fragment_messages) {
    private  var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMessagesBinding.bind(view)

        val name = this::class.simpleName!!
        with(binding){
            settingsButton.setOnClickListener{
                findNavController().navigate(R.id.action_messagesFragment_to_settingsFragment, SettingsFragment.createBundle(name))
            }
        }
    }
}