package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Verification : AppCompatActivity() {

    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify)


        val verify = findViewById<MaterialButton>(R.id.verify)

        val signup = findViewById<TextView>(R.id.signup)

        val getName = intent.getStringExtra("name")

        verify.setOnClickListener{
            val i = Intent(this, Verified::class.java)
            i.putExtra("name", getName)
            startActivity(i)
        }

        signup.setOnClickListener {
            val i = Intent(this, Signup::class.java)
            startActivity(i)
        }
    }
}