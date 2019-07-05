package `in`.devcode.downloadfiles

import `in`.devcode.R
import `in`.devcode.utils.FileUtil
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_download_files.*

class DownloadFiles : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.getId()) {
            R.id.download -> {

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_files)
        download.setOnClickListener(this)

    }

    class FileDownload : AsyncTask<String, String, String>() {
        var gmailUrl:String = ""
        var facebookImageUrl:String = ""
        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }

        override fun onCancelled(result: String?) {
            super.onCancelled(result)
        }

        override fun onCancelled() {
            super.onCancelled()
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String {
            var output = ""
            output = HttpDownloadEntity.downloadFile(gmailUrl, FileUtil.getAppDir())
            return output
        }

    }
}
