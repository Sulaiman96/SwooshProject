package project.swoosh

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scrimmage_details.*

class ScrimmageDetails : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrimmage_details)

        nextButton.setOnClickListener(){
            val scrimmageIntent = Intent(this, CourtChoice::class.java)
            startActivity(scrimmageIntent)
        }
    }
}
