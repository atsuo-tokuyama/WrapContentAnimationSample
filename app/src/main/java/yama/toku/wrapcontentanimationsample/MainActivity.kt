package yama.toku.wrapcontentanimationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yama.toku.wrapcontentanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.setOnClickListener {

        }
    }

    private fun collapse() {
        

    }

    private fun expand() {

    }
}