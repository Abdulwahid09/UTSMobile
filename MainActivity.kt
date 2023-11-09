package com.edane.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //definisi widget
        var buttonav = findViewById<BottomNavigationView>(R.id.btnnav)
        var btnprof = findViewById<Button>(R.id.btn1)
        var btnhub = findViewById<Button>(R.id.btn3)
        var btnlogot = findViewById<Button>(R.id.btn4)
        var btnexit = findViewById<Button>(R.id.btn5)
        btnprof.setOnClickListener {
            val prf = Intent (this, fProfil::class.java)
            startActivity(prf)
        }
        btnhub.setOnClickListener {
            val cnt= Intent (this, fCp::class.java)
            startActivity(cnt)
        }
        btnlogot.setOnClickListener {
            val daftar = Intent (this, login::class.java)
            startActivity(daftar)
        }
        btnexit.setOnClickListener {
            finish()
        }
        buttonav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mn_home -> {
                    loadFragment(fHome())
                    true
                }
                R.id.mn_cp ->{
                    loadFragment(fKalkulator())
                    true
                }
                R.id.mn_histori ->{
                    loadFragment(fBmi())
                    true
                }
                R.id.mn_info -> {

                    loadFragment(fKeliling())
                    true
                }
                R.id.mn_pesan -> {

                    loadFragment(fPesan())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frmcontent,fragment)
        transaction.commit()
    }


}