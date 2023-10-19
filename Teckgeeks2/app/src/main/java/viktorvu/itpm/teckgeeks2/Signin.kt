package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.app.AlertDialog
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import org.json.JSONObject

class Signin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        val loginbtn = findViewById<MaterialButton>(R.id.loginbtn)

        val signup = findViewById<TextView>(R.id.signup)

        signup.setOnClickListener {
            val i = Intent(this, Signup::class.java)
            startActivity(i)
        }


        loginbtn.setOnClickListener{

            val i = Intent(this, Home::class.java)
            i.putExtra("name", "John")
            startActivity(i)
        }


    }
}