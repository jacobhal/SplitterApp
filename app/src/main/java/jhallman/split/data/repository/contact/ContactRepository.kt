package jhallman.split.data.repository.contact

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jacob on 2018-03-02.
 */

@Singleton
class ContactRepository @Inject constructor(private val contactDao: ContactDao) {

    fun getContacts(): LiveData<List<Contact>> {
        return contactDao.getAllContacts()
    }

    fun findContactById(contactID: Long): LiveData<Contact> {
        return contactDao.findContactById(contactID)
    }

    fun insertContact(contact: Contact): Long {
        return contactDao.insertContact(contact)
    }

    fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }

    fun upDateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

}