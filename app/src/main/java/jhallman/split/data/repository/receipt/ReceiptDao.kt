package jhallman.split.data.repository.receipt

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Jacob on 2018-02-16.
 */

@Dao
interface ReceiptDao {

    @Query("SELECT * FROM receipt")
    fun getAllReceipts(): LiveData<List<Receipt>>

    @Query("SELECT * FROM receipt WHERE id = (:receiptID)")
    fun findReceiptById(receiptID: Long): LiveData<Receipt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReceipt(receipt: Receipt): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReceipt(receipt: Receipt)

    @Delete
    fun deleteReceipt(receipt: Receipt)
}