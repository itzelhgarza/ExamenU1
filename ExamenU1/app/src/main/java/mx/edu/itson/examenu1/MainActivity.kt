package mx.edu.itson.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    //Variables
    lateinit var etC: EditText
    lateinit var etF: EditText
    lateinit var etK: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaración de elementos botón
        val btnGC: Button = findViewById(R.id.btnGC)
        val btnGF: Button = findViewById(R.id.btnGF)
        val btnGK: Button = findViewById(R.id.btnGK)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)

        //Declaración de elementos text
        etC = findViewById(R.id.etC)
        etF = findViewById(R.id.etF)
        etK = findViewById(R.id.etK)

        btnGC.setOnClickListener{
            conversionPresionada(GC)
        }
        btnGF.setOnClickListener{
            conversionPresionada(GF)
        }
        btnGK.setOnClickListener{
            conversionPresionada(GK)
        }
        btnBorrar.setOnClickListener{
            etC.setText("0")
            etF.setText("0")
            etK.setText("0")
        }

    }
    private fun conversionPresionada(operacion: Int){
        var num: Double = 0.0
        var conv2: Double = 0.0
        when (operacion) {
            GC ->
                if (etF.text.toString() != "0") {
                    num = etF.text.toString().toDouble()
                    num = (num - 32) / 1.8
                    etC.setText(num.toString())
                } else if (etK.text.toString() != "0") {
                    num = etK.text.toString().toDouble()
                    num = num - 273.15
                    etC.setText(num.toString())
                }
            GF ->
                if (etC.text.toString() != "0") {
                    num = etC.text.toString().toDouble()
                    num = num * 1.8 + 32
                    etF.setText(num.toString())
                } else if (etK.text.toString() != "0") {
                    num = etK.text.toString().toDouble()
                    num = (9*(num-273.15))/5+32
                    etF.setText(num.toString())
                }
            GK ->
                if (etF.text.toString() != "0") {
                    num = etF.text.toString().toDouble()
                    num = ((5*(num-32))/9)+273.15
                    etK.setText(num.toString())
                } else if (etC.text.toString() != "0") {
                    num = etC.text.toString().toDouble()
                    num = num + 273.15
                    etK.setText(num.toString())
                }

        }
    }
    companion object{
        const val GC = 1
        const val GF = 2
        const val GK = 3
    }
}