package com.qoqa.qoqa.glide.svg

import android.annotation.SuppressLint
import android.graphics.Bitmap
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade

@GlideExtension
class GlideSvgExtension private constructor() {
    companion object {
        @SuppressLint("CheckResult")
        @JvmStatic
        @GlideType(Bitmap::class)
        fun asSvg(requestBuilder: RequestBuilder<Bitmap>) {
            requestBuilder
                    .transition(withCrossFade())
                    .listener(SvgSoftwareLayerSetter())
        }
    }
}