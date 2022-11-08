package yama.toku.wrapcontentanimationsample

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import yama.toku.wrapcontentanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.setOnClickListener {
            if (binding.textView.visibility == View.VISIBLE) {
                collapse()
            } else {
                expand()
            }
        }
    }

    // 縮小
    private fun collapse() {
        val actualHeight = binding.textView.height
        ValueAnimator.ofInt(actualHeight, 1).apply {
            duration = 200
            addUpdateListener { animator ->
                val newValue = animator.animatedValue as Int
                val layoutParams = binding.textView.layoutParams.apply {
                    height = newValue
                }
                binding.textView.layoutParams = layoutParams
            }
            doOnEnd {
                binding.textView.visibility = View.INVISIBLE
            }
            start()
        }
    }

    // 拡大
    private fun expand() {
        // [POINT]WRAP_CONTENTを指定した時の高さを計算します。
        binding.textView.measure(WRAP_CONTENT, WRAP_CONTENT)
        val expectedHeight = binding.textView.measuredHeight
        ValueAnimator.ofInt(1, expectedHeight).apply {
            duration = 200
            addUpdateListener { animator ->
                val newValue = animator.animatedValue as Int
                val layoutParams = binding.textView.layoutParams.apply {
                    height = newValue
                }
                binding.textView.layoutParams = layoutParams
            }
            doOnStart {
                binding.textView.visibility = View.VISIBLE
            }
            doOnEnd {
                val layoutParams = binding.textView.layoutParams.apply {
                    height = WRAP_CONTENT
                }
                binding.textView.layoutParams = layoutParams
            }
            start()
        }
    }
}