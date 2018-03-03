package jhallman.split

import android.support.test.runner.AndroidJUnit4
import jhallman.split.data.repository.contact.Contact
import jhallman.split.utils.blockingObserve

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ContactDaoTest : DatabaseTest() {

    @Test
    fun insertContactTest() {
        val contact = Contact(name = "Jacob", phone_number = "1")
        val contactId = appDatabase.contactDao().insertContact(contact)
        val contactFromDb = appDatabase.contactDao().findContactById(contactId).blockingObserve()

        assertEquals(contactId, 1)
        assertEquals(contactFromDb?.name, contact.name)
    }

    @Test
    fun deleteContactTest() {
        val contact = Contact(name = "Jacob", phone_number = "1")
        val contactId = appDatabase.contactDao().insertContact(contact)
        var contactFromDb = appDatabase.contactDao().findContactById(contactId).blockingObserve()
        appDatabase.contactDao().deleteContact(contactFromDb!!)
        contactFromDb = appDatabase.contactDao().findContactById(contactId).blockingObserve()

        assertNull(contactFromDb)
    }
}
