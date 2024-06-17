package com.example.floravista.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import com.example.floravista.MenuBottom
import com.example.floravista.ViewModelFactory
import com.example.floravista.data.pref.UserModel
import com.example.floravista.databinding.ActivityLoginBinding
import com.example.floravista.view.main.MainActivity
import com.example.floravista.view.register.SignupActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerNow.setOnClickListener{
            val intent = Intent(this@LoginActivity,  SignupActivity::class.java)
            startActivity(intent)
        }

        setupView()
        setupAction()
        authenticationPass()
        playAnimation()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                binding.apply {
                    loginViewModel.login(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                }
            }
        }
    }

    private fun authenticationPass() {
        loginViewModel.loginResponse.observe(this){ login ->
            if(login.user != null){
                loginViewModel.saveSession(
                    UserModel(
                        binding.emailEditText.text.toString(),
                        login.token.toString(),
                        true
                    )
                )
                showLoading(false)
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }else{
                showLoading(false)
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.welcomeImg, View.TRANSLATION_Y, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val welcome = ObjectAnimator.ofFloat(binding.textView, View.ALPHA, 1f).setDuration(500)
        val email = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val pass = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val button = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val not = ObjectAnimator.ofFloat(binding.notMember, View.ALPHA, 1f).setDuration(500)
        val reg = ObjectAnimator.ofFloat(binding.registerNow, View.ALPHA, 1f).setDuration(500)
        AnimatorSet().apply {
            playSequentially(welcome, email, pass, button, not, reg)
            start()
        }

    }

    private fun showLoading(isLoading: Boolean) {
        //binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}