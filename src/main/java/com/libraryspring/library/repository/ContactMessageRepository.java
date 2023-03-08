package com.libraryspring.library.repository;

import com.libraryspring.library.domain.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
