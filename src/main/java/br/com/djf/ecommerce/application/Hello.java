package br.com.djf.ecommerce.application;

import br.com.djf.ecommerce.core.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Hello {

    @GetMapping("contacts")
    public List<Contact> findAll(){
        return List.of(
                Contact.builder().name("João").build(),
                Contact.builder().name("Pedro").build(),
                Contact.builder().name("Maria").build()
                );
    }
}
