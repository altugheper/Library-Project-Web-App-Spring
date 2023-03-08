package com.libraryspring.library.controller;

import com.libraryspring.library.domain.ContactMessage;
import com.libraryspring.library.dto.request.ContactMessageRequest;
import com.libraryspring.library.dto.response.LbResponse;
import com.libraryspring.library.mapper.ContactMessageMapper;
import com.libraryspring.library.repository.ContactMessageRepository;
import com.libraryspring.library.service.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageController(ContactMessageService contactMessageService, ContactMessageMapper contactMessageMapper) {
        this.contactMessageService = contactMessageService;
        this.contactMessageMapper = contactMessageMapper;
    }

    @PostMapping("/visitors")
    public ResponseEntity<LbResponse> createMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest){

        ContactMessage contactMessage =
                contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);
        contactMessageService.saveMessage(contactMessage);

        LbResponse response = new LbResponse("Contact Message successfully created", true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
