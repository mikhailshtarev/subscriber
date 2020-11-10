package ru.shtarev.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shtarev.subscriber.entity.MessageSubscription;

@Repository
public interface MessageSubscriptionRepository extends JpaRepository<MessageSubscription, String> {
}
