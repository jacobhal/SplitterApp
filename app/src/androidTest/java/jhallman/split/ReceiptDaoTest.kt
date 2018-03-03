package jhallman.split

import android.support.test.runner.AndroidJUnit4
import jhallman.split.data.repository.contact.Contact
import jhallman.split.data.repository.purchase.Purchase
import jhallman.split.data.repository.receipt.Receipt
import jhallman.split.data.repository.tab.Tab
import jhallman.split.utils.blockingObserve

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class ReceiptDaoTest : DatabaseTest() {

    lateinit var tab: Tab
    lateinit var receipt: Receipt
    lateinit var contact: Contact
    lateinit var purchase: Purchase

    @Before
    fun setup() {
        tab = Tab(title = "Test tab")
        val tabId = appDatabase.tabDao().insertTab(tab)
        receipt = Receipt(title = "Test receipt", tabId = tabId)
    }

    @Test
    fun insertReceiptTest() {
        val receiptId = appDatabase.receiptDao().insertReceipt(receipt)
        val receiptFromDb = appDatabase.receiptDao().findReceiptById(receiptId).blockingObserve()

        assertEquals(receiptId, 1)
        assertEquals(receiptFromDb?.title, receipt.title)
    }

    @Test
    fun deleteReceiptTest() {
        val receiptId = appDatabase.receiptDao().insertReceipt(receipt)
        var receiptFromDb = appDatabase.receiptDao().findReceiptById(receiptId).blockingObserve()
        appDatabase.receiptDao().deleteReceipt(receiptFromDb!!)
        receiptFromDb = appDatabase.receiptDao().findReceiptById(receiptId).blockingObserve()

        assertNull(receiptFromDb)
    }

}
