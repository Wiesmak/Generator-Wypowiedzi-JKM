package pl.ninjaskawina.jkmgenerator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        //get the quote from intent
        val quote = intent.getStringExtra("quote");

        //set textview as a quote
        findViewById<TextView>(R.id.title).text = quote;

        //finish activity on restart button
        val restart = findViewById<FloatingActionButton>(R.id.restart)
        restart.setOnClickListener{
            finish();
        }

        //share quote on share button
        val share = findViewById<FloatingActionButton>(R.id.share)
        share.setOnClickListener {
            val string = "$quote\n~Janusz Korwin-Mikke"
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "$string"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Korwin Mikke")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Udostępnij przez"))
        }
    }
}
