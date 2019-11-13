package ch.qoqa.sample

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class SampleAppGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled() = false

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)

        builder?.setLogLevel(Log.DEBUG)
    }
}