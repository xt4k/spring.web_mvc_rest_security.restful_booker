<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

    <html>
        <body>
            <h2>Booking Id-s List</h2>
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

            <table>

                <tr>
                    <th>Booking_Id</th>
                    <th>Booking_operations</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>
                        <sec:authorize access="hasRole('ADMIN')">
                            <input type="button" value="Add new booking" onclick="window.location.href='addBooking'"/>
                         </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <input type="button" value="Search booking" onclick="window.location.href='searchBooking'"/>
                         </sec:authorize>
                    </th>
                </tr>

                <c:forEach items="${bookingIdList}" var="booking">

                 <c:url var="updateButton" value="/updateBooking">
                    <c:param name="bookingId" value="${booking.id}"/>
                 </c:url>
                  <c:url var="deleteButton" value="/deleteBooking">
                    <c:param name="bookingId" value="${booking.id}"/>
                  </c:url>
                  <c:url var="infoButton" value="/getBookingInfo">
                    <c:param name="bookingId" value="${booking.id}"/>
                  </c:url>

                    <tr>
                        <td>${booking.id}</td>
                        <td>

                            <input type="button" value="Details" onclick="window.location.href='${infoButton}'"/>

                            <sec:authorize access="hasRole('USER')">
                                <input type="button" value="Change" onclick="window.location.href='${updateButton}'"/>
                            </sec:authorize>

                            <sec:authorize access="hasRole('ADMIN')">
                                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
                            </sec:authorize>
                        </td>
                    </tr>

                </c:forEach>

            </table>

        </body>
    </html>