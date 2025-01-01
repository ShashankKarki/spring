<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<div>
<a href="home">Home</a>
<a href="about">About</a>
<a href="contact">Contact</a>
<a href="products">Product</a>
<a href="signup">Signup</a>
<security:authorize access="!isAuthenticated()">
<a href="login">Login</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
<a href="/logout">Logout</a>
</security:authorize>

</div>