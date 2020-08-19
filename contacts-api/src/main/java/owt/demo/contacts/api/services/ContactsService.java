package owt.demo.contacts.api.services;

import org.springframework.stereotype.Service;
import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.model.Contact;

import java.net.URI;
import java.util.List;

@Service
public interface ContactsService {

    List<Contact> getContacts();

    Contact getContactById(Long id) throws NotFoundException;

    URI saveContact(Contact contact);
}
