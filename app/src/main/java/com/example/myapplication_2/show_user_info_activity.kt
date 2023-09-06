package com.example.myapplication_2

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class show_user_info_activity: AppCompatActivity()  {
    private lateinit var show: Button;
    private lateinit var nameView: LinearLayout;
    private lateinit var noView:LinearLayout;
    private lateinit var priceView: LinearLayout;
    private lateinit var db: FirebaseFirestore;
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_user_info_activity);
        db = Firebase.firestore;
        show = findViewById(R.id.showButton);
        nameView = findViewById(R.id.nameLinearLayout)
        noView = findViewById(R.id.noLinearLayout);
        priceView = findViewById(R.id.priceLinearLayout);

        show.setOnClickListener {
            db.collection("Than0s")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        var name:TextView = TextView(this);
                        name.text = document.data["name"].toString();
                        name.gravity = Gravity.CENTER;
                        nameView.addView(name);

                        var no:TextView = TextView(this);
                        no.text = document.data["no"].toString();
                        no.gravity = Gravity.CENTER;
                        noView.addView(no);

                        var price:TextView = TextView(this);
                        price.text = document.data["price"].toString();
                        price.gravity = Gravity.CENTER;
                        priceView.addView(price);
                    }
                }
                .addOnFailureListener { exception ->
                    toast(exception.toString());
                }
        }
    }
    private fun toast(message:String)
    {
        Toast.makeText(this.applicationContext,message,Toast.LENGTH_SHORT).show();
    }

}