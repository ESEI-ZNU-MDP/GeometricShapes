import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sideEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button

    companion object {
        const val CALCULATION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sideEditText = findViewById(R.id.sideEditText)
        heightEditText = findViewById(R.id.heightEditText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            onCalculateButtonClick(it)
        }
    }

    private fun onCalculateButtonClick(view: View) {
        val side = sideEditText.text.toString().toDouble()
        val height = heightEditText.text.toString().toDouble()

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("side", side)
        intent.putExtra("height", height)

        startActivityForResult(intent, CALCULATION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CALCULATION_REQUEST_CODE && resultCode == RESULT_OK) {
            val result = data?.getStringExtra("resultKey")
            // Тепер `result` містить зворотні дані
        }
    }
}
