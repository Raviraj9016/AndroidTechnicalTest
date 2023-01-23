package com.example.androidtechnicaltest

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter (
    private var products: ArrayList<Product>,
    private var books: ArrayList<Book>
    ):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val VIEW_PRODUCT = 1
    val VIEW_BOOK = 2



    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imgProduct: ImageView
        var txtProductTitle: TextView
        var txtProductId: TextView
        var txtProductPrice: TextView
        init {
            imgProduct = itemView.findViewById(R.id.imgProduct)
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle)
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice)
            txtProductId =itemView.findViewById(R.id.txtProductId)

        }
    }
    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtBookId: TextView
        var txtBookPrice: TextView
        var txtBookTitle: TextView
        var txtBookDescription: TextView
        init {
            txtBookId = itemView.findViewById(R.id.txtBookId)
            txtBookPrice = itemView.findViewById(R.id.txtBookPrice)
            txtBookTitle = itemView.findViewById(R.id.txtBookTitle)
            txtBookDescription = itemView.findViewById(R.id.txtBookDescription)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        if (viewType == VIEW_PRODUCT ){
            var productView: View = layoutInflater.inflate(R.layout.product_view,null)
            return ProductViewHolder(productView)
        }
            var bookView: View = layoutInflater.inflate(R.layout.book_view,null)
            return BookViewHolder(bookView)

    }
    override fun getItemViewType(position: Int): Int {
        if ((position+1)%4 == 0){
            return VIEW_BOOK
        }
        return VIEW_PRODUCT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            var product = products[position - position / 4]
            holder.txtProductTitle.text = product.title
            holder.txtProductPrice.text = "Rs.${product.price}"
            holder.txtProductId.text = product.id.toString()
        }
        if (holder is BookViewHolder) {
            var bookPosition = (position + 1) / 4 - 1
            if (bookPosition >= books.size) {
                bookPosition = bookPosition % 6
            }
            var book = books[bookPosition]

            holder.txtBookId.text = book.id.toString()
            holder.txtBookTitle.text = book.title
            holder.txtBookPrice.text = book.price.toString()
            holder.txtBookDescription.text = book.description

        }

    }

    override fun getItemCount(): Int {
        return products.size + books.size


    }


}