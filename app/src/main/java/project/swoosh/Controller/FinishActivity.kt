package project.swoosh.Controller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import project.swoosh.R
import project.swoosh.Utilities.EXTRA_COURT
import project.swoosh.Utilities.EXTRA_LEVEL
import project.swoosh.Utilities.EXTRA_SCRIMMAGE

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class FinishActivity : AppCompatActivity() {

    var court = ""
    var level = ""
    var scrimmage = ""
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        court = intent.getStringExtra(EXTRA_COURT)
        level = intent.getStringExtra(EXTRA_LEVEL)
        scrimmage = intent.getStringExtra(EXTRA_SCRIMMAGE)

        searchingText.text = "Looking for a ${scrimmage.toLowerCase()} scrimmage in $court with $level level players near you..."
    }
}
