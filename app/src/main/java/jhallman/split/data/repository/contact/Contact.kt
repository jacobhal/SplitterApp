package jhallman.split.data.repository.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Jacob on 2018-02-15.
 */

@Entity(tableName = "contact")
data class Contact(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "contact_name") val name: String,
        @ColumnInfo(name = "contact_phone_number") val phone_number: String)