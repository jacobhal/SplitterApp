package jhallman.split.data.repository.purchase

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Jacob on 2018-02-16.
 */

@Dao
interface PurchaseDao {

    @Query("SELECT * FROM purchase")
    fun getAllPurchases(): LiveData<List<Purchase>>

    @Query("SELECT * FROM purchase WHERE receipt_id = (:receiptId)")
    fun findPurchasesForReceipt(receiptId: Long): LiveData<List<Purchase>>

    @Query("SELECT * FROM purchase WHERE contact_id = (:contactId)")
    fun findPurchasesForContact(contactId: Long): LiveData<List<Purchase>>

    @Query("SELECT * FROM purchase WHERE id = (:purchaseId)")
    fun findPurchaseById(purchaseId: Long): LiveData<Purchase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPurchase(purchase: Purchase): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePurchase(purchase: Purchase)

    @Delete
    fun deletePurchase(purchase: Purchase)
}