package ktolin.homepage.app

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ktolin.homepage.app.databinding.ActivityMainBinding
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("userInfo", MODE_PRIVATE)

        binding.loginButton.setOnClickListener {
            var registerUser = preferences.getString("user_name","")
            var registerPassword = preferences.getString("user_password","")

            var enteredUser = binding.userNameEntry.text.toString()
            var enteredPassword = binding.passwordEntry.text.toString()

            if ((registerUser == enteredUser) && (registerPassword==enteredPassword)){
                intent = Intent(applicationContext,MainWelcome::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "Giriş bilgileri hatalı.", Toast.LENGTH_LONG).show()
            }


        }

        binding.registerButton.setOnClickListener {

            intent = Intent(applicationContext,MainRegister::class.java)
            startActivity(intent)

        }

    }
}