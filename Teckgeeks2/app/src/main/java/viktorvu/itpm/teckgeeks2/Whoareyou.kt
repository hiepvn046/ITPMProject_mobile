package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Whoareyou : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.whoareyou)

        val rec1 = findViewById<LinearLayout>(R.id.rec1)
        val rec2 = findViewById<LinearLayout>(R.id.rec2)
        val rec3 = findViewById<LinearLayout>(R.id.rec3)

        val signin = findViewById<TextView>(R.id.signin)

        rec1.setOnClickListener {
            val i = Intent(this, Signup::class.java)
            startActivity(i)
        }

        rec2.setOnClickListener {
            val i = Intent(this, Signup::class.java)
            startActivity(i)
        }

        rec3.setOnClickListener {
            val i = Intent(this, Signup::class.java)
            startActivity(i)
        }

        signin.setOnClickListener {
            val i = Intent(this, Signin::class.java)
            startActivity(i)
        }
    }
}