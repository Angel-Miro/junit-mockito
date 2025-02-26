package com.debuggeandoideas.airdnd.helpers;

import java.util.Objects;

public class MailHelper {

    public void sendMail(final String bookingId, final String emailAddress) {
        if (Objects.isNull(emailAddress)) throw new IllegalArgumentException("Mail cant be null");
        //Send mail...
    }
}
