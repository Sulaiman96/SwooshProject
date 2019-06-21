package project.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_scrimmage_details.*
import project.swoosh.Utilities.EXTRA_SCRIMMAGE
import project.swoosh.R

class ScrimmageDetails : BaseActivity() {

    var scrimmageTypeSelected = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrimmage_details)

        nextButton.setOnClickListener() {
            if(scrimmageTypeSelected != ""){
                val scrimmageIntent = Intent(this, CourtChoice::class.java)
                scrimmageIntent.putExtra(EXTRA_SCRIMMAGE, scrimmageTypeSelected)
                startActivity(scrimmageIntent)
            }else{
                Toast.makeText(this, "Please Select a scrimmage type", Toast.LENGTH_SHORT).show()
            }
        }

        casualScrimmageButton.setOnClickListener() {
            semiCompetitiveButton.isChecked = false
            competitiveButton.isChecked = false

            scrimmageTypeSelected = "Casual"
        }

        semiCompetitiveButton.setOnClickListener() {
            casualScrimmageButton.isChecked = false
            competitiveButton.isChecked = false

            scrimmageTypeSelected = "Semi Competitive"
        }

        competitiveButton.setOnClickListener() {
            semiCompetitiveButton.isChecked = false
            casualScrimmageButton.isChecked = false

            scrimmageTypeSelected = "Competitive"
        }
    }
}
