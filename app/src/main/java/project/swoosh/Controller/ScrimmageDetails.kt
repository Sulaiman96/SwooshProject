package project.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_scrimmage_details.*
import project.swoosh.Model.Player
import project.swoosh.R
import project.swoosh.Utilities.EXTRA_PLAYER

class ScrimmageDetails : BaseActivity() {

    var scrimmageTypeSelected = ""
    var player = Player("", "", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrimmage_details)

        nextButton.setOnClickListener() {
            if(player.scrimmageType != ""){
                val scrimmageIntent = Intent(this, CourtChoice::class.java)
                scrimmageIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(scrimmageIntent)
            }else{
                Toast.makeText(this, "Please Select a scrimmage type", Toast.LENGTH_SHORT).show()
            }
        }

        casualScrimmageButton.setOnClickListener() {
            semiCompetitiveButton.isChecked = false
            competitiveButton.isChecked = false

            player.scrimmageType = "Casual"
        }

        semiCompetitiveButton.setOnClickListener() {
            casualScrimmageButton.isChecked = false
            competitiveButton.isChecked = false

            player.scrimmageType = "Semi Competitive"
        }

        competitiveButton.setOnClickListener() {
            semiCompetitiveButton.isChecked = false
            casualScrimmageButton.isChecked = false

            player.scrimmageType = "Competitive"
        }
    }

}
