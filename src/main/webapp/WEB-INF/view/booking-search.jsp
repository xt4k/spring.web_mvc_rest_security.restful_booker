<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

    <html>
        <body>
            <h2>Booking Search</h2>
            <br>
            <form:form action="doSearch" modelAttribute="booking">
                <sec:authorize access="hasRole('USER')">
                    <h5>This content will only be visible to USER and ADMIN role</h5>

                    <br>
                    First name <form:input path="firstName"/>
                    <br><br>
                    Last name <form:input path="lastName"/>
                    <br><br>

                    <input type='submit' value='OK'>
                    <br><br>
                </sec:authorize>

                <c:url var="cancelButton" value="/"/>
                <input type='button' value='Cancel' onclick="window.location.href='${cancelButton}'"/>
                <br><br>

            </form:form>
            <br>
        </body>
    </html>