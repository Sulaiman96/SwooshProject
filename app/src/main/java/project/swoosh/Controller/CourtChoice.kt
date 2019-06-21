package project.swoosh.Controller

import android.content.Intent
import android.os.BatteryManager.EXTRA_LEVEL
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_court_choice.*
import project.swoosh.R
import project.swoosh.Utilities.EXTRA_COURT
import project.swoosh.Utilities.EXTRA_SCRIMMAGE

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CourtChoice : BaseActivity() {

    var courtChoice = ""
    var levelChoice = ""
    var scrimmageDetails = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_court_choice)

        scrimmageDetails = intent.getStringExtra(EXTRA_SCRIMMAGE)

        playButton.setOnClickListener(){
            if(courtChoice != "" && levelChoice != ""){
                val courtAndLevelIntent = Intent(this, FinishActivity::class.java)
                courtAndLevelIntent.putExtra(EXTRA_SCRIMMAGE, scrimmageDetails)
                courtAndLevelIntent.putExtra(EXTRA_COURT, courtChoice)
                courtAndLevelIntent.putExtra(EXTRA_LEVEL, levelChoice)
                startActivity(courtAndLevelIntent)
            }else{
                Toast.makeText(this, "Please Select all of the options", Toast.LENGTH_SHORT).show()
            }
        }

        indoorButton.setOnClickListener(){
            outdoorButton.isChecked = false

            courtChoice = "indoor"
        }

        outdoorButton.setOnClickListener(){
            indoorButton.isChecked = false

            courtChoice = "outdoor"
        }

        beginnerButton.setOnClickListener(){
            averageButton.isChecked = false
            ballerButton.isChecked = false

            levelChoice = "beginner"
        }

        averageButton.setOnClickListener(){
            beginnerButton.isChecked = false
            ballerButton.isChecked = false

            levelChoice = "average"
        }

        ballerButton.setOnClickListener(){
            beginnerButton.isChecked = false
            averageButton.isChecked = false

            levelChoice = "baller"
        }

    }

}
