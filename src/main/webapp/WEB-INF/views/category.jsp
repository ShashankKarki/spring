<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
    
    <!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>E-Commerce - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="${cp}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${cp}/assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       <%@include file="sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
              <%@include file="topbar.jsp" %>
            
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Category Management</h1>
                        
                    </div>
			
			<div class="row">
			<div class="col col-lg-9">
			
			<c:choose>
			<c:when test="${edit ne true}">
			<div class="card">
			<div calss="card-header">
			Add New Category
			</div>
			<div class="card-body">
			<form class="from for-responsive"action="${cp}/admin/category/add" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="form-group">
<label for="inputName">Category Name:</label>
<input class="form-control" type="text" id="inputName" name="cat_name" placeholder="Enter category name here" required/>
</div>

<div class="from-group">
<label for="inputDescription">Category Description:</label>
<textarea id="inputDescription" name="cat_description" placeholder="Enter category description here" 
rows="5" cols="50" class="form-control" required></textarea>
</div>

<div class="from-group">
<label for="inputParent">Category parent</label>
<select class="form-control" name="cat_parent" id="inputParent" required>
<option value="0">-- Main category</option>
<c:forEach items="${cat_list}" var="cat">
<option value="${cat.id}"> ${cat.name} </option>
</c:forEach>
</select>
</div>

<p>
<input type="submit" class="btn btn-primary" value="Save Category"/>
<input type="reset" class="btn btn-warning" value="Reset Form"/>
</p>
</form>
			</div>
			<div class="card-footer">
			</div>
			</div>
			</c:when>
			
			<c:otherwise>
			<!-- edit category form -->
		<div class="card">
			<div calss="card-header">
			Edit Category
			</div>
			<div class="card-body">
			<form class="from for-responsive" action="${cp}/admin/category/edit" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="form-group">
<label for="inputId">Category Id:</label>
<input class="form-control" type="text" id="inputName" name="id" value="${edit_cat.id}" readonly/>
</div>

<div class="form-group">
<label for="inputName">Category Name:</label>
<input class="form-control" type="text" id="inputName" name="name" value="${edit_cat.name }" required/>
</div>

<div class="from-group">
<label for="inputDescription">Category Description:</label>
<textarea id="inputDescription" name="description" 
rows="5" cols="50" class="form-control" required>${edit_cat.description}</textarea>
</div>

<div class="from-group">
<label for="inputParent">Category parent</label>
<select class="form-control" name="parent" id="inputParent" required>
<option value="0">-- Main category</option>
<c:forEach items="${cat_list}" var="cat">
<option value="${cat.id}" ${edit_cat.parentCat eq cat.id? "selected" : ""}> 
<!--  <c:if test="${edit_cat.parentCat eq cat.id}">selected</c:if> yesar ni garna milyo-->


${cat.name} </option>
</c:forEach>
</select>
</div>

<p>
<input type="submit" class="btn btn-primary" value="Update Category"/>
<input type="reset" class="btn btn-warning" value="Reset Form"/>
</p>
</form>
			</div>
			<div class="card-footer">
			</div>
			</div>
			</c:otherwise>
			</c:choose>
			<!-- Add category fomr -->
			
			</div>
			<!-- display category details -->
			<div class="row" id=#category_data>
			<div class="col">
			<div class="card">
			<div class="card-heading">All Categories
			<div class="card-body">
			<table class="table table-responsive table-striped">
			<thead>
			<tr>
			<th>Category Id</th>
			<th>Category Name</th>
			<th>Description</th>
			<th>Parent Category</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${cat_list}" var="cat">
			<tr>
			<td>${cat.id}</td>
			<td>${cat.name}</td>
			<td>${cat.description}</td>
			<td>
			<c:set var="parent_name" value="Main Category"/>
			<c:forEach items="${cat_list}" var="category">
			<c:if test="${cat.parentCat eq category.id}">
			<c:set var="parent_name" value="${category.name}"/>
			</c:if>
			</c:forEach>
			${parent_name}
			</td>
			<td><a class="btn btn-warning" href="${cp}/admin/category/edit/${cat.id}"><i class="fas fa-edit"></i></a></td>
			<td>
			<!--  <button type="button" onclick="return confirmDelete();" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" data-whatever="${cat.id}"><i class="fas fa-trash"></i></button>-->
			<a class="btn btn-danger" onclick="return confirmDelete();" href="${cp}/admin/category/delete/${cat.id}"><i class="fas fa-trash"></i></a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
			</div>
			</div>
			</div>
			</div>
			<div class="col col-lg-3">
			</div>
			</div>
			
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
   <%@ include file="logout_model.jsp" %>
   
   
<!-- <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirm delete category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <label class="col-form label">Are you sure you want to delete this category?</label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Confirm delete</button>
      </div>
    </div>
  </div>
</div> -->
    <!-- Bootstrap core JavaScript-->
    <script src="${cp}/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${cp}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${cp}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${cp}/assets/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${cp}/assets/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${cp}/assets/js/demo/chart-area-demo.js"></script>
    <script src="${cp}/assets/js/demo/chart-pie-demo.js"></script>
    <script>
    function confirmDelete() {
    return confirm("Are you sure you want to delete this category?");
}
</script>
	
</body>

</html>