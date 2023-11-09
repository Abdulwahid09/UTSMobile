package com.edane.myapplication


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class register : AppCompatActivity() {
    var alertDialog: AlertDialog? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)


        var firstnametext = findViewById(R.id.firstname) as EditText

        var emailtext = findViewById(R.id.email) as EditText

        var usernametext = findViewById(R.id.username) as EditText

        var passwordtext = findViewById(R.id.password) as EditText

        var registerbutton = findViewById(R.id.registerbutton) as Button
        var bcklogin= findViewById(R.id.bckbtn) as Button


        // set on-click listener

        bcklogin.setOnClickListener {
            val message : String? = "Apakah Anda Yakin Ingin Membatalkan?"
            val judul : String? = "Daftar Akun"
            DialogBox(message,judul)

        }
        registerbutton.setOnClickListener {

            var firstname = firstnametext.text.toString()

            var email = emailtext.text.toString();

            var username = usernametext.text.toString();

            var password = passwordtext.text.toString();

            if(isEmpty(firstname) ||isEmpty(email) || isEmpty(username) || isEmpty(password)){
                Toast.makeText(this@register, "Please fill all fields", Toast.LENGTH_LONG).show()

            }else{
                val message : String? = "Apakah Anda Yakin?"
                val judul : String? = "Daftar Akun"
                DialogBox(message,judul)
                Toast.makeText(this,"Registrasi Berhasil",Toast.LENGTH_LONG).show()

            }

        }

    }
    private fun DialogBox(message: String?,judul: String?) {
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
            val bcklogin = Intent(this, login::class.java)
            startActivity(bcklogin)
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }

}