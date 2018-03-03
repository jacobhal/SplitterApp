package jhallman.split

import android.support.test.runner.AndroidJUnit4
import jhallman.split.data.repository.tab.Tab
import jhallman.split.utils.blockingObserve

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class TabDaoTest : DatabaseTest() {

    @Test
    fun insertTabTest() {
        val tab = Tab(title = "Test tab")
        val tabId = appDatabase.tabDao().insertTab(tab)
        val tabFromDb = appDatabase.tabDao().findTabById(tabId).blockingObserve()

        assertEquals(tabId, 1)
        assertEquals(tabFromDb?.title, tab.title)
    }

    @Test
    fun deleteTabTest() {
        val tab = Tab(title = "Test Tab")
        val tabId = appDatabase.tabDao().insertTab(tab)
        var tabFromDb = appDatabase.tabDao().findTabById(tabId).blockingObserve()
        appDatabase.tabDao().deleteTab(tabFromDb!!)
        tabFromDb = appDatabase.tabDao().findTabById(tabId).blockingObserve()

        assertNull(tabFromDb)
    }
}
