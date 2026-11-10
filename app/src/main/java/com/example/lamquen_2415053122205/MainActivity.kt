package com.example.lamquen_2415053122205

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lamquen_2415053122205.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            handleCheck()
        }
        binding.btnClear.setOnClickListener {
            handleClear()
        }
    }

    private fun handleCheck() {
        val nameInput = binding.etName.text.toString().trim()
        val quantityInput = binding.etQuantity.text.toString().trim()
        binding.tvResult.text = ""
        binding.tvLabel.text = ""

        if (nameInput.isEmpty()) {
            showError("Lỗi: Tên không được để trống!")
            return
        }

        try {
            val quantity = quantityInput.toInt()
            if (quantity in 1..9) {
                binding.tvResult.setTextColor(Color.parseColor("#006400"))
                binding.tvResult.text = "Xin chào $nameInput, số lượng: $quantity"
                binding.tvLabel.setTextColor(Color.parseColor("#006400"))
                binding.tvLabel.text = if (quantity < 5) "Ít" else "Nhiều"
            } else {
                showError("Lỗi: Số lượng phải là số nguyên từ 1 đến 9.")
            }
        } catch (_: NumberFormatException) {
            showError("Lỗi: Vui lòng nhập số lượng hợp lệ.")
        }
    }

    private fun handleClear() {
        binding.etName.text.clear()
        binding.etQuantity.text.clear()
        binding.tvResult.text = ""
        binding.tvLabel.text = ""
    }

    private fun showError(message: String) {
        binding.tvResult.setTextColor(Color.RED)
        binding.tvResult.text = message
        binding.tvLabel.text = ""
    }
}
