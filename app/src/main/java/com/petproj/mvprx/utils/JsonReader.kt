package com.petproj.mvprx.utils

import android.content.Context
import android.util.Log
import com.petproj.mvprx.R
import java.io.*


object JsonReader {

    private const val TAG = "JsonReader"

    fun readFile(context: Context): String {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.users)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { inputStream ->
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        val jsonString: String = writer.toString()
        Log.d(TAG, "readFile:\n$jsonString")
        return jsonString
    }
}