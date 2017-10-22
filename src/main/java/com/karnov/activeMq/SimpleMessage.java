package com.karnov.activeMq;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Artem Karnov @date 10/23/2017.
 * artem.karnov@t-systems.com
 */
public class SimpleMessage implements Serializable {

    private Date currentDate;
    private String message;

    public SimpleMessage(Date date, String message){
        this.currentDate=date;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "currentDate=" + currentDate +
                ", message='" + message + '\'' +
                '}';
    }
}
