package com.libraryspring.library.controller;

import com.libraryspring.library.domain.ContactMessage;
import com.libraryspring.library.dto.ContactMessageDTO;
import com.libraryspring.library.dto.request.ContactMessageRequest;
import com.libraryspring.library.dto.response.LbResponse;
import com.libraryspring.library.mapper.ContactMessageMapper;
import com.libraryspring.library.repository.ContactMessageRepository;
import com.libraryspring.library.service.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageController(ContactMessageService contactMessageService, ContactMessageMapper contactMessageMapper) {
        this.contactMessageService = contactMessageService;
        this.contactMessageMapper = contactMessageMapper;
    }

    // Create Contact Message
    @PostMapping("/visitors")
    public ResponseEntity<LbResponse> createMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest){

        ContactMessage contactMessage =
                contactMessageMapper.contactMessageRequestToContactMessage(contactMessageRequest);
        contactMessageService.saveMessage(contactMessage);

        LbResponse response = new LbResponse("Contact Message successfully created", true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // Get All Contact Messages
    @GetMapping
    public ResponseEntity<List<ContactMessageDTO>> getAllContactMessage(){
        List<ContactMessage> contactMessageList = contactMessageService.getAll();

        List<ContactMessageDTO> contactMessageDTOList = contactMessageMapper.mapDto(contactMessageList);

        return ResponseEntity.ok(contactMessageDTOList);

    }


}
