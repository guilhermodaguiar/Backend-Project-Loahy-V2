package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.ContactRemarkDto;
import nl.novi.loahy.services.ContactRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/contact-remarks")
public class ContactRemarkController {

    @Autowired
    private final ContactRemarkService contactRemarkService;

    @Autowired
    public ContactRemarkController(ContactRemarkService contactRemarkService) {
        this.contactRemarkService = contactRemarkService;
    }

    @GetMapping()
    public ResponseEntity<List<ContactRemarkDto>> getAllContacts() {

        List<ContactRemarkDto> contactRemarkDtos = contactRemarkService.getAllContacts();

        return ResponseEntity.ok().body(contactRemarkDtos);
    }

    @GetMapping(value = "/{contactName}")
    public ResponseEntity<ContactRemarkDto> getContact(@PathVariable("contactName") String contactName) {

        ContactRemarkDto optionalContact = contactRemarkService.getContactByName(contactName);


        return ResponseEntity.ok().body(optionalContact);

    }

    @PostMapping(value = "")
    public ResponseEntity<ContactRemarkDto> createRemark(@RequestBody ContactRemarkDto contactRemarkDto) {

        final String createdContact = contactRemarkService.createRemark(contactRemarkDto);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{contactName}")
                .buildAndExpand(createdContact).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(value = "/{contactName}")
    public ResponseEntity<ContactRemarkDto> deleteContact(@PathVariable("contactName") String contactName) {
        contactRemarkService.deleteContact(contactName);
        return ResponseEntity.noContent().build();
    }

}
