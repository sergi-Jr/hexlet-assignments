package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO data) {
        Contact entity = toEntity(data);
        contactRepository.save(entity);
        return toDTO(entity);
    }

    private Contact toEntity(ContactCreateDTO data) {
        Contact contact = new Contact();
        contact.setPhone(data.getPhone());
        contact.setFirstName(data.getFirstName());
        contact.setLastName(data.getLastName());
        return contact;
    }

    private ContactDTO toDTO(Contact data) {
        ContactDTO dto = new ContactDTO();
        dto.setId(data.getId());
        dto.setPhone(data.getPhone());
        dto.setLastName(data.getLastName());
        dto.setFirstName(data.getFirstName());
        dto.setUpdatedAt(data.getUpdatedAt());
        dto.setCreatedAt(data.getCreatedAt());
        return dto;
    }
    // END
}
