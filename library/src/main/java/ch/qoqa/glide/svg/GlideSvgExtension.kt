package ch.qoqa.glide.svg

import android.annotation.SuppressLint
import android.graphics.Bitmap
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideType

@GlideExtension
class GlideSvgExtension private constructor() {
    companion object {
        @SuppressLint("CheckResult")
        @JvmStatic
        @GlideType(Bitmap::class)
        fun asSvg(requestBuilder: RequestBuilder<Bitmap>) {
        }
    }
}