package com.pecpacker.africaknow_game.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.pecpacker.africaknow_game.R

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_game, container, false)

        val playButton = root.findViewById<MaterialButton>(R.id.btn_play)
        playButton.setOnClickListener {
            Navigation.findNavController(playButton)
                .navigate(R.id.action_gameFragment2_to_playGameFragment)
        }
        return root
    }

}
