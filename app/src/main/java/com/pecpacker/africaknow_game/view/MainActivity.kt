package com.pecpacker.africaknow_game.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.pecpacker.africaknow_game.R
import com.pecpacker.africaknow_game.ViewModel.GameViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameViewModel = ViewModelProviders.of(this)[GameViewModel::class.java]

        gameViewModel.getQuestions().observe(this, Observer {

            Log.e("GAME MODEL", " ${it.questions}")
        })

    }
}
