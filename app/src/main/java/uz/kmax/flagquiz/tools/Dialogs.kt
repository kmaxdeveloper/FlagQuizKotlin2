package uz.kmax.flagquiz.tools

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import uz.kmax.flagquiz.databinding.*

class Dialogs(context: Context) {

    var mContext = context

    private var onDialogClickListener: (() -> Unit)? = null

    fun setOnDialogClickListener(listener: () -> Unit) {
        onDialogClickListener = listener
    }

    private var onDialogEndClickListener: (() -> Unit)? = null

    fun setOnDialogEndClickListener(listener: () -> Unit) {
        onDialogEndClickListener = listener
    }

    fun asianDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogAsianBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.BtnAsianDialogClose.setOnClickListener {
            onDialogClickListener?.invoke()
            dialog.dismiss()
        }

        binding.btnAsianDialogContinue.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun endDialog(){
        var dialogEnd = Dialog(mContext)
        var binding = DialogendBinding.inflate(LayoutInflater.from(mContext))
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEnd.setContentView(binding.root)
        dialogEnd.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEnd.setCancelable(false)

        binding.BtnEndDialogClose.setOnClickListener {
            onDialogEndClickListener?.invoke()
            dialogEnd.dismiss()
        }

        binding.btnEndDialogContinue.setOnClickListener {
            onDialogEndClickListener?.invoke()
            dialogEnd.dismiss()
        }
        dialogEnd.show()
    }

    fun europaDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogEuropaBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.buttonCloseEuropa.setOnClickListener {
            onDialogClickListener?.invoke()
        }

        binding.btnContinueEuropa.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun africaDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogAfricaBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.buttonCloseAfrica.setOnClickListener {
            onDialogClickListener?.invoke()
            dialog.dismiss()
        }
        binding.btnContinueAfrica.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun sAmericaDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogSamericaBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.btnContinueSAmerica.setOnClickListener {
            dialog.dismiss()
        }

        binding.buttonCloseSAmerica.setOnClickListener {
            onDialogClickListener?.invoke()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun nAmericaDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogNamericaBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.btnContinueNAmerica.setOnClickListener {
            dialog.dismiss()
        }

        binding.buttonCloseSamerica.setOnClickListener {
            onDialogClickListener?.invoke()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun oceaniaDialog(){
        var dialog = Dialog(mContext)
        var binding = DialogOceaniaBinding.inflate(LayoutInflater.from(mContext))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        binding.btnContinueOceania.setOnClickListener {
            dialog.dismiss()
        }

        binding.buttonCloseOceania.setOnClickListener {
            onDialogClickListener?.invoke()
            dialog.dismiss()
        }

        dialog.show()
    }
}