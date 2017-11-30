package ch.qoqa.sample

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        sample_image_view.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP)

        GlideApp.with(this)
                .asSvg()
                .load("https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/android.svg")
                .into(sample_image_view)
    }
}
