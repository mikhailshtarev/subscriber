package ru.shtarev.subscriber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shtarev.subscriber.entity.Message;
import ru.shtarev.subscriber.entity.MessagePurchase;
import ru.shtarev.subscriber.entity.MessageSubscription;
import ru.shtarev.subscriber.enumerated.Action;
import ru.shtarev.subscriber.repository.MessagePurchaseRepository;
import ru.shtarev.subscriber.repository.MessageSubscriptionRepository;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessagePurchaseRepository messagePurchaseRepository;
    private final MessageSubscriptionRepository messageSubscriptionRepository;

    @Autowired
    public MessageServiceImpl(MessagePurchaseRepository messagePurchaseRepository, MessageSubscriptionRepository messageSubscriptionRepository) {
        this.messagePurchaseRepository = messagePurchaseRepository;
        this.messageSubscriptionRepository = messageSubscriptionRepository;
    }

    @Override
    public void saveMessage(final Message message) {
        log.info("received message: "+ message);
        if (Action.PURCHASE.equals(message.getAction())) {
            MessagePurchase messagePurchase = new MessagePurchase();
            messagePurchase.setId(message.getId());
            messagePurchase.setMsisdn(message.getMsisdn());
            messagePurchase.setTimestamp(message.getTimestamp());
            messagePurchaseRepository.save(messagePurchase);
        }
        if (Action.SUBSCRIPTION.equals(message.getAction())) {
            MessageSubscription messageSubscription = new MessageSubscription();
            messageSubscription.setId(message.getId());
            messageSubscription.setMsisdn(message.getMsisdn());
            messageSubscription.setTimestamp(message.getTimestamp());
            messageSubscriptionRepository.save(messageSubscription);
        }
    }
}
