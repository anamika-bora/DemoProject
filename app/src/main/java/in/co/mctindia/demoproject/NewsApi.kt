package `in`.co.mctindia.demoproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.reddit.com/r/kotlin/.json"
interface NewsApi {

//    @GET("news")
//    fun getNews() : Call<List<News>>
//
//    companion object {
//        operator fun invoke() : NewsApi{
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(NewsApi::class.java)
//        }
    }
