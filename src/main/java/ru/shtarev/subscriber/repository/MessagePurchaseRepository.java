package ru.shtarev.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shtarev.subscriber.entity.MessagePurchase;

@Repository
public interface MessagePurchaseRepository extends JpaRepository<MessagePurchase, String> {
}
