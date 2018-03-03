package jhallman.split.data.repository.purchase

import android.arch.persistence.room.*
import jhallman.split.data.repository.receipt.Receipt
import jhallman.split.data.repository.contact.Contact

/**
 * Created by Jacob on 2018-02-15.
 */

@Entity(tableName = "purchase",
        indices = [(Index(value = arrayOf("contact_id"))), (Index(value = arrayOf("receipt_id")))],
        foreignKeys = [
            ForeignKey(
                    entity = Receipt::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("receipt_id"),
                    onDelete = ForeignKey.CASCADE),
            ForeignKey(
                    entity = Contact::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("contact_id"))
        ])
data class Purchase(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "receipt_id") val receiptId: Long,
        @ColumnInfo(name = "contact_id") val contactId: Long,
        @ColumnInfo(name = "purchase_price") val price: Int)