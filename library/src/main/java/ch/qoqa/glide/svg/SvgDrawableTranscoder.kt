package ch.qoqa.glide.svg

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder
import com.caverock.androidsvg.SVG

class SvgDrawableTranscoder(private val context: Context) : ResourceTranscoder<SVG, Drawable> {
    private val bitmapTranscoder = SvgBitmapTranscoder()

    override fun transcode(toTranscode: Resource<SVG>, options: Options): Resource<Drawable> {
        val bitmap = bitmapTranscoder.transcode(toTranscode, options).get()

        return SimpleResource(BitmapDrawable(context.resources, bitmap))
    }
}
