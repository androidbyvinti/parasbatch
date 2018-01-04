package com.android.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.support.annotation.NonNull
import android.R.attr.password
import android.support.v4.app.FragmentActivity
import android.util.Log
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.R.attr.password


class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    var email : String? = null
    var password : String? = null

    lateinit var firebaseDatabase : FirebaseDatabase
    lateinit var databaseReference : DatabaseReference

    lateinit var userId : String
    lateinit var firebaseUser : FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("userdetails")

        firebaseUser = mAuth.currentUser
        userId = firebaseUser.uid

        registerUserButton.setOnClickListener {

            email = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            var name = nameEditText.text.toString()

            // email must have @ symbol and .com, .org. .in, etc
            //password must have length 6 characters long

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, object : OnCompleteListener<AuthResult>() {
                        fun onComplete(task: Task<AuthResult>) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(FragmentActivity.TAG, "createUserWithEmail:success")

                                // data update
                                //create and save
                                //child(String)


                                val user = mAuth.getCurrentUser()// uuid, email, image, etc
                                var id : String = user.getUid()

                                databaseReference.child(id).child("name").setValue(name)
                                databaseReference.child(id).child("email").setValue(email)
                                databaseReference.child(id).child("password").setValue(password)
                                //databaseReference.child("phn").setValue()

                                Toast.makeText(this@MainActivity, "Registered Successfully",
                                        Toast.LENGTH_LONG).show()

                                databaseReference.child(userId).child("name").addValueEventListener(object : ValueEventListener() {
                                    fun onDataChange(dataSnapshot: DataSnapshot) {
                                        // This method is called once with the initial value and again
                                        // whenever data at this location is updated.
                                        val value = dataSnapshot.getValue(String::class.java)
                                        Log.d("MainActivity", "Value is: " + value)
                                    }

                                    fun onCancelled(error: DatabaseError) {
                                        // Failed to read value
                                        Log.w(FragmentActivity.TAG, "Failed to read value.", error.toException())
                                    }
                                })


                                // updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(FragmentActivity.TAG, "createUserWithEmail:failure", task.getException())
                                Toast.makeText(this@MainActivity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                //updateUI(null)
                            }

                        }
                    })

        }

        loginUserButton.setOnClickListener {

            email = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, object : OnCompleteListener<AuthResult>() {
                        fun onComplete(task: Task<AuthResult>) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(FragmentActivity.TAG, "signInWithEmail:success")

                                Toast.makeText(this@MainActivity,
                                        "Authentication Successful",Toast.LENGTH_LONG).show()

                                //val user = mAuth.getCurrentUser()
                                //updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("MainActivity", "signInWithEmail:failure", task.getException())
                                Toast.makeText(this@MainActivity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                //updateUI(null)
                            }

                        }
                    })
        }
    }
}