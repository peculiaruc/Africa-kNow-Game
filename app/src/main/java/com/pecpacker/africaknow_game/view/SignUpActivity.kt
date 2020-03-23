package com.pecpacker.africaknow_game.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pecpacker.africaknow_game.R

class SignUpActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_reg = findViewById<View>(R.id.btn_reg) as Button

        mDatabase = FirebaseDatabase.getInstance().getReference("Name")
        btn_reg.setOnClickListener(View.OnClickListener {
            v: View? -> registerUser()
        })

    }
    private fun registerUser(){
        val useremail = findViewById<View>(R.id.useremail) as EditText
        val userpassword = findViewById<View>(R.id.userpassword) as EditText
        val username = findViewById<View>(R.id.txt_name) as EditText

        var email = useremail.text.toString()
        var passsword = userpassword.text.toString()
        var name = username.text.toString()

        if (!email.isEmpty() && !passsword.isEmpty() && !name.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email, passsword).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful){
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Name").setValue(name)
                    startActivity(Intent(this, LoginActivity::class.java))
                    Toast.makeText(this, "Successfully registered:)", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                }
            })

        }else{
            Toast.makeText(this, "Please fill up the Credential:|", Toast.LENGTH_LONG).show()
        }
    }
}
