package viktorvu.itpm.teckgeeks2



import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbutton = findViewById<ImageButton>(R.id.startButton)

        startbutton.setOnClickListener {
            val i = Intent(this, Onboarding::class.java)
            startActivity(i)
        }
    }


}