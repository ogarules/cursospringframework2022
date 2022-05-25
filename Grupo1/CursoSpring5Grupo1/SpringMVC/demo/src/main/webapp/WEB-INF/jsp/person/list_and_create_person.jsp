<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

            <!DOCTYPE html>
            <html>

            <head>
                <title>Spring mvc - List and create persons</title>
            </head>

            <body>
                <h1>Person</h1>

                <h2>Register</h2>

                <form:form action="${pageContext.request.contextPath}/person/create" modelAttribute="personForm" method="POST">
                    <table>
                        <tr>
                            <td>
                                Name:
                            </td>
                            <td>
                                <form:input path="name"></form:input>
                                <form:errors path="name" cssClass="error"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Age:
                            </td>
                            <td>
                                <form:input path="age"></form:input>
                                <form:errors path="age" cssClass="error"></form:errors>
                            </td>
                        </tr>
                        <tr>
                            <input type="submit" name="submit" value="Submit" />
                        </tr>
                    </table>
                </form:form>

                <br>
                <hr>
                <br>

                <h2>Registered persons</h2>

                <c:forEach var="person" items="${persons}" varStatus="i">
                    <c:out value="${i.index + 1}"></c:out> ${person} <br>
                </c:forEach>
            </body>

            </html>