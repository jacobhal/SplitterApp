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
class PurchaseDaoTest : DatabaseTest() {

    lateinit var tab: Tab
    lateinit var receipt: Receipt
    lateinit var contact: Contact
    lateinit var purchase: Purchase

    @Before
    fun setup() {
        tab = Tab(title = "Test tab")
        val tabId = appDatabase.tabDao().insertTab(tab)
        receipt = Receipt(title = "Test receipt", tabId = tabId)
        val receiptId = appDatabase.receiptDao().insertReceipt(receipt)
        contact = Contact(name = "Jacob", phone_number = "123")
        val contactId = appDatabase.contactDao().insertContact(contact)
        purchase = Purchase(price = 100, receiptId = receiptId, contactId = contactId)
    }

    @Test
    fun insertPurchaseTest() {
        val purchaseId = appDatabase.purchaseDao().insertPurchase(purchase)
        val purchaseFromDb = appDatabase.purchaseDao().findPurchaseById(purchaseId).blockingObserve()

        assertEquals(purchaseId, 1)
        assertEquals(purchaseFromDb?.price, purchase.price)
    }

    @Test
    fun deletePurchaseTest() {
        val purchaseId = appDatabase.purchaseDao().insertPurchase(purchase)
        var purchaseFromDb = appDatabase.purchaseDao().findPurchaseById(purchaseId).blockingObserve()
        appDatabase.purchaseDao().deletePurchase(purchaseFromDb!!)
        purchaseFromDb = appDatabase.purchaseDao().findPurchaseById(purchaseId).blockingObserve()

        assertNull(purchaseFromDb)
    }
}
