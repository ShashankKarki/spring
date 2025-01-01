<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="cp" value="${pageConext.request.centextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>
</head>
<body>
<div>
<span>Welcome user: ${user}</span>
<h1>Add new category detail</h1>
<form action="${cp}/admin/category/add" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<p>
<label>Category Name:</label>
<input type="text" name="cat_name" placeholder="Enter category name here" required/>
</p>

<p>
<label>Category Description:</label>
<textarea name="cat_description" placeholder="Enter category description here" 
rows="5" cols="50" required></textarea>
</p>

<p>
<label>Category parent</label>
<select name="cat_parent"required>
<option value="0">-- Main category</option>
<c:forEach items="${cat_list}" var="cat">
<option value="${cat.id}"> ${cat.name} </option>
</c:forEach>
</select>
</p>

<p>
<input type="submit" value="Save Category"/>
<input type="reset"value="Reset Form"/>
</p>
</form>
</div>
</body>
</html>