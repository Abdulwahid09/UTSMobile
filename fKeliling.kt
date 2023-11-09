package com.edane.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class fKeliling : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var pilihan = 0
        var _hit: View = inflater.inflate(R.layout.fragment_f_keliling, container, false)
        var gEdt1 = _hit.findViewById<EditText>(R.id.edt_1)
        var gSpin = _hit.findViewById<Spinner>(R.id.spinner)
        var btnk = _hit.findViewById<Button>(R.id.btn_calculator)
        var gTvHasil = _hit.findViewById<TextView>(R.id.tx_hasil)

        btnk.setOnClickListener {
            var sisi = gEdt1.text.toString().toDouble()
            var keliling = 0.0
            Log.d("me", "nilai1: " + sisi)
            if(pilihan.equals(0)){ // persegi
                keliling = sisi + sisi + sisi + sisi
            }
            else if( pilihan.equals(1)){ //segitiga
                keliling = sisi + sisi + sisi
            }
            else if( pilihan.equals(2)){ //Belah Ketupat
                keliling = 4 * sisi
            }
            else if( pilihan.equals(3)){ //Layang
                keliling = 4 * (sisi+sisi)
            }
            else if( pilihan.equals(4)){ //Trapesium
                keliling = sisi + sisi + sisi + sisi
            }

            gTvHasil.text = keliling.toString()

        }
        gSpin.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Log.d("me", "pilih item: " + p2)
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            })

        // Inflate the layout for this fragment
        return _hit
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fHome.
         */
        // TODO: Rename and change types and number of parameters

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fKeliling().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}