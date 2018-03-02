package jhallman.split.data.repository.tab

import android.arch.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jacob on 2018-03-02.
 */

@Singleton
class TabRepository @Inject constructor(private val tabDao: TabDao) {

    fun getTabs(): LiveData<List<Tab>> {
        return tabDao.getAllTabs()
    }

    fun getTab(tabID: Long): LiveData<Tab> {
        return tabDao.findTabById(tabID)
    }

    fun insertTab(tab: Tab) {
        tabDao.insertTab(tab)
    }

    fun deleteTab(tab: Tab) {
        tabDao.deleteTab(tab)
    }

    fun upDateTab(tab: Tab) {
        tabDao.updateTab(tab)
    }

}