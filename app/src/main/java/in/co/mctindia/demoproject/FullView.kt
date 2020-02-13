package `in`.co.mctindia.demoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_full_view.*
import android.content.Intent
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.TextView



class FullView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_view)

        val bundle:Bundle?=intent.extras
        val url=bundle!!.getString("url")
        txvUrl.text = url

        val txt = findViewById(R.id.txvUrl) as TextView //txt is object of TextView
        Linkify.addLinks(txt,Linkify.WEB_URLS)

    }
}
