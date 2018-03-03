package jhallman.split.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import jhallman.split.data.repository.contact.ContactDao
import jhallman.split.data.repository.purchase.PurchaseDao
import jhallman.split.data.repository.receipt.ReceiptDao
import jhallman.split.data.repository.tab.TabDao
import jhallman.split.data.repository.contact.Contact
import jhallman.split.data.repository.contact.ContactRepository
import jhallman.split.data.repository.purchase.Purchase
import jhallman.split.data.repository.purchase.PurchaseRepository
import jhallman.split.data.repository.receipt.Receipt
import jhallman.split.data.repository.receipt.ReceiptRepository
import jhallman.split.data.repository.tab.Tab
import jhallman.split.data.repository.tab.TabRepository

/**
 * Created by Jacob on 2018-02-16.
 */

@Database(entities = arrayOf(Tab::class, Receipt::class, Purchase::class, Contact::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tabDao(): TabDao
    abstract fun receiptDao(): ReceiptDao
    abstract fun purchaseDao(): PurchaseDao
    abstract fun contactDao(): ContactDao

    // Used for testing database
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database.db")
                        .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}