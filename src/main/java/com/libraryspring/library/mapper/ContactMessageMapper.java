package com.libraryspring.library.mapper;

import com.libraryspring.library.domain.ContactMessage;
import com.libraryspring.library.dto.ContactMessageDTO;
import com.libraryspring.library.dto.request.ContactMessageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMessageMapper {

    // ContactMessage -> ContactMessageDTO
    ContactMessageDTO contactMessageToDTO(ContactMessage contactMessage);

    // ContactMessageRequest -> ContactMessage
    @Mapping(target = "id", ignore = true)
    ContactMessage contactMessageRequestToContactMessage(ContactMessageRequest contactMessageRequest);
}
