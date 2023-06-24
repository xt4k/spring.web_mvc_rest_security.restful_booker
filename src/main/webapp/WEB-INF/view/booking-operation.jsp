<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

    <html>
        <body>
            <h2>Booking Operation</h2>
            <br>
            <form:form action="saveBooking" modelAttribute="bookingInfo">
                <sec:authorize access="hasRole('USER')">
                    <h5>Users with role USER may read and update bookings</h5>

                    <form:hidden path="bookingId"/>
                    <br>
                    First name <form:input path="booking.firstName"/>
                    <br><br>
                    Last name <form:input path="booking.lastName"/>
                    <br><br>
                    Total price <form:input path="booking.totalPrice"/>
                    <br><br>
                    Deposit Paid:
                    <br>
                    true <form:radiobutton path="booking.depositPaid" text='true' value="true"/>
                    <br>
                    false <form:radiobutton path="booking.depositPaid" text='false' value="false"/>
                    <br><br>
                    Checkin date <form:input type="text"
                                         path="booking.bookingDates.checkIn"
                                         class="date"
                                         name = "booking.bookingDates.checkIn"/>
                    Checkout date <form:input type="text"
                                          path="booking.bookingDates.checkOut"
                                          class="date"
                                          name = "booking.bookingDates.checkOut"/>
                    <br><br>
                    Additional needs <form:input path="booking.additionalNeeds"/>
                    <br><br>

                    <input type='submit' value='OK'>
                    <br><br>

                    <c:url var="cancelButton" value="/getBookingInfo">
                        <c:param name="bookingId" value="${bookingInfo.bookingId}"/>
                    </c:url>

                    <input type='button' value='Cancel' onclick="window.location.href='${cancelButton}'"/>
                    <br>

                </sec:authorize>
            </form:form>
            <br>
        </body>
    </html>