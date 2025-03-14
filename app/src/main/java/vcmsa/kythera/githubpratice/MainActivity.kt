package vcmsa.kythera.githubpratice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Toast
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val input= findViewById<EditText>(R.id.edtNumber)
        val clickMe:Button= findViewById(R.id.btnCheckNum)

        clickMe.setOnClickListener {
            try {

                val numberInt = input.text.toString().toInt()

                if (numberInt % 2 == 0) {
                    Toast.makeText(this, "The number $numberInt is even", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this, "the number $numberInt is odd", Toast.LENGTH_LONG).show()
                }

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input $input is not a number", Toast.LENGTH_LONG).show()
            }
        }
    }
}