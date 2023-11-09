package com.edane.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fBmi.newInstance] factory method to
 * create an instance of this fragment.
 */
class fBmi : Fragment() {
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
        var _bmi: View = inflater.inflate(R.layout.fragment_f_bmi, container, false)
        var edt1 = _bmi.findViewById<EditText>(R.id.etHeight)
        // 2. edt 2
        var edt2 = _bmi.findViewById<EditText>(R.id.etWeight)
        var btnCal = _bmi.findViewById<Button>(R.id.btnCalculate)
        var txreslut = _bmi.findViewById<TextView>(R.id.tvResult)
        var txket = _bmi.findViewById<TextView>(R.id.txket)
        btnCal.setOnClickListener {
            val h = (edt1.text).toString().toFloat() / 100;
            val w = edt2.text.toString().toFloat()
            val bmi = w / (h * h)

            if (bmi<18.5){
                txreslut.text = "%.2f".format(bmi)
                txket.text = "Anda Termasuk Kategori Kurang"
            }else if (bmi > 18.5 && bmi<24.9){
                txreslut.text = "%.2f".format(bmi)
                txket.text = "Anda Termasuk Kategori Normal"
            }else if (bmi>24.9){
                txreslut.text = "%.2f".format(bmi)
                txket.text = "Anda Termasuk Kategori Berlebih"
            }else{

            }

        }
        return _bmi
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fHistory.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fBmi().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}