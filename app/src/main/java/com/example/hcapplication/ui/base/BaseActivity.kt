package com.example.hcapplication.ui.base

import android.app.Dialog
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity(), MvpView {

    private var progressDialog: Dialog? = null

    private fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {}

    override fun hideLoading() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.cancel()
        }
    }

    override fun showMessage(message: String) {
        if (message != null)
            displayMessage(message)
    }

    override fun showError(message: String) {
        if (message != null)
            displayError(message)
    }

}