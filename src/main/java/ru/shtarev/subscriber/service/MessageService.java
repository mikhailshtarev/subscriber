package ru.shtarev.subscriber.service;

import ru.shtarev.subscriber.entity.Message;

public interface MessageService {

    void saveMessage(Message message);
}
