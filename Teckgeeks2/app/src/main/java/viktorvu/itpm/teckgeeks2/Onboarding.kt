package viktorvu.itpm.teckgeeks2

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Onboarding : AppCompatActivity() {

    private var isSecondLayoutExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.subonb)

        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)

        val illustration1 = dialog.findViewById<ImageView>(R.id.illustration1)
        val illustration2 = dialog.findViewById<ImageView>(R.id.illustration2)
        val nextsubonb = dialog.findViewById<ImageButton>(R.id.nextsubonb)

        var firstClick = true
        illustration2.isEnabled = false
        illustration2.visibility = View.INVISIBLE
        illustration2.setImageResource(R.drawable.illustration2)

        nextsubonb.setOnClickListener {
            if(firstClick) {
                title.text = "Manage Your Tasks"
                subtitle.text =
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking."

                val slideOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
                val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)

                illustration1.startAnimation(slideOutAnimation)
                illustration1.visibility = View.INVISIBLE
                illustration1.isEnabled = false

                illustration2.isEnabled = true
                illustration2.visibility = View.VISIBLE
                illustration2.startAnimation(slideInAnimation)

                firstClick = false
            } else {
                dialog.dismiss()
                val i = Intent(this, Whoareyou::class.java)
                startActivity(i)
            }
        }

        illustration1.setOnClickListener{
            title.text = "Manage Your Tasks"
            subtitle.text =
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking."

            val slideOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)

            illustration1.startAnimation(slideOutAnimation)
            illustration1.visibility = View.INVISIBLE
            illustration1.isEnabled = false
            illustration2.isEnabled = true
            illustration2.visibility = View.VISIBLE
            illustration2.startAnimation(slideInAnimation)

            firstClick = false
        }

        illustration2.setOnClickListener{
            title.text = "Schedule Your Tasks"
            subtitle.text =
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking."

            val slideOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)

            illustration2.startAnimation(slideOutAnimation)
            illustration2.visibility = View.INVISIBLE
            illustration2.isEnabled = false

            illustration1.isEnabled = true
            illustration1.visibility = View.VISIBLE
            illustration1.startAnimation(slideInAnimation)

            firstClick = true
        }

        val back = findViewById<TextView>(R.id.back)
        val skip = findViewById<TextView>(R.id.skip)

        back.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        skip.setOnClickListener {
            val i = Intent(this, Whoareyou::class.java)
            startActivity(i)
        }
    }

}