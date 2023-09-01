package ktolin.homepage.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ktolin.homepage.app.databinding.ActivityMainRegisterBinding



class MainRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backHomeButton.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        binding.saveButton.setOnClickListener {
            var userName = binding.userNameRegister.text.toString()
            var userPassword = binding.passwordRegister.text.toString()
            var SharedPreferences = this.getSharedPreferences("userInfo", MODE_PRIVATE)
            val editor = SharedPreferences.edit()

            //add data
            editor.putString("user_name","$userName").apply()
            editor.putString("user_password","$userPassword").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.userNameRegister.text.clear()
            binding.passwordRegister.text.clear()

        }
    }

}