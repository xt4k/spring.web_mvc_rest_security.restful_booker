package com.yuriy.spring.web_mvc_rest_security.restful_booker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingInfo {

    @JsonProperty("bookingid")
    private Integer bookingId;

    @JsonProperty("booking")
    private Booking booking;

    public BookingInfo() {
    }

    public BookingInfo(Booking booking, int bookingId) {
        this.booking = booking;
        this.bookingId= bookingId;
    }
}

