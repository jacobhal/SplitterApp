package jhallman.split.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import jhallman.split.data.repository.receipt.Receipt
import jhallman.split.data.repository.receipt.ReceiptDao
import jhallman.split.data.repository.receipt.ReceiptRepository
import javax.inject.Inject


/**
 * Created by Jacob on 2018-02-18.
 * Acts as a bridge between the View and the Model
 * Requests/aggregates data from the Model, and transforms it for the View
 */

class ReceiptCollectionViewModel @Inject constructor (val receiptRepository: ReceiptRepository) : ViewModel() {

    fun getReceipts(): LiveData<List<Receipt>> {
        return receiptRepository.getReceipts()
    }
}