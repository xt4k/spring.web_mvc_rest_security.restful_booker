package com.yuriy.spring.web_mvc_rest_security.restful_booker.controller;


import com.yuriy.spring.web_mvc_rest_security.restful_booker.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class Communicator {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "https://restful-booker.herokuapp.com/";

    public List<BookingId> getAll() {
        ResponseEntity<List<BookingId>> response =
                restTemplate.exchange(URL+"booking", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BookingId>>() { } );
        return response.getBody();
    }

    public List<BookingId> filterBooking(Booking booking) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL+"booking");

        if (!booking.getFirstName().isEmpty()) {
            builder.queryParam("firstname", booking.getFirstName());
        }

        if (!booking.getLastName().isEmpty()) {
            builder.queryParam("lastname",  booking.getLastName());
        }
        URI uri = builder.build().toUri();

        ResponseEntity<List<BookingId>> response =
                restTemplate.exchange(uri, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BookingId>>() { } );
        return response.getBody();
    }

    public
    Booking getBooking(int id) {
        URI uri = UriComponentsBuilder.fromUriString(URL+"booking/{id}").build(id);

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .header("Accept",  "application/json")
                .build();

        ResponseEntity<Booking> response = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<Booking>(){});
        return response.getBody();
    }

    public void saveBooking(BookingInfo bookingInfo) {

       if (ofNullable(bookingInfo.getBookingId()).isPresent()) {
           updateBooking(bookingInfo);
           //System.out.println("try to update");

       }  else {
           addBooking(bookingInfo.getBooking());
           //System.out.println("try to add");
       }
    }
    public void addBooking(Booking booking) {
        RequestEntity<Booking> requestEntity = RequestEntity.post(URI.create(URL+"booking"))
                .headers(getHeaders())
                .body(booking);

        ResponseEntity<BookingInfo> response = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<BookingInfo>(){});
       // System.out.println("added new booking with id: " + Objects.requireNonNull(response.getBody()).getBookingId());
    }

    public void updateBooking(BookingInfo bookingInfo) {
        RequestEntity<Booking> requestEntity = RequestEntity.put(URI.create(URL+"booking/"+ bookingInfo.getBookingId()))
                .headers(getAuthHeaders())
                .body(bookingInfo.getBooking());

        ResponseEntity<Booking> response = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<Booking>(){});
      //  System.out.println("updated booking: " + response.getBody());

    }

    public void deleteBooking(int id) {
        ResponseEntity<String> response= restTemplate.exchange(URL+"booking/"+id,HttpMethod.DELETE,new HttpEntity<>(getAuthHeaders()), String.class);
     //   System.out.printf("Delete booking (id:'%s') response response '%s'.%n",id, response.getBody());
    }


    private String  getToken(){
        RequestEntity<AuthUser> requestEntity = RequestEntity.post(URI.create(URL+"auth"))
                .header("Content-type","application/json")
                .body(new AuthUser(true));

        ResponseEntity<Token> response = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<Token>(){});
        //System.out.println("token: " + response.getBody().getToken());
        return response.getBody().getToken();
    }

    private HttpHeaders getAuthHeaders(){
        HttpHeaders headers = getHeaders();
        headers.set("Cookie","token="+getToken());
        //System.out.println("getAuthHeaders: " + headers);
        return headers;
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}