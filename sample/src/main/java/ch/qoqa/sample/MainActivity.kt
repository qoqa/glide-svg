package ch.qoqa.sample

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        // TODO add example with bitmap
        val images = listOf(
                Images {
                    GlideApp.with(this)
                            .load("https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/android.svg?1")
                            .into(it)
                },
                Images {
                    it.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP)
                    GlideApp.with(this)
                            .load("https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/android.svg?2")
                            .into(it)
                }
        )

        sample_images.adapter = object : BaseAdapter() {
            override fun getItem(position: Int) = images[position]
            override fun getItemId(position: Int) = position.toLong()
            override fun getCount() = images.size

            @SuppressLint("ViewHolder")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
                val view = layoutInflater.inflate(R.layout.item_image, parent, false) ?: return null

                getItem(position).block(view.findViewById(R.id.sample_image_view))

                return view
            }
        }


    }

    data class Images(val block: (ImageView) -> Unit)
}
