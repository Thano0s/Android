package com.example.myapplication_2

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Intent
import android.net.Uri
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class upload_image_activity: AppCompatActivity() {

    private lateinit var selectFileButton: Button;
    private lateinit var uploadFileButton: Button;
    var fileUri: Uri? = null;

    private fun toast(message:String)
    {
        Toast.makeText(this.applicationContext,message, Toast.LENGTH_SHORT).show();
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_image_activity);
        selectFileButton = findViewById(R.id.selectFileButton);
        uploadFileButton = findViewById(R.id.uploadFileButton);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
        {
            requestStoragePermission();
        }

        selectFileButton.setOnClickListener {
            // on below line calling intent to get our image from phone storage.
            val intent = Intent()
            // on below line setting type of files which we want to pick in our case we are picking images.
            intent.type = "image/*"
            // on below line we are setting action to get content
            intent.action = Intent.ACTION_GET_CONTENT
            // on below line calling start activity for result to choose image.
            startActivityForResult(
                // on below line creating chooser to choose image.
                Intent.createChooser(
                    intent,
                    "Pick your image to upload"
                ),
                22
            )
        }
        uploadFileButton.setOnClickListener {
            // on below line calling upload image button to upload our image.
            uploadImage()
        }
    }

    private fun requestStoragePermission()
    {
        val storagePermissionCode:Int = 101
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            storagePermissionCode
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        // on below line we are checking if the result is ok
        if (requestCode == 22 && resultCode == RESULT_OK && data != null && data.data != null)
        {
            // on below line initializing file uri with the data which we get from intent
            fileUri = data.data
        }
    }

    private fun uploadImage() {
        // on below line checking weather our file uri is null or not.
        if (fileUri != null) {

            // on below line creating a storage refrence for firebase storage and creating a child in it with random uuid.
            val ref: StorageReference = FirebaseStorage.getInstance().getReference("images/").child(UUID.randomUUID().toString())

            // on below line adding a file to our storage.
            ref.putFile(fileUri!!).addOnSuccessListener {
                toast("File Upload succeeded")
            }.addOnFailureListener {
                toast("File upload Failed")
            }
        }
    }
}
