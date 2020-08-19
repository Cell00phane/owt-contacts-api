package owt.demo.contacts.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.api.utils.DTOConverter;
import owt.demo.contacts.model.Contact;
import owt.demo.contacts.model.ContactEntity;
import owt.demo.contacts.repository.ContactRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsServiceImplementation implements ContactsService{

    Logger logger = LoggerFactory.getLogger(ContactsServiceImplementation.class);

    @Autowired
    ContactRepository contactRepository;


    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        for (ContactEntity contactEntity: contactRepository.findAll()) {
            contacts.add(DTOConverter.ContactEntityToDTO(contactEntity));
        }

        return contacts;
    }

    @Override
    public Contact getContactById(Long id) throws NotFoundException {
        ContactEntity contactEntity = contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No contact found with id "+ id));

        logger.info("Contact found");
        
        return DTOConverter.ContactEntityToDTO(contactEntity);
    }

    @Override
    public URI saveContact(Contact contact) {
        ContactEntity contactEntity = DTOConverter.ContactDTOToEntity(contact);
        contactRepository.save(contactEntity);

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(contactEntity.getContactId()).toUri();
    }
}
