package owt.demo.contacts.api.services;

import owt.demo.contacts.api.exceptions.NotFoundException;
import owt.demo.contacts.model.Contact;
import owt.demo.contacts.model.SkillLevel;
import owt.demo.contacts.model.SkilledContact;

import java.net.URI;
import java.util.List;

public interface ContactsService {

    List<Contact> getContacts();

    Contact getContactById(Long id) throws NotFoundException;

    URI saveContact(Contact contact);

    List<SkillLevel> getSkillsById(Long contactId) throws NotFoundException;

    SkilledContact addSkillToContact(Long contactId, SkillLevel skill) throws NotFoundException;
}
