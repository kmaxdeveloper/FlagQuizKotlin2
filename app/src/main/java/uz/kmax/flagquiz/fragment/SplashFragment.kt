package uz.kmax.flagquiz.fragment

import android.os.CountDownTimer
import uz.kmax.flagquiz.databinding.SplashFragmentBinding

class SplashFragment : BaseFragment<SplashFragmentBinding>(SplashFragmentBinding::inflate) {
    override fun onViewCreate() {
        object : CountDownTimer(3000, 100) {
            override fun onFinish() {
                replaceFragment(LevelFragment())
            }

            override fun onTick(value: Long) {

            }
        }.start()
    }

    override fun onAdsClosed() {

    }
}