package com.libraryspring.library.service;

import com.libraryspring.library.domain.ContactMessage;
import com.libraryspring.library.exception.ResourceNotFoundException;
import com.libraryspring.library.exception.message.ErrorMessage;
import com.libraryspring.library.repository.ContactMessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }



    public void saveMessage(ContactMessage contactMessage) {

        contactMessageRepository.save(contactMessage);

    }

    public List<ContactMessage> getAll() {

        return contactMessageRepository.findAll();

    }


    public Page<ContactMessage> getAllPage(Pageable pageable) {

        return contactMessageRepository.findAll(pageable);

    }

    public ContactMessage getContactMessage(Long id) {

        return contactMessageRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND_EXCEPTION));

    }

    public void deleteContactMessage(Long id) {
        ContactMessage contactMessage = getContactMessage(id);
        contactMessageRepository.delete(contactMessage);

    }

    public void updateContactMessage(Long id, ContactMessage contactMessage) {
        ContactMessage contactMessage1 = getContactMessage(id);

        contactMessage1.setName(contactMessage.getName());
        contactMessage1.setBody(contactMessage.getBody());
        contactMessage1.setEmail(contactMessage.getEmail());
        contactMessage1.setSubject(contactMessage.getSubject());

        contactMessageRepository.save(contactMessage1);
    }
}
