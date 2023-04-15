package com.hostelmanagement.home

import MyData
import MyGridAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.hostelmanagement.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var gridView: GridView

    private lateinit var listView: ListView
    private val items = arrayListOf(
        ListViewItem("Title 1", "Subtitle 1"),
        ListViewItem("Title 2", "Subtitle 2"),
        ListViewItem("Title 3", "Subtitle 3"),
        ListViewItem("Title 4", "Subtitle 4"),
        ListViewItem("Title 5", "Subtitle 5")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        gridView = view.findViewById(R.id.gv_hostelsPanels)
        listView = view.findViewById(R.id.lv_hosteNotifications)

        val adapterListView = object : ArrayAdapter<ListViewItem>(requireContext(), 0, items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_listview_item, parent, false)

                // Get the custom item for this position
                val item = items[position]

                // Set the title and subtitle on the TextViews
                view.findViewById<TextView>(R.id.item_title).text = item.title
                view.findViewById<TextView>(R.id.item_subtitle).text = item.subtitle

                return view
            }
        }
        listView.adapter = adapterListView

        val adapterGridView = MyGridAdapter(requireContext(), getData())
        gridView.adapter = adapterGridView

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(activity,"pressed: "+position, Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun getData(): List<MyData> {
        // return data for the grid view adapter
        return listOf(
            //entering data to list
            MyData("Item 1", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 2", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 3", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 4", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 5", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 6", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 7", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 8", "Lodz", "jakastam 14", "5", "20"),
            MyData("Item 9", "Lodz", "jakastam 14", "5", "20")
        )
    }
}