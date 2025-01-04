package com.example.matthewchang_technicaltest_androidintern

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameField = findViewById<EditText>(R.id.etUsername)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val forgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val togglePassword = findViewById<ImageView>(R.id.ivTogglePassword)

        // Toggle password visibility
        togglePassword.setOnClickListener {
            if (isPasswordVisible) {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_eye_off)
                isPasswordVisible = false
            } else {
                passwordField.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_eye)
                isPasswordVisible = true
            }
            passwordField.setSelection(passwordField.text.length)
        }

        // Login button logic
        loginButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (username == "alfagift-admin" && password == "asdf") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login gagal. Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Forgot password action
        forgotPassword.setOnClickListener {
            Toast.makeText(this, "Fitur Lupa Password belum tersedia", Toast.LENGTH_SHORT).show()
        }
    }
}
