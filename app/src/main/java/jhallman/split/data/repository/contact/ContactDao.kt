package jhallman.split.data.repository.contact

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Jacob on 2018-02-16.
 */

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contact WHERE id = (:contactID)")
    fun findContactById(contactID: Long): LiveData<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}