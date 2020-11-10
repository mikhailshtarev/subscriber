package ru.shtarev.subscriber.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.shtarev.subscriber.enumerated.Action;

@Data
public class Message {
    public long id;

    public long msisdn;

    public Action action;

    public long timestamp;
}
