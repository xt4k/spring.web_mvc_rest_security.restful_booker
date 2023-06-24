<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

    <html>
        <body>
            <h2>Booking Information</h2>
            <br>
            <table modelAttribute="bookingInfo">
                <tr>
                    <th>First Name</th>
                    <th></th>
                    <th>Last name</th>
                    <th></th>
                    <th>Total price</th>
                    <th></th>
                    <th>Deposit paid</th>
                    <th></th>
                    <th>Checkin date</th>
                    <th></th>
                    <th>Checkout date</th>
                    <th></th>
                    <th>Additional needs</th>
                </tr>
                <tr>
                    <td>${bookingInfo.booking.firstName}</td>
                    <th></th>
                    <td>${bookingInfo.booking.lastName}</td>
                    <th></th>
                    <td>${bookingInfo.booking.totalPrice}</td>
                    <th></th>
                    <td>${bookingInfo.booking.depositPaid}</td>
                    <th></th>
                    <td><fmt:formatDate pattern = "yyyy-MM-dd"
                     value = "${bookingInfo.booking.bookingDates.checkIn}"/></td>
                    <th></th>
                    <td><fmt:formatDate pattern = "yyyy-MM-dd"
                    value = "${bookingInfo.booking.bookingDates.checkOut}"/></td>
                    <th></th>
                    <td>${bookingInfo.booking.additionalNeeds}</td>
                </tr>
            </table>
            <br>

            <sec:authorize access="hasRole('GUEST')">
                <h5>Users with role GUEST has only read access to bookings information</h5>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <h5>Users with role USER may read and update bookings</h5>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <h5>Users with role Admin have full access (create, read, update, delete, search by criteria)</h5>
            </sec:authorize>

            <c:url var="updateButton" value="/updateBooking">
                <c:param name="bookingId" value="${bookingInfo.bookingId}"/>
            </c:url>
            <c:url var="deleteButton" value="/deleteBooking">
                <c:param name="bookingId" value="${bookingInfo.bookingId}"/>
            </c:url>
            <c:url var="backButton" value="/"/>

             <sec:authorize access="hasRole('USER')">
                <input type="button" value="Change current booking" onclick="window.location.href='${updateButton}'"/>
             </sec:authorize>
              <br><br>
              <sec:authorize access="hasRole('ADMIN')">
                <input type="button" value="Add new booking" onclick="window.location.href='addBooking'"/>
                <br><br>
                <input type="button" value="Delete current booking" onclick="window.location.href='${deleteButton}'"/>
              </sec:authorize>

            <br><br>
            <input type="button" value="Back" onclick="window.location.href='${backButton}'"/>
        </body>
    </html>