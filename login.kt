package com.edane.myapplication

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val edtuser = findViewById<EditText>(R.id.username)
        val edtpas = findViewById<EditText>(R.id.password)
        val btnlogin = findViewById<Button>(R.id.loginbtn)
        val regis = findViewById<TextView>(R.id.regis)

        regis.setOnClickListener{
            val daftar = Intent (this, register::class.java)
            startActivity(daftar)
        }

        btnlogin.setOnClickListener {
            val username = edtuser.text.toString()
            val passw = edtpas.text.toString()

            if (username == "Abdul" && passw=="utsmobile"){
                Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show()
                val masukapp = Intent (this, MainActivity::class.java)
                startActivity(masukapp)
            }else {
                val message : String? = "Username atau Password Salah, Ulangi Login?"
                val judul : String? = "Warning!!!"
                DialogBoxLo(message,judul)
            }
        }
    }
    private fun DialogBoxLo(message: String?,judul: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tv_message)
        val btnYes : Button = dialog.findViewById(R.id.btn_yes)
        val btnNo : Button = dialog.findViewById(R.id.btn_no)
        val tvJudul : TextView = dialog.findViewById(R.id.tv_judul)

        tvMessage.text = message
        tvJudul.text = judul

        btnYes.setOnClickListener{
            dialog.dismiss()
        }
        btnNo.setOnClickListener{
            finish()
        }
        dialog.show()
    }
}