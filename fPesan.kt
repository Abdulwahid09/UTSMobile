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
 * Use the [fPesan.newInstance] factory method to
 * create an instance of this fragment.
 */
class fPesan : Fragment() {
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
        // Inflate the layout for this fragment
        var pilihan = 0
        var _bVie: View = inflater.inflate(R.layout.fragment_f_pesan, container, false)
        var gEdt1 = _bVie.findViewById<EditText>(R.id.edt_1)
        var gEdt2 = _bVie.findViewById<EditText>(R.id.edt_2)
        var gEdt3 = _bVie.findViewById<EditText>(R.id.edt_3)
        var gSpin = _bVie.findViewById<Spinner>(R.id.spinner)
        var btnk = _bVie.findViewById<Button>(R.id.btn_calculator)
        var gTvHasil = _bVie.findViewById<TextView>(R.id.tx_hasil)
        var txket = _bVie.findViewById<TextView>(R.id.txket)
        var btnreset = _bVie.findViewById<Button>(R.id.btn_reset)


        btnk.setOnClickListener {
            var nilai1 = gEdt1.text.toString().toDouble()
            var nilai2 = gEdt2.text.toString().toDouble()
            var nilai3 = gEdt3.text.toString().toDouble()
            var nilai_AK = 0.0
            Log.d("me", "nilai1: " + nilai1 +
                    ", nilai2: " + nilai2 +", nilai3: " + nilai3)

                nilai_AK = (nilai1*0.2) + (nilai2*0.3) +(nilai3*0.4)+10

            if (nilai_AK<60){
                gTvHasil.text = nilai_AK.toString()
                txket.text = "Selamat, Dari Total Nilai Keseluruhan, Anda Mendapatkan Grade D"
            }else if (nilai_AK >59 && nilai_AK<70){
                gTvHasil.text = nilai_AK.toString()
                txket.text = "Selamat, Dari Total Nilai Keseluruhan, Anda Mendapatkan Grade C "
            }else if (nilai_AK > 69 && nilai_AK<80){
                gTvHasil.text = nilai_AK.toString()
                txket.text = "Selamat, Dari Total Nilai Keseluruhan, Anda Mendapatkan Grade B "
            }else if (nilai_AK>79){
                gTvHasil.text = nilai_AK.toString()
                txket.text = "Selamat, Dari Total Nilai Keseluruhan, Anda Mendapatkan Grade A "
            }else{
                txket.text = "Selamat, Dari Total Nilai Keseluruhan, Anda Mendapatkan Grade E "
            }

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
        btnreset.setOnClickListener {
            gEdt1.setText("")
            gEdt2.setText("")
            gEdt3.setText("")
            txket.text = ""
            gTvHasil.text=""

        }
        return _bVie
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fProfil.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fPesan().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}