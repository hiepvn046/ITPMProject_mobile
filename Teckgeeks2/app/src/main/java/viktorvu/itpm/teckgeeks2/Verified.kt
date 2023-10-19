package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Verified : AppCompatActivity() {
    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verified)

        val gohome = findViewById<MaterialButton>(R.id.gohome)

        val getName = intent.getStringExtra("name")

        gohome.setOnClickListener{
            val i = Intent(this, Home::class.java)
            i.putExtra("name", getName)
            startActivity(i)
        }
    }
}