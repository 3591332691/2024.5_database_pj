package com.example.demo.Controller;

import com.example.demo.Entity.Favored_merchant;
import com.example.demo.Entity.Message;
import com.example.demo.Entity.Orders;
import com.example.demo.Repository.MessageRepository;
import com.example.demo.Service.Favored_merchantService;
import com.example.demo.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/message/userID/{userID}")
    public List<Message> getMessageByUserID(@PathVariable int userID) {
        return messageRepository.getMessageByUserID(userID);
    }

}

