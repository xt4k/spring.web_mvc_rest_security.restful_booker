package com.yuriy.spring.web_mvc_rest_security.restful_booker.controller;


import com.yuriy.spring.web_mvc_rest_security.restful_booker.entity.Booking;
import com.yuriy.spring.web_mvc_rest_security.restful_booker.entity.BookingId;
import com.yuriy.spring.web_mvc_rest_security.restful_booker.entity.BookingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private Communicator communication;

    @GetMapping({"/","/back"})
    public String showAllBookings(Model model) {
        List<BookingId> bookIdList = communication.getAll();
        model.addAttribute("bookingIdList", bookIdList);

        return "booking-id-list";
    }

    @RequestMapping({"/doSearch"})
    public String doSearch(Booking booking, Model model) {
        List<BookingId> bookIdList = communication.filterBooking(booking);
        model.addAttribute("bookingIdList", bookIdList);

        return "booking-id-list";
    }

    @GetMapping("/getBookingInfo")
    public String getBooking(@RequestParam("bookingId") int bookingId, Model model) {
        //System.out.println("try to get booking: "+bookingId);

        Booking booking = communication.getBooking(bookingId);
        BookingInfo bookingInfo = new BookingInfo(booking,bookingId);
        model.addAttribute("bookingInfo", bookingInfo);

        return "booking-info";
    }

    @GetMapping("/addBooking")
    public String addBooking(Model model) {
        BookingInfo bookingInfo = new BookingInfo();
        model.addAttribute("bookingInfo", bookingInfo);

        return "booking-operation";
    }

    @RequestMapping("/saveBooking")
    public String saveBooking(BookingInfo bookingInfo) {
        communication.saveBooking(bookingInfo);

        return "redirect:/";
    }

    @GetMapping("/deleteBooking")
    public String deleteEmployee(@RequestParam("bookingId") int id) {
       communication.deleteBooking(id);

        return "redirect:/";
    }

    @PutMapping("/updateBooking")
    public String updateBooking(BookingInfo bookingInfo) {
        communication.updateBooking(bookingInfo);

        return "redirect:/";
    }

    @GetMapping("/updateBooking")
    public String updateBooking(@RequestParam("bookingId") int id, Model model) {
        Booking booking = communication.getBooking(id);
        //System.out.println("update booking GET: "+id);
        model.addAttribute("bookingInfo", new BookingInfo(booking,id));

        return "booking-operation";
    }

    @GetMapping("/searchBooking")
    public String searchBooking(Model model) {
        //System.out.println("try to search booking");
        Booking booking = new Booking();
        model.addAttribute("booking", booking);

        return "booking-search";
    }
}