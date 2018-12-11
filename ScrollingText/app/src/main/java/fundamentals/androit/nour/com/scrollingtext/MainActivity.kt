package fundamentals.androit.nour.com.scrollingtext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(article_content)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_edit -> toastIt(getString(R.string.action_edit))
            R.id.action_share -> toastIt(getString(R.string.action_share))
            R.id.action_delete -> toastIt(getString(R.string.action_delete))
            else -> {
                return super.onContextItemSelected(item)
            }
        }
    }

    private fun toastIt(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}
