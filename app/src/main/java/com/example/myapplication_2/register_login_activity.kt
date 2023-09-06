package com.example.myapplication_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class register_login_activity : AppCompatActivity()
{
    private lateinit var loginButton:Button;
    private lateinit var registerButton:Button;
    private lateinit var auth: FirebaseAuth;
    private lateinit var emailEditText: EditText;
    private lateinit var passwordEditText: EditText;
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val myIntent: Intent = Intent(this,fetch_image_activity::class.java)
        startActivity(myIntent);
//        setContentView(R.layout.register_login_activity);
//
//        loginButton = findViewById(R.id.logInButton);
//        emailEditText = findViewById(R.id.emailEditText);
//        passwordEditText = findViewById(R.id.passwordEditText);
//        registerButton = findViewById(R.id.registerButton);
//        auth = FirebaseAuth.getInstance();
//
//        loginButton.setOnClickListener {
////            Toast.makeText(this.applicationContext,"Ok",Toast.LENGTH_SHORT).show();
//            auth.signInWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful)
//                    {
//                        Toast.makeText(this.applicationContext,"Login successfully",Toast.LENGTH_SHORT).show();
//                        val myIntent:Intent = Intent(this,get_user_info_activity::class.java)
//                        startActivity(myIntent)
//                    }
//                    else
//                    {
//                        Toast.makeText(this.applicationContext,"Invalid credential",Toast.LENGTH_SHORT).show();
//                    }
//                }
//        }
//
//        registerButton.setOnClickListener {
//            auth.createUserWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful)
//                    {
//                        Toast.makeText(this.applicationContext, "Registration successful", Toast.LENGTH_SHORT).show();
//                        setContentView(R.layout.get_user_info_activity);val myIntent:Intent = Intent(this,get_user_info_activity::class.java)
//                        startActivity(myIntent)
//                    }
//                    else
//                    {
//                        if (task.exception is FirebaseAuthUserCollisionException)
//                        {
//                            Toast.makeText(this.applicationContext, "Email is already in use", Toast.LENGTH_SHORT).show()
//                        }
//                        else
//                        {
//                            Toast.makeText(this.applicationContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//        }
    }
}