package com.example.coderswag.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.model.Category
/**lambda in kotlin is a first class citizen which means that function behaves as a type
 * so this can be pass as an argument to another function can be returned as fun saved itno variable or
 * propety**/

class CategoryRecycleAdapter(
    val context: Context ,
    val categories : List<Category>,
    val itemClick: (Category) -> Unit

) : RecyclerView.Adapter <CategoryRecycleAdapter.Holder>() {

    inner class Holder(itemView: View , val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        /**the class that is responsible for binding */
        val categoryImage = itemView.findViewById<ImageView>(R.id.categorieImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categorieTextView)
        /**function that we can call from our onBindViewHolder to pass in the category at that position*/
        fun bindCategory(category: Category , context: Context){
            val resourceId = context.resources
                .getIdentifier(category.image, "drawable", context.packageName)
            categoryName?.text = category.title
            categoryImage?.setImageResource(resourceId)
            itemView.setOnClickListener{(itemClick(category))}
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        /**this is the methode that is called when new view holders needed FOR THE FIRST TIME */
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item,parent , false)
        return Holder(view,itemClick)

    }

    override fun getItemCount(): Int= categories.count()

    override fun onBindViewHolder(holder: Holder, p1: Int) {
        /**this is the function that is called by the recycler view to display data at the specified
         * location
         * binding : is the process of preparing a child vie to display data according to a position within the adapter**/
        holder.bindCategory(categories[p1],context)

    }
}