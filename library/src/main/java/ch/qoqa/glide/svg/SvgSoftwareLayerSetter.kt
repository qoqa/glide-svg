package com.qoqa.qoqa.glide.svg

import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.ImageViewTarget
import com.bumptech.glide.request.target.Target

/**
 * Listener which updates the [ImageView] to be software rendered,
 * because [SVG][com.caverock.androidsvg.SVG]/[Picture][android.graphics.Picture]
 * can't render on a hardware backed [Canvas][android.graphics.Canvas].
 *
 * @param <T> not used, here to prevent unchecked warnings at usage
</T> */
class SvgSoftwareLayerSetter<T> : RequestListener<T> {
    override fun onResourceReady(resource: T, model: Any, target: Target<T>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
        val view = (target as ImageViewTarget<*>).view
        view.setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null)
        return false
    }

    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<T>, isFirstResource: Boolean): Boolean {
        val view = (target as ImageViewTarget<*>).view
        view.setLayerType(ImageView.LAYER_TYPE_NONE, null)
        return false
    }
}