import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.hostelmanagement.R

data class MyData(val title: String, val hostelCity: String, val hostelStreet: String, val rooms: String, val maxRooms: String)
//data class MyData(val title: String, val imageResource: Int)

class MyGridAdapter(private val context: Context, private val data: List<MyData>) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.grid_item, parent, false)

        val titleTextView = view.findViewById<TextView>(R.id.tv_gridItem_title)
        titleTextView.text = data[position].title

        val cityTextView = view.findViewById<TextView>(R.id.tv_gridItem_city)
        cityTextView.text = data[position].hostelCity

        val streetTextView = view.findViewById<TextView>(R.id.tv_gridItem_street)
        streetTextView.text = data[position].hostelStreet

        val roomsTextView = view.findViewById<TextView>(R.id.tv_gridItem_rooms)
        roomsTextView.text = data[position].rooms

        val maxRoomsTextView = view.findViewById<TextView>(R.id.tv_gridItem_maxRooms)
        maxRoomsTextView.text = data[position].maxRooms

//        val imageView = view.findViewById<ImageView>(R.id.image_view)
//        imageView.setImageResource(data[position].imageResource)

        return view
    }
}