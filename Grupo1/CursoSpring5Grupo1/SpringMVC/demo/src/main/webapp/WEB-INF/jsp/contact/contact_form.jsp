<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

            <!DOCTYPE html>
            <html>

            <head>
                <title>Contact Us</title>
            </head>

            <body>
                <h2>Contact Us!!!!!</h2>

                <form:form method="POST" modelAttribute="contactForm">
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td>
                                <form:input path="name"></form:input>
                                <form:errors path="name" cssStyle="color: red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td>
                                <form:input path="email"></form:input>
                                <form:errors path="email" cssStyle="color: red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td>
                                <form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
                                <form:errors path="gender" cssStyle="color:red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <form:password path="password"></form:password>
                                <form:errors path="password" cssStyle="color:red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>PAssword confirmation</td>
                            <td>
                                <form:password path="confirmPassword"></form:password>
                                <form:errors path="confirmPassword" cssStyle="color:red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>Courses</td>
                            <td>
                                <form:checkboxes path="courses" items="${availableCourses}"></form:checkboxes>
                                <form:errors path="courses" cssStyle="color:red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>Toutor</td>
                            <td>
                                <form:select path="tutor">
                                    <form:option value="" label="...."></form:option>
                                    <form:options items="${vailableTutors}"></form:options>
                                </form:select>
                                <form:errors path="tutor" cssStyle="color:red;"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:hidden path="hiddenMessage"></form:hidden>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="submit" name="submit">
                            </td>
                        </tr>
                    </table>
                </form:form>
            </body>

            </html>