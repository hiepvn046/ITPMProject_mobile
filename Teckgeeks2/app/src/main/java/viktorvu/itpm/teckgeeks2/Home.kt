package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val name = findViewById<TextView>(R.id.name)
        val getName = intent.getStringExtra("name")
        name.text = getName

        val postbtn = findViewById<MaterialButton>(R.id.postjob)

        postbtn.setOnClickListener{
            val i = Intent(this, Postjob::class.java)
            i.putExtra("name", name.text.toString())
            startActivity(i)
        }

    }
}