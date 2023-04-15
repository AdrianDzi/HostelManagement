//package com.hostelmanagement.home
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import com.hostelmanagement.R
//
//class GridAdapter(private val context: Context, private val imageIds: IntArray) : BaseAdapter() {
//
//    private val inflater: LayoutInflater = LayoutInflater.from(context)
//
//    override fun getCount(): Int {
//        return imageIds.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return imageIds[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var view = convertView
//        val holder: ViewHolder
//
//        if (view == null) {
//            view = inflater.inflate(R.layout.grid_item, parent, false)
//            holder = ViewHolder()
//            if (view != null) {
//                holder.imageView = view.findViewById(R.id.image_view)
//            }
//            view.tag = holder
//        } else {
//            holder = view.tag as ViewHolder
//        }
//
//        holder.imageView.setImageResource(imageIds[position])
//
//        return view!!
//    }
//
//    private class ViewHolder {
//        lateinit var imageView: ImageView
//    }
//}