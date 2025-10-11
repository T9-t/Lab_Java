package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class SmsMessage {

    private String phoneNumber;
    private String message;
}