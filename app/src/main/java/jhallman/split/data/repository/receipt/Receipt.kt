package jhallman.split.data.repository.receipt

import android.arch.persistence.room.*
import jhallman.split.data.repository.tab.Tab

/**
 * Created by Jacob on 2018-02-15.
 */

@Entity(tableName = "receipt",
        indices = [(Index(value = arrayOf("tab_id")))],
        foreignKeys = [(
                ForeignKey(
                        entity = Tab::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("tab_id"),
                        onDelete = ForeignKey.CASCADE
                ))])
data class Receipt(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "tab_id") val tabId: Long,
        @ColumnInfo(name = "receipt_title") val title: String)