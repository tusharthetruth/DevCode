package `in`.devcode.main

import `in`.devcode.utils.C

class MainModel {
    lateinit var id: String
    lateinit var name: String

    companion object {
        fun getList(): ArrayList<MainModel> {
            var list = ArrayList<MainModel>()
            var m = MainModel()
            m.id = "1"
            m.name = C.YOUTUBE_UPLOAD
            list.add(m)
            var m1 = MainModel()
            m1.id = "2"
            m1.name = C.GMAIL_LOGIN
            list.add(m1)
            var m2 = MainModel()
            m2.id = "3"
            m2.name = C.FILE_DOWNLOAD
            list.add(m2)
            return list
        }
    }
}