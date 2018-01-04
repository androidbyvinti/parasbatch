package com.android.firebase

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.IOException

private var welcomeTextView: TextView? = null
private var firebaseDatabase: FirebaseDatabase? = null
private var databaseReference: DatabaseReference? = null
private var firebaseUser: FirebaseUser? = null
private var firebaseAuth: FirebaseAuth? = null
private var uploadButton: Button? = null
private var downdloadButton:Button? = null
private var pathOfStorage: File? = null
private var mStorageRef: StorageReference? = null
private var nameOfFile: String? = null


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mStorageRef = FirebaseStorage.getInstance().getReference()
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseUser = firebaseAuth.getCurrentUser()

        pathOfStorage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)

        Log.d("WelcomeActivity", "Path of Storage=" + pathOfStorage)
        uploadButton = findViewById<View>(R.id.uploadButton) as Button

        downdloadButton = findViewById<View>(R.id.downloadButton) as Button

        val userId = firebaseUser.getUid()
        Log.d("WelcomeActivity", "Id = " + userId)
        welcomeTextView = findViewById<View>(R.id.welcomeTextView) as TextView


        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference("userdetails")

        databaseReference.child(userId).addValueEventListener(object : ValueEventListener() {
            fun onDataChange(dataSnapshot: DataSnapshot) {

                progressDialog.dismiss()
                //enhanced for loop
                welcomeTextView.setText("Welcome " + dataSnapshot.child("Name").getValue())
                Log.d("WelcomeActivity", "Name = " + dataSnapshot.child("Name").getValue())
            }

            fun onCancelled(databaseError: DatabaseError) {
                progressDialog.dismiss()
                Log.d("WelcomeActivity", "Error Occurred" + databaseError.getMessage())
            }
        })

        downdloadButton.setOnClickListener(View.OnClickListener {
            var localFile: File? = null
            try {
                localFile = File.createTempFile(nameOfFile, ".pdf", pathOfStorage)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            mStorageRef.child(nameOfFile).getFile(localFile)
                    .addOnSuccessListener(object : OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        fun onSuccess(taskSnapshot: FileDownloadTask.TaskSnapshot) {

                            Toast.makeText(this@WelcomeActivity, "Downloaded = " + taskSnapshot.getStorage().getName(), Toast.LENGTH_LONG).show()
                        }
                    }).addOnFailureListener(object : OnFailureListener() {
                fun onFailure(exception: Exception) {
                    Toast.makeText(this@WelcomeActivity, "Error " + exception.message, Toast.LENGTH_LONG).show()
                }
            })
        })

        uploadButton.setOnClickListener(View.OnClickListener {
            try {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)//available from API:19
                intent.type = "application/txt"
                startActivityForResult(intent, 1001)
            } catch (e: Exception) {
                Log.d("WelcomeActivity", "upload error = " + e.message)
                Toast.makeText(this@WelcomeActivity, e.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {

            val uri = data.data
            nameOfFile = uri!!.path
            val path = nameOfFile.lastIndexOf("/")
            nameOfFile = nameOfFile.substring(path + 1)

            Log.d("WelcomeActivity", "name = " + nameOfFile + "uri data= " + uri)

            val riversRef = mStorageRef.child(nameOfFile)

            riversRef.putFile(uri)
                    .addOnSuccessListener(object : OnSuccessListener<UploadTask.TaskSnapshot>() {
                        fun onSuccess(taskSnapshot: UploadTask.TaskSnapshot) {

                            Toast.makeText(this@WelcomeActivity, "Uploaded", Toast.LENGTH_LONG).show()
                        }
                    })
                    .addOnFailureListener(object : OnFailureListener() {
                        fun onFailure(exception: Exception) {
                            Toast.makeText(this@WelcomeActivity, "Error Occurred" + exception.message, Toast.LENGTH_LONG).show()
                            Log.d("WelcomeActivity", exception.message)

                        }
                    })
        }
    }
}

