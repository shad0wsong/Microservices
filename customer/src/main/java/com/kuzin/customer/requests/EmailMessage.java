package com.kuzin.customer.requests;

import com.kuzin.customer.enums.EmailTheme;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailMessage {
    String address;
    EmailTheme theme;

}
