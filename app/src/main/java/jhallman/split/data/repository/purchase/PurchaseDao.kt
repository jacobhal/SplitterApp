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

    @Query("SELECT * FROM purchase WHERE id = (:purchaseID)")
    fun findPurchaseById(purchaseID: Long): LiveData<Purchase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPurchase(purchase: Purchase)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePurchase(purchase: Purchase)

    @Delete
    fun deletePurchase(purchase: Purchase)
}