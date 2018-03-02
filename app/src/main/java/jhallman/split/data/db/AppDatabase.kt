package jhallman.split.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import jhallman.split.data.repository.contact.ContactDao
import jhallman.split.data.repository.purchase.PurchaseDao
import jhallman.split.data.repository.receipt.ReceiptDao
import jhallman.split.data.repository.tab.TabDao
import jhallman.split.data.repository.contact.Contact
import jhallman.split.data.repository.purchase.Purchase
import jhallman.split.data.repository.receipt.Receipt
import jhallman.split.data.repository.tab.Tab

/**
 * Created by Jacob on 2018-02-16.
 */

@Database(entities = arrayOf(Tab::class, Receipt::class, Purchase::class, Contact::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tabDao(): TabDao
    abstract fun receiptDao(): ReceiptDao
    abstract fun purchaseDao(): PurchaseDao
    abstract fun contactDao(): ContactDao
}