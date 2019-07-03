package `in`.devcode.main

class MainModel {
    lateinit var id: String
    lateinit var name: String

    companion object {
        fun getList(): ArrayList<MainModel> {
            var list = ArrayList<MainModel>()
            var m = MainModel()
            m.id = "1"
            m.name = "Youtube Upload"
            list.add(m)
            var m1 = MainModel()
            m1.id = "2"
            m1.name = "Gmail Login"
            list.add(m1)
            return list
        }
    }
}