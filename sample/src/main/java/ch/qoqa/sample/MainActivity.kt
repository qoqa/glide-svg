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
import ch.qoqa.sample.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

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
            },
            Images {
                it.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP)
                GlideApp.with(this)
                    .load("<svg height=\"100\" width=\"100\" viewBox=\"0 0 100 100\"><circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"black\" stroke-width=\"3\" fill=\"red\" /></svg> ")
                    .into(it)
            },
            Images {
                it.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
                GlideApp.with(this)
                    .load("<svg height=\"100\" width=\"100\"><circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"black\" stroke-width=\"3\" fill=\"red\" /></svg> ")
                    .into(it)
            }
        )

        binding.sampleImages.adapter = object : BaseAdapter() {
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
