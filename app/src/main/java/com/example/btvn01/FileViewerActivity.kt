package com.example.btvn01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FileViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_viewer)

        val filePath = intent.getStringExtra(EXTRA_FILE_PATH)
        val textView = findViewById<TextView>(R.id.textContent)

        filePath?.let {
            textView.text = File(it).readText()
        }
    }

    companion object {
        private const val EXTRA_FILE_PATH = "file_path"

        fun newIntent(context: Context, filePath: String): Intent {
            return Intent(context, FileViewerActivity::class.java).apply {
                putExtra(EXTRA_FILE_PATH, filePath)
            }
        }
    }
}