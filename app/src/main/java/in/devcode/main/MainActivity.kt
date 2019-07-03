package `in`.devcode.main

import `in`.devcode.R
import `in`.devcode.downloadfiles.DownloadFiles
import `in`.devcode.utils.C
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICommonAdapterListener {
    override fun onClick(output: Any) {
        when (output.toString()) {
            C.FILE_DOWNLOAD -> {
                startActivity(Intent(this, DownloadFiles::class.java))
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = MainModel.getList()
        var adapter = MainAdapter(list, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
