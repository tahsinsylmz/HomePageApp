package ktolin.homepage.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import ktolin.homepage.app.databinding.ActivityMainWelcomeBinding

class MainWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var preferences = getSharedPreferences("userInfo", MODE_PRIVATE)

        var registerUser = preferences.getString("user_name","")
        var registerPassword = preferences.getString("user_password","")
        binding.userNameInfo.text = "Kullanıcı adı:  "+registerUser.toString()
        binding.passwordInfo.text = "Şifre:  "+registerPassword.toString()

        binding.exitButton.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}