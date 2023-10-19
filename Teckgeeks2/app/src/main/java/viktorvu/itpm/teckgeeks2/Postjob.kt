package viktorvu.itpm.teckgeeks2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import org.json.JSONObject

class Postjob : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postjob)

        val getName = intent.getStringExtra("name")



        val postjob = findViewById<MaterialButton>(R.id.postjob)
        val back = findViewById<ImageButton>(R.id.back)

        val jobtitle = findViewById<EditText>(R.id.jobtitlefield)
        val description = findViewById<EditText>(R.id.descriptionbox)


        val location = findViewById<EditText>(R.id.locationspinner)
        val duration = findViewById<Spinner>(R.id.jobdurationspinner)
        val budget = findViewById<EditText>(R.id.budget)

        val service = findViewById<Spinner>(R.id.servicespinner)
        val jobtype = findViewById<Spinner>(R.id.jobtypespinner)

        val startDate = findViewById<Spinner>(R.id.startdate)
        val finishDate = findViewById<Spinner>(R.id.finishdate)

        back.setOnClickListener {
            val i = Intent(this, Home::class.java)
            i.putExtra("name", getName)
            startActivity(i)
        }




        ArrayAdapter.createFromResource(
            this,
            R.array.servicesList,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            service.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.jobTypeList,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            jobtype.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.dateList,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            startDate.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.dateList,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            finishDate.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.durationList,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            duration.adapter = adapter
        }

        postjob.setOnClickListener{

            val queue = Volley.newRequestQueue(this)
            val url = "https://techgeeksprotobackend.azurewebsites.net/api/Job/createJob"


            val jsonLocation = JSONObject()
            jsonLocation.put("address", location.text.toString())
            jsonLocation.put("longitude", 153.518403)
            jsonLocation.put("latitude", -28.206651)

            val jsonDuration = JSONObject()
            jsonDuration.put("hours", 8)
            jsonDuration.put("days", 0)
            jsonDuration.put("months", 0)
            jsonDuration.put("years", 0)

            val bodyItems = JSONObject()
            bodyItems.put("jobName",jobtitle.text.toString())
            bodyItems.put("jobDescription",description.text.toString())
            bodyItems.put("serviceName",service.selectedItem.toString())
            bodyItems.put("jobType",jobtype.selectedItem.toString())
            bodyItems.put("jobLocation",jsonLocation)
            bodyItems.put("jobDuration",jsonDuration)
            bodyItems.put("jobStartDate",startDate.selectedItem.toString())
            bodyItems.put("jobEndDate",finishDate.selectedItem.toString())
            bodyItems.put("jobStatus","available")
            bodyItems.put("jobPrice",budget.text.toString())
            bodyItems.put("jobOwner","6514f7958a8ed8f82295df31")

            Log.d("data", bodyItems.toString())


            val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, bodyItems,
                { response ->
                    Log.d("something",response.toString())
                },
                { error ->
                    Log.e("error",error.toString())
                }
            )

            queue.add(jsonObjectRequest)


            val i = Intent(this, Home2::class.java)
            i.putExtra("name", getName)
            i.putExtra("jobtitle",jobtitle.text.toString())
            i.putExtra("location", location.text.toString())
            i.putExtra("budget",budget.text.toString())
            i.putExtra("duration", duration.selectedItem.toString())

            startActivity(i)
        }

    }
}