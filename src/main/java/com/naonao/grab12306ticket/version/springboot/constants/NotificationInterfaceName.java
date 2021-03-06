package com.naonao.grab12306ticket.version.springboot.constants;

import lombok.Getter;

/**
 * @program: 12306grabticket_java
 * @description:
 * @author: Wen lyuzhao
 * @create: 2019-05-06 23:06
 **/
@Getter
public enum  NotificationInterfaceName {

    /**
     * notification interface name
     */

    TWILIO("TWILIO"),
    NEXMO("NEXMO"),
    YUNZHIXIN("YUNZHIXIN"),

    // Email

    // Phone
    TWILIO_VOICE("TWILIO_VOICE"),
    YUNZHIXIN_VOICE("YUNZHIXIN_VOICE"),


    // SMS
    TWILIO_SMS("TWILIO_SMS"),
    NEXMO_SMS("NEXMO_SMS");

    private final String notificationInterfaceName;

    NotificationInterfaceName(String notificationInterfaceName) {
        this.notificationInterfaceName = notificationInterfaceName;
    }

}
