package project.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_court_choice.*
import project.swoosh.Model.Player
import project.swoosh.R
import project.swoosh.Utilities.EXTRA_PLAYER

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CourtChoice : BaseActivity() {

    lateinit var player : Player

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
        setContentView(R.layout.activity_court_choice)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

        playButton.setOnClickListener(){
            if(player.courtType != "" && player.level != ""){
                val courtAndLevelIntent = Intent(this, FinishActivity::class.java)
                courtAndLevelIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(courtAndLevelIntent)
            }else{
                Toast.makeText(this, "Please Select all of the options", Toast.LENGTH_SHORT).show()
            }
        }

        indoorButton.setOnClickListener(){
            outdoorButton.isChecked = false

            player.courtType = "indoor"
        }

        outdoorButton.setOnClickListener(){
            indoorButton.isChecked = false

            player.courtType = "outdoor"
        }

        beginnerButton.setOnClickListener(){
            averageButton.isChecked = false
            ballerButton.isChecked = false

            player.level = "beginner"
        }

        averageButton.setOnClickListener(){
            beginnerButton.isChecked = false
            ballerButton.isChecked = false

            player.level = "average"
        }

        ballerButton.setOnClickListener(){
            beginnerButton.isChecked = false
            averageButton.isChecked = false

            player.level = "baller"
        }

    }

}
