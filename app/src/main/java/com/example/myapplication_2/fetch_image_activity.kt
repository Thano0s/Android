package com.example.myapplication_2

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.File
import com.bumptech.glide.Glide
import java.util.UUID

class fetch_image_activity: AppCompatActivity() {
    private lateinit var frame: ImageView;
    private lateinit var setButton: Button;
    private fun toast(message:String)
    {
        Toast.makeText(this.applicationContext,message, Toast.LENGTH_SHORT).show();
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch_image_activity);
        frame = findViewById(R.id.imageFrame);
        setButton = findViewById(R.id.setImage);
        setButton.setOnClickListener{
            val storage = Firebase.storage
            val storageRef = storage.reference
            val islandRef = storageRef.child("images/03f49d59-050c-489c-9180-19362a88fc4d")


            val localFile:File = File.createTempFile("image","jpeg");
            val task: FileDownloadTask = islandRef.getFile(localFile);
            task.addOnSuccessListener {
//                val bitmap: Bitmap? =
//                frame.setImageResource();
                Glide.with(this)
                    .load(localFile)
                    .into(frame)
                toast("download successfully")
            }.addOnFailureListener {
                // Handle any errors
                toast("download fail")
                }
            }
        }
}