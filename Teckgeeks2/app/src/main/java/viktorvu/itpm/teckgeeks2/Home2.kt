package viktorvu.itpm.teckgeeks2


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import org.json.JSONObject


class Home2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home2)


        val name = findViewById<TextView>(R.id.name)
        val getName = intent.getStringExtra("name")
        name.text = getName

        val jobtitle = findViewById<TextView>(R.id.jobtitle)
        val getJobTitle = intent.getStringExtra("jobtitle")
        jobtitle.text = getJobTitle

        val location = findViewById<TextView>(R.id.location)
        val getLocation = intent.getStringExtra("location")
        location.text = getLocation

        val duration = findViewById<TextView>(R.id.duration)
        val getDuration = intent.getStringExtra("duration")
        duration.text = getDuration

        val budget = findViewById<TextView>(R.id.budget)
        val getBudget = intent.getStringExtra("budget") + "$"
        budget.text = getBudget

        val postjob = findViewById<MaterialButton>(R.id.postjob)

        postjob.setOnClickListener {
            val i = Intent(this, Postjob::class.java)
            i.putExtra("name", name.text.toString())
            startActivity(i)
        }

    }


}