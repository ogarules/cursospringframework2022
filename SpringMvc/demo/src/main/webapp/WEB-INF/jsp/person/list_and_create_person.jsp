<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>Hola Mundo - Spring MVC</title>
            </head>

            <body>
                <h1>Persons</h1>
                <h2>Register</h2>
                <form:form action="${pageContext.request.contextPath}/person/create" modelAttribute="personForm" method="POST">
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td>
                                <form:input path="name" style="background-color: red; color: blueviolet;" />
                                <form:errors path="name" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td>Age:</td>
                            <td>
                                <form:input path="age" />
                                <form:errors path="age" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" value="Submit">
                            </td>
                        </tr>
                    </table>
                </form:form>

                <br />
                <hr />
                <br />

                <h2>Registered Persons</h2>
                <c:forEach var="person" items="${persons}" varStatus="i">
                    <c:out value="${i.index + 1}" /> ${person} <br />
                </c:forEach>
            </body>

            </html>