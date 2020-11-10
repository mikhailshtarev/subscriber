package ru.shtarev.subscriber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "PURCHASE")
public class MessagePurchase {
    @Id
    @Column(name = "id", nullable = false)
    public long id;
    @Column(name = "msisdn", nullable = false)
    public long msisdn;
    @Column(name = "timestamp", nullable = false)
    public long timestamp;
}
