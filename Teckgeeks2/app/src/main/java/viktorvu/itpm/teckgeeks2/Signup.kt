package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val signin = findViewById<TextView>(R.id.signintxt)
        val username = findViewById<EditText>(R.id.username)

        val signup = findViewById<MaterialButton>(R.id.signup)



        signin.setOnClickListener {
            val i = Intent(this, Signin::class.java)
            startActivity(i)
        }

        signup.setOnClickListener{
            val i = Intent(this, Verification::class.java)
            i.putExtra("name", username.text.toString())
            startActivity(i)
        }




    }
}