package `in`.co.mctindia.demoproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list_layout.view.*
import com.bumptech.glide.Glide
class NewsAdapter(var list:List<Article>):RecyclerView.Adapter <NewsAdapter.NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_layout, parent, false)
        )
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {


        val article = list[position]
       // holder.view.textViewTitle.text = article.title
        //val article=title[position]
        holder.setData(article ,position)
    }

    class NewsViewHolder(val view: View):RecyclerView.ViewHolder(view) {
        var currentArticle:Article?=null
        var currentPos:Int=0
        init{

            view.setOnClickListener {
               Toast.makeText(view.context,currentArticle!!.title,Toast.LENGTH_SHORT).show()
                val intent=Intent(view.context,FullView::class.java)
                intent.putExtra("url",currentArticle!!.url)
                val bundle: Bundle?=intent.extras
                startActivity(view.context, intent,bundle)
            }
        }
        fun setData(article:Article?,pos:Int){
            view.textViewTitle.text=article!!.title
            Glide.with(this.view.context)
                .load(article.thumbnail)
                .into(this.view.imageView)

            this.currentArticle=article

            this.currentPos = pos

        }
        //internal var title: TextView = itemView.findViewById(R.id.textViewTitle) as TextView

    }
}

