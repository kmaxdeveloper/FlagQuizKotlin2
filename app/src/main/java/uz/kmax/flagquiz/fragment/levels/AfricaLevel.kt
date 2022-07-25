package uz.kmax.flagquiz.fragment.levels

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.core.view.get
import uz.kmax.flagquiz.R
import uz.kmax.flagquiz.databinding.UniversalFragmentBinding
import uz.kmax.flagquiz.fragment.BaseFragment
import uz.kmax.flagquiz.fragment.LevelFragment
import uz.kmax.flagquiz.tools.ArrayGame
import uz.kmax.flagquiz.tools.Dialogs
import uz.kmax.flagquiz.tools.SharedPref

class AfricaLevel : BaseFragment<UniversalFragmentBinding>(UniversalFragmentBinding::inflate) {
    private val array by lazy { ArrayGame() }
    private val shared by lazy { SharedPref(requireContext()) }
    private val dialog by lazy { Dialogs(requireContext()) }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreate() {
        dialog.africaDialog()
        binding.textLevels.setText(R.string.level_africa)
        binding.imgLeft.clipToOutline = true
        binding.imgRight.clipToOutline = true
        binding.buttonBack.setOnClickListener {
            transition = 1
            showAd()
        }
        levelProgress()
        dialog.setOnDialogClickListener {
            replaceFragment(LevelFragment())
        }
        dialog.setOnDialogEndClickListener {
            replaceFragment(NAmericaLevel())
        }
        binding.imgLeft.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                binding.imgRight.isClickable = false
                if (array.AsiantrueAndFalse[numLeft] < array.AsiantrueAndFalse[numRight]) {
                    binding.imgLeft.setImageResource(R.drawable.img_true)
                } else {
                    binding.imgLeft.setImageResource(R.drawable.img_false)
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                if (array.AsiantrueAndFalse[numLeft] < array.AsiantrueAndFalse[numRight]) {
                    gameProgress(1)
                } else {
                    gameProgress(2)
                }
                checkGame(2)
            }
            return@setOnTouchListener true
        }

        binding.imgRight.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                binding.imgRight.isClickable = false
                if (array.africaTrueAndFalse[numLeft] > array.africaTrueAndFalse[numRight]) {
                    binding.imgRight.setImageResource(R.drawable.img_true)
                } else {
                    binding.imgRight.setImageResource(R.drawable.img_false)
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                if (array.africaTrueAndFalse[numLeft] > array.africaTrueAndFalse[numRight]) {
                    gameProgress(1)
                } else {
                    gameProgress(2)
                }
                checkGame(1)
            }
            return@setOnTouchListener true
        }
    }

    private fun levelProgress(){
        numLeft = random.nextInt(103)
        numRight = random.nextInt(103)
        while (numLeft == numRight) { numRight = random.nextInt(109) }
        if (numLeft % 2 == 0 && numRight % 2 == 0 || numLeft % 2 == 1 && numRight % 2 == 1) { numRight += 1 }

        binding.imgLeft.setImageResource(array.africa[numLeft])
        binding.textLeft.setText(array.africaName[numLeft])
        binding.imgRight.setImageResource(array.africa[numRight])
        binding.textRight.setText(array.africaName[numRight])
    }

    private fun gameProgress(type : Int){
        if (type== 1){
            if (count < 20) { count += 1 }
            for (i in 0..19) {
                binding.progressParent[i].setBackgroundResource(R.drawable.style_point)
            }
        }else{
            if (count > 0) { count = if (count == 1) 0 else count - 2 }
            for (i in 0..18) {
                binding.progressParent[i].setBackgroundResource(R.drawable.style_point)
            }
        }
        for (i in 0 until count) {
            binding.progressParent[i].setBackgroundResource(R.drawable.style_point_green)
        }
    }

    private fun checkGame(type: Int){
        if (count == 20) {
            if (shared.getLevel() <= 3) {
                shared.setLevel(4)
            }
            dialog.endDialog()
        } else {
            levelProgress()
            if (type == 1){
                binding.imgLeft.isClickable = true
            }else{
                binding.imgRight.isClickable = true
            }
        }
    }

    override fun onAdsClosed() {
        when(transition){
            1-> replaceFragment(LevelFragment())
            2-> replaceFragment(NAmericaLevel())
            else -> replaceFragment(LevelFragment())
        }
    }
}