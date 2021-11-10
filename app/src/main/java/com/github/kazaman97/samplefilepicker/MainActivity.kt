package com.github.kazaman97.samplefilepicker

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.kazaman97.samplefilepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val content =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            binding.filePath.text = uri?.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.fileSelectionButton.setOnClickListener {
            content.launch("text/*")
        }
    }
}
