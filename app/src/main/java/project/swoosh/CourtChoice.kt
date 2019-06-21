package project.swoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CourtChoice : BaseActivity() {

    var scrimmage = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_court_choice)

        scrimmage = intent.getStringExtra(EXTRA_SCRIMMAGE)
        print(scrimmage)
    }
}
