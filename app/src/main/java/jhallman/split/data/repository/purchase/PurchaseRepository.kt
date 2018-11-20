package jhallman.split.data.repository.purchase

import android.arch.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jacob on 2018-03-02.
 */

@Singleton
class PurchaseRepository @Inject constructor(private val purchaseDao: PurchaseDao) {

    fun getPurchases(): LiveData<List<Purchase>> {
        return purchaseDao.getAllPurchases()
    }

    fun findPurchaseById(purchaseID: Long): LiveData<Purchase> {
        return purchaseDao.findPurchaseById(purchaseID)
    }

    fun findPurchasesForReceipt(receiptId: Long): LiveData<List<Purchase>> {
        return purchaseDao.findPurchasesForReceipt(receiptId)
    }

    fun findPurchasesForContact(contactId: Long): LiveData<List<Purchase>> {
        return purchaseDao.findPurchasesForContact(contactId)
    }

    fun insertPurchase(purchase: Purchase): Long {
        return purchaseDao.insertPurchase(purchase)
    }

    fun deletePurchase(purchase: Purchase) {
        purchaseDao.deletePurchase(purchase)
    }

    fun upDatePurchase(purchase: Purchase) {
        purchaseDao.updatePurchase(purchase)
    }

}