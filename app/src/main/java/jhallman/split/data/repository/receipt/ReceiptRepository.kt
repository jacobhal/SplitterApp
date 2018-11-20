package jhallman.split.data.repository.receipt

import android.arch.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jacob on 2018-03-02.
 */

@Singleton
class ReceiptRepository @Inject constructor(private val receiptDao: ReceiptDao) {

    fun getReceipts(): LiveData<List<Receipt>> {
        return receiptDao.getAllReceipts()
    }

    fun findReceiptById(receiptID: Long): LiveData<Receipt> {
        return receiptDao.findReceiptById(receiptID)
    }

    fun findReceiptsForTab(tabId: Long): LiveData<List<Receipt>> {
        return receiptDao.findReceiptsForTab(tabId)
    }

    fun insertReceipt(receipt: Receipt): Long {
        return receiptDao.insertReceipt(receipt)
    }

    fun deleteReceipt(receipt: Receipt) {
        receiptDao.deleteReceipt(receipt)
    }

    fun upDateReceipt(receipt: Receipt) {
        receiptDao.updateReceipt(receipt)
    }

}