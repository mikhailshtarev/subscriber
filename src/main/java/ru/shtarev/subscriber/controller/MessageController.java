package ru.shtarev.subscriber.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shtarev.subscriber.entity.Message;
import ru.shtarev.subscriber.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<Object> addNewMessage(@RequestBody final Message message) {
        messageService.saveMessage(message);
        return ResponseEntity.ok().build();
    }
}
