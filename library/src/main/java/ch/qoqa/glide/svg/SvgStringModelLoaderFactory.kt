package ch.qoqa.glide.svg

import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.load.resource.SimpleResource
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException

import java.io.IOException
import java.io.InputStream

/**
 * Decodes an SVG internal representation from an [String].
 */
class SvgStringModelLoaderFactory : ModelLoaderFactory<String, InputStream> {
    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, InputStream> {
        return object : ModelLoader<String, InputStream> {
            override fun handles(model: String) = model.contains("<svg")

            override fun buildLoadData(
                model: String,
                width: Int,
                height: Int,
                options: Options
            ): ModelLoader.LoadData<InputStream>? {
                return ModelLoader.LoadData<InputStream>(
                    Key { messageDigest -> messageDigest.update("svg_string_$model".toByteArray()) },
                    object : DataFetcher<InputStream> {
                        override fun cancel() {}

                        override fun getDataSource() = DataSource.LOCAL

                        override fun loadData(
                            priority: Priority,
                            callback: DataFetcher.DataCallback<in InputStream>
                        ) {
                            callback.onDataReady(model.byteInputStream())
                        }

                        override fun getDataClass() = InputStream::class.java

                        override fun cleanup() {}
                    })
            }
        }
    }

    override fun teardown() {

    }
}