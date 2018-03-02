package jhallman.split.data.repository.tab

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Jacob on 2018-02-15.
 */

@Entity(tableName = "tab")
data class Tab(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "tab_title") val title: String,
        @ColumnInfo(name = "tab_status") val status: String = STATUS.RUNNING)
{
    object STATUS {
        const val RUNNING = "RUNNING"
        const val AWAITING_PAYMENT = "AWAITING_PAYMENT"
    }
}