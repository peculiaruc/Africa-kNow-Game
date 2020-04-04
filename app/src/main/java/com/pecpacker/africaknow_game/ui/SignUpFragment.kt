package com.pecpacker.africaknow_game.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pecpacker.africaknow_game.R

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase: DatabaseReference
    lateinit var useremail: TextInputLayout
    lateinit var userpassword: TextInputLayout
    lateinit var username: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val loginText = root.findViewById<TextView>(R.id.txt_sign)
        loginText.setOnClickListener {
            Navigation.findNavController(loginText)
                .navigate(R.id.action_signUpFragment_to_logInFragment)
        }


        val register = root.findViewById<Button>(R.id.btn_reg)

        mDatabase = FirebaseDatabase.getInstance().getReference("Name")
        register.setOnClickListener(View.OnClickListener { v: View? ->
            registerUser()
        })
        useremail = root.findViewById(R.id.useremail)
        userpassword = root.findViewById(R.id.userpassword)
        username = root.findViewById(R.id.txt_name)


        return root
    }

    private fun registerUser() {


        var email = useremail.editText?.text.toString()
        var passsword = userpassword.editText?.text.toString()
        var name = username.editText?.text.toString()

        if (!email.isEmpty() && !passsword.isEmpty() && !name.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, passsword)
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        val uid = user!!.uid
                        mDatabase.child(uid).child("Name").setValue(name)
                        Navigation.findNavController(useremail)
                            .navigate(R.id.action_signUpFragment_to_logInFragment)
//                    startActivity(Intent(this, LoginActivity::class.java))
                        Toast.makeText(
                            requireContext(),
                            "Successfully registered:)",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Error registering, try again later :(",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })

        } else {
            Toast.makeText(requireContext(), "Please fill up the Credential:|", Toast.LENGTH_LONG)
                .show()
        }
    }
}


