import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val side = intent.getDoubleExtra("side", 0.0)
        val height = intent.getDoubleExtra("height", 0.0)

        val area = calculateArea(side, height)
        val perimeter = calculatePerimeter(side, height)

        val figureImageView: ImageView = findViewById(R.id.figureImageView)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        figureImageView.setImageResource(R.drawable.square)
        resultTextView.text = "Area: $area\nPerimeter: $perimeter"

        val resultIntent = Intent()
        resultIntent.putExtra("resultKey", "Result: Area=$area, Perimeter=$perimeter")
        setResult(Activity.RESULT_OK, resultIntent)

        finish()
    }

    private fun calculateArea(side: Double, height: Double): Double {
        return side * height / 2
    }

    private fun calculatePerimeter(side: Double, height: Double): Double {
        return side + height + Math.sqrt(side.pow(2.0) + height.pow(2.0))
    }
}
