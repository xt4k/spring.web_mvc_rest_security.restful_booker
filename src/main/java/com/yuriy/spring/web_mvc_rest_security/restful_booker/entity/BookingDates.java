package com.yuriy.spring.web_mvc_rest_security.restful_booker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookingDates {

    @JsonProperty("checkin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkIn;

    @JsonProperty("checkout")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOut;

    public BookingDates() {
    }

    public BookingDates(Date checkin, Date checkOut) {
        this.checkIn =checkin;
        this.checkOut =checkOut;
    }


    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "BookingDates{" +
                "checkin=" + formatter.format(checkIn) +
                ", checkout=" +formatter.format(checkOut)+
                '}';
    }
}
