package com.example.backend.services;


import com.example.backend.controllers.EmailController;
import com.example.backend.exceptions.RequiredObjectIsNullException;
import com.example.backend.exceptions.ResourceNotFoundException;
import com.example.backend.mapper.DozerMapper;
import com.example.backend.models.Email;
import com.example.backend.repositories.EmailRepository;
import com.example.backend.vo.EmailVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmailService {
    private final EmailRepository repository;

    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public List<EmailVO> findAll() {
        List<Email> emailDbList = repository.findAll();
        List<EmailVO> emails = DozerMapper.parseListObject(emailDbList, EmailVO.class);
        emails.forEach(emailVO -> {
            try {
                emailVO.add(linkTo(methodOn(EmailController.class).findById(emailVO.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return emails;
    }

    public EmailVO findById(Long id) {
        Email email = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        EmailVO emailVO = DozerMapper.parseObject(email, EmailVO.class);
        emailVO.add(linkTo(methodOn(EmailController.class).findById(id)).withSelfRel());
        emailVO.add(linkTo(methodOn(EmailController.class).update(emailVO)).withSelfRel());
        emailVO.add(linkTo(methodOn(EmailController.class).delete(id)).withSelfRel());
        return emailVO;
    }

    public EmailVO save(EmailVO emailVO) {
        if (emailVO == null) throw new RequiredObjectIsNullException();
        Email email = DozerMapper.parseObject(emailVO, Email.class);
        Email emailDb = repository.save(email);
        emailVO = DozerMapper.parseObject(emailDb, EmailVO.class);
        emailVO.add(linkTo(methodOn(EmailController.class).findById(emailVO.getId())).withSelfRel());
        return emailVO;
    }

    public EmailVO update(EmailVO emailVO) {
        if (emailVO == null) throw new RequiredObjectIsNullException();
        Email email = DozerMapper.parseObject(emailVO, Email.class);
        Email emailDb = repository.save(email);
        emailVO = DozerMapper.parseObject(emailDb, EmailVO.class);
        emailVO.add(linkTo(methodOn(EmailController.class).findById(emailVO.getId())).withSelfRel());
        return emailVO;
    }

    public String delete(Long id) {
        Optional<Email> dbEmail = repository.findById(id);
        if (dbEmail.isPresent()) {
            repository.deleteById(id);
            return "Email with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }
}
