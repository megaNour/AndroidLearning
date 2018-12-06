package fundamentals.androit.nour.com.implicitintents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val LOG_TAG = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openWebsite(view: View) {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse(website_editText.text.toString()))
        intent.resolveActivity(packageManager)?.let { startActivity(intent) }
            ?: Log.d(LOG_TAG, getString(R.string.unhandled_Intent))
    }
    fun openLocation(view: View) {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse( getString(R.string.geoSearchQuery) + location_editText.text.toString()))
        intent.resolveActivity(packageManager)?.let { startActivity(intent) }
            ?: Log.d(LOG_TAG, getString(R.string.unhandled_Intent))
    }
    fun shareText(view: View) {
        ShareCompat.IntentBuilder
            .from(this)
            .setType(getString(R.string.mime_text))
            .setChooserTitle(getString(R.string.share_with_header))
            .setText(share_editText.text.toString())
            .startChooser()
    }
}
