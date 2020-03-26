package com.pecpacker.africaknow_game.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.pecpacker.africaknow_game.R

/**
 * A simple [Fragment] subclass.
 */
class LogInFragment : Fragment() {
    lateinit var mDatabase: DatabaseReference
    var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser
    private lateinit var useremail: EditText
    private lateinit var userpassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        val signUp: TextView = root.findViewById(R.id.txt_signup)
        signUp.setOnClickListener {
            Navigation.findNavController(signUp)
                .navigate(R.id.action_logInFragment_to_signUpFragment)
        }

        val signin = root.findViewById<Button>(R.id.btn_signin)
        signin.setOnClickListener(View.OnClickListener { view ->
            sign()
        })

        useremail = root.findViewById(R.id.useremail)
        userpassword = root.findViewById(R.id.userpassword)



        return root
    }

    private fun sign() {

        var email = useremail.text.toString()
        var password = userpassword.text.toString()


        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
//                    startActivity(Intent(this, GameActivity::class.java))
                        Navigation.findNavController(useremail)
                            .navigate(R.id.action_logInFragment_to_gameFragment2)
                        Toast.makeText(
                            requireContext(),
                            "Successfully Logged in :)",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(requireContext(), "Error Logging in :(", Toast.LENGTH_SHORT)
                            .show()
                    }
                })

        } else {
            Toast.makeText(
                requireContext(),
                "Please fill up the Credentials :|",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}
