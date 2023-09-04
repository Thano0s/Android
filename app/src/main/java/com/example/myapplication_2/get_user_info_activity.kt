package com.example.myapplication_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class get_user_info_activity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore;
    private lateinit var Name: EditText;
    private lateinit var Number:EditText;
    private lateinit var Price:EditText;
    private lateinit var Save:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_user_info_activity);
//        Toast.makeText(this.applicationContext, "register_login", Toast.LENGTH_SHORT).show();

        db = Firebase.firestore;
        Save = findViewById(R.id.saveButton);
        Name = findViewById(R.id.name_box);
        Number = findViewById(R.id.number_box);
        Price = findViewById(R.id.price_box);

        Save.setOnClickListener {
            // Create a new user with a first and last name
            val user = hashMapOf(
                "name" to Name.text.toString(),
                "no" to Number.text.toString().toLong(),
                "price" to Integer.parseInt(Price.text.toString()),
            )

            // Add a new document with a generated ID
//            Toast.makeText(this.applicationContext, "Ok", Toast.LENGTH_SHORT).show();
            db.collection("Than0s")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this.applicationContext, "successfully", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this.applicationContext, "Fail", Toast.LENGTH_SHORT).show();
                }
        }
    }
}