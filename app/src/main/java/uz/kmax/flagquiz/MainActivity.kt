package uz.kmax.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.kmax.flagquiz.controller.FragmentController
import uz.kmax.flagquiz.databinding.ActivityMainBinding
import uz.kmax.flagquiz.fragment.SplashFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentController.init(R.id.container, supportFragmentManager)
        FragmentController.controller?.startMainFragment(SplashFragment())
    }
}