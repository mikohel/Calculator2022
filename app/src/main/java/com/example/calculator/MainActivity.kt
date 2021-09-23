package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDel.setOnClickListener{
           binding.etResult.setText(binding.etResult.text.dropLast(1))
        }

        binding.btnAc.setOnClickListener{
            binding.etResult.text.clear()
        }

        binding.btnIgual.setOnClickListener{
            when(operator){
                "Multi" -> {
                    binding.etResult.setText("${firstValue * binding.etResult.text.toString().toDouble()}")
                }
                "Div" -> {
                    binding.etResult.setText("${firstValue / binding.etResult.text.toString().toDouble()}")
                }
                "Sum" -> {
                    binding.etResult.setText("${firstValue + binding.etResult.text.toString().toDouble()}")
                }
                "Rest" -> {
                    binding.etResult.setText("${firstValue - binding.etResult.text.toString().toDouble()}")
                }
            }
        }

        binding.btnPorcentaje.setOnClickListener{
            binding.etResult.setText("${binding.etResult.text.toString().toString().toDouble()/100}")
        }


    }

    fun numberButtonClicked(view: View){
        val button = view as Button

        when(button.id){

            binding.btnPoint.id ->{
                if (!binding.etResult.text.contains('.')){
                    binding.etResult.text.append(".")
                }
            }

            binding.btn0.id -> { binding.etResult.text.append(binding.btn0.text) }
            binding.btn1.id -> { binding.etResult.text.append(binding.btn1.text) }
            binding.btn2.id -> { binding.etResult.text.append(binding.btn2.text) }
            binding.btn3.id -> { binding.etResult.text.append(binding.btn3.text) }
            binding.btn4.id -> { binding.etResult.text.append(binding.btn4.text) }
            binding.btn5.id -> { binding.etResult.text.append(binding.btn5.text) }
            binding.btn6.id -> { binding.etResult.text.append(binding.btn6.text) }
            binding.btn7.id -> { binding.etResult.text.append(binding.btn7.text) }
            binding.btn8.id -> { binding.etResult.text.append(binding.btn8.text) }
            binding.btn9.id -> { binding.etResult.text.append(binding.btn9.text) }

            else -> { Toast.makeText(this,"else", Toast.LENGTH_LONG).show()}
        }
    }

    fun operatorClicked(view: View){
            val button = view as Button
       operator = when(button.id){

           binding.btnMulti.id -> {"Multi"}
           binding.btnDiv.id -> {"Div"}
           binding.btnSuma.id -> {"Sum"}
           binding.btnResta.id -> {"Rest"}

           else -> {""}
       }
        firstValue = binding.etResult.text.toString().toDouble()
        binding.etResult.text.clear()
    }



}