package `in`.co.mctindia.demoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

     var list=ArrayList<Article>()
   // private var title = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* NewsApi().getNews().enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                val movies = response.body()

                movies?.let {
                    showNews(it)
                }
            }
        })*/

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        // set a LinearLayoutManager with default vertical orientation
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        try {
            // since we have JSON object, so we are getting the object
            //here we are calling a function and that function is returning the JSON object
            val obj = JSONObject(loadJSONFromAsset())
            // fetch JSONArray named users by using getJSONArray
            val dataObj = obj.getJSONObject("data")

            var dataArray = dataObj.getJSONArray("children")
            // implement for loop for getting users data i.e. name, email and contact
            for (i in 0 until dataArray.length()) {
                // create a JSONObject for fetching single user data
                val children = dataArray.getJSONObject(i);
                var data = children.getJSONObject("data")
                // fetch email and name and store it in arraylist
                var article=Article(data.getString("title"),data.getString("thumbnail"),data.getString("url"))
                list.add(article)

            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        //  call the constructor of MyAdapter to send the reference and data to Adapter
        val customAdapter = NewsAdapter( list)
        recyclerView.adapter = customAdapter // set the Adapter to RecyclerView

    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val `is` = assets.open("articles.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
    }

    /*private fun showNews(news: List<News>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NewsAdapter(news)
    }*/


