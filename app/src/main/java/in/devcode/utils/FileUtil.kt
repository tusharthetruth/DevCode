package `in`.devcode.utils

import android.os.Environment
import java.io.File
import java.util.*

class FileUtil {
    companion object {
        var APP_NAME = "DEVCODE"
        fun getPath(): String {
            var path: String = Environment.getExternalStorageDirectory().absolutePath + File.pathSeparator + APP_NAME;
            var dir = File(path)
            if (!dir.exists()) {
                dir.mkdir()
            }
            var path1: String = dir.absolutePath + File.pathSeparator + Calendar.getInstance().timeInMillis;
            var out = File(path1)
            if (!out.exists())
                out.createNewFile();
            return out.absolutePath
        }
    }
}