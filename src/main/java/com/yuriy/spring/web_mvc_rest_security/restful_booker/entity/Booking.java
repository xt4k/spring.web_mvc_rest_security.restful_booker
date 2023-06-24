package com.yuriy.spring.web_mvc_rest_security.restful_booker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Booking {

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("totalprice")
    private Integer totalPrice;


    @JsonProperty("depositpaid")
    private Boolean depositPaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;


    public Booking() {
    }

    public Booking(Faker faker) {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.totalPrice = faker.number().numberBetween(10, 9999);
        this.depositPaid = true;

        this.bookingDates = new BookingDates(faker.date().birthday(), faker.date().birthday());
        this.additionalNeeds = faker.hipster().word();
    }

}

