package owt.demo.contacts.api.services;

import org.springframework.stereotype.Service;
import owt.demo.contacts.model.Contact;

import java.util.List;

@Service
public interface ContactsService {

    List<Contact> getContacts();
}
