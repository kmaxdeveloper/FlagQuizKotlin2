package uz.kmax.flagquiz.fragment

import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.get
import uz.kmax.flagquiz.R
import uz.kmax.flagquiz.databinding.LevelFragmentBinding
import uz.kmax.flagquiz.fragment.levels.*
import uz.kmax.flagquiz.tools.SharedPref

class LevelFragment : BaseFragment<LevelFragmentBinding>(LevelFragmentBinding::inflate){
    val sharedPref by lazy{
        SharedPref(requireContext())
    }
    override fun onViewCreate() {
        setLevelName()
        binding.asianLevel.setOnClickListener {
            replaceFragment(AsianLevel())
        }
        binding.europaLevel.setOnClickListener {
            if (sharedPref.getLevel() > 1){
                replaceFragment(EuropaLevel())
            }else{
                Toast.makeText(requireContext(), "Please play Asian Level !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.africaLevel.setOnClickListener {
            if (sharedPref.getLevel() > 2){
                replaceFragment(AfricaLevel())
            }else{
                Toast.makeText(requireContext(), "Please play Europa Level !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.NAmericaLevel.setOnClickListener {
            if (sharedPref.getLevel() > 3){
                replaceFragment(NAmericaLevel())
            }else{
                Toast.makeText(requireContext(), "Please play Africa Level !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.SAmericaLevel.setOnClickListener {
            if (sharedPref.getLevel() > 4){
                replaceFragment(SAmericaFragment())
            }else{
                Toast.makeText(requireContext(), "Please play North America Level !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.oceaniaLevel.setOnClickListener {
            if (sharedPref.getLevel() > 5){
                replaceFragment(OceaniaLevel())
            }else{
                Toast.makeText(requireContext(), "Please play South America Level !", Toast.LENGTH_SHORT).show()
            }
        }
        binding.level30.setOnClickListener {
            if (sharedPref.getLevel() > 6){
                replaceFragment(AfricaLevel())
            }else{
                Toast.makeText(requireContext(), "Please play Oceania Level !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setLevelName() {
        val continents = intArrayOf(
            R.string.continentAsia,
            R.string.continentEuropa,
            R.string.continentAfrica,
            R.string.continentNamerica,
            R.string.continentSamerica,
            R.string.continentOceania,
            R.string.level_30
        )

        for (i in 0 until sharedPref.getLevel()){
            val btn = binding.levelParent[i] as AppCompatButton
            btn.setText(continents[i])
        }
    }

    override fun onAdsClosed() {

    }
}