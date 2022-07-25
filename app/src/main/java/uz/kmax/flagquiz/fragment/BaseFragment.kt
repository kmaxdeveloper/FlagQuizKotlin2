package uz.kmax.flagquiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import uz.kmax.flagquiz.controller.FragmentController
import uz.kmax.flagquiz.fragment.levels.EuropaLevel
import uz.kmax.flagquiz.tools.ArrayGame
import java.util.*


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    private val controller = FragmentController.controller
    var interstitialAd: InterstitialAd? = null
    var numLeft = 0
    var numRight = 0
    var count = 0
    var transition = 0
    var random = Random()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    fun replaceFragment(Fragment: Fragment) {
        controller?.replaceFragment(Fragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mobileAds()
        onViewCreate()
    }

    fun mobileAds(){
        MobileAds.initialize(requireContext())
        interstitialAd = InterstitialAd(requireContext())
        interstitialAd!!.adUnitId = "ca-app-pub-4664801446868642/7374004703"
        val adRequest = AdRequest.Builder().build()
        interstitialAd!!.loadAd(adRequest)

        interstitialAd!!.adListener = object : AdListener() {
            override fun onAdClosed() {
                onAdsClosed()
            }
        }
    }

    private fun adsIsLoaded():Boolean{
        if (interstitialAd!!.isLoaded){
            return true
        }
        return false
    }

    fun showAd(){
        if (adsIsLoaded()){
            interstitialAd!!.show()
        }else{
            replaceFragment(LevelFragment())
        }
    }

    abstract fun onAdsClosed()

    abstract fun onViewCreate()

}
