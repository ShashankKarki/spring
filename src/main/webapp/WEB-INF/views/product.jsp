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
                        <h1 class="h3 mb-0 text-gray-800">Product management</h1>
                        
                    </div>
                    <c:choose>
                    <c:when test="${edit ne true }">
                    <div class="row">
                    <div class="col">
                    <div class="card">
                    <div class="card-header">Add new Product Information</div>
                    <div class="card-body">
                    <form action="${cp}/admin/product/add" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                    <div class="from-group">
                    <label for="product_name">Product Name</label>
                    <input type="text" class="form-control" name="name" id="product_name" 
                    placeholder="Enter product name here" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_description">Product Description</label>
                    <textarea class="form-control" rows="5" cols="100" name="description" id="product_description" 
                    placeholder="Enter product description here" required></textarea>
                    </div>
                    
                    <div class="from-group">
                    <label for="product_tags">Product Tags</label>
                    <input type="text" class="form-control" name="tags" id="product_tags" 
                    placeholder="Enter product tag here" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_image">Product Image</label>
                    <input type="file" class="form-control" name="imageFile" id="product_image" 
                    placeholder="Enter product image here" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_quantity">Product Quantity</label>
                    <input type="text" class="form-control" name="quantity" id="product_quantity" 
                    placeholder="Enter product quantity here" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_price">Product price</label>
                    <input type="text" class="form-control" name="price" id="product_price" 
                    placeholder="Enter product price here" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_category">Product Category</label>
                    <select class="form-control" name="category" id="product_name" >
                    <c:forEach items="${cat_list}" var="cat">
                    <option value="${cat.id}"> ${cat.name}</option>
                    </c:forEach>
                    </select>
                    </div>
                    
                    <div class="form-group">
                    <input type="submit" value="submit">
                    </div>
                    
                    </form>
                    </div>
                    </div>
                    </div>
                    </div>
                    </c:when>
                    
                    
                    <c:otherwise>
                    <div class="row">
                    <div class="col">
                    <div class="card">
                    <div class="card-header">Edit Product Information</div>
                    <div class="card-body">
                    <form action="${cp}/admin/product/edit" method="post" enctype="multipart/form-data">
                    
                    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                    <div class="from-group">
                    <label for="product_id">Product Id</label>
                    <input type="text" class="form-control" name="id" id="product_id" 
                    value="${edit_product.id }" readonly/>
                    </div>
                    
                    <div class="from-group">
                    <label for="product_name">Product Name</label>
                    <input type="text" class="form-control" name="name" id="product_name" 
                    value="${edit_product.name }" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_description">Product Description</label>
                    <textarea class="form-control" rows="5" cols="100" name="description" id="product_description" 
                     required>${edit_product.description }</textarea>
                    </div>
                    
                    <div class="from-group">
                    <label for="product_tags">Product Tags</label>
                    <input type="text" class="form-control" name="tags" id="product_tags" 
                    value="${edit_product.tags }" required />
                    </div>
                    <br>
                    <div class="from-group">
                    
              		<p>Current Product Image</p>
                    <img src="${cp}/product_image/${edit_product.imageName}" height="100px" alt="${edit_product.imageName}">
                    </div>
                    <br>
                    <div class="from-group">
                    <label for="product_update_image">Update Product Image</label>
                    <input type="file" class="form-control" name="imageFile" id="product_update_image" />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_quantity">Product Quantity</label>
                    <input type="text" class="form-control" name="quantity" id="product_quantity" 
                    value="${edit_product.quantity }" required />
                    </div>
                    
                    <div class="from-group">
                    <label for="product_price">Product price</label>
                    <input type="text" class="form-control" name="price" id="product_price" 
                    value="${edit_product.price }" required />
                    </div>
                    
                   <div class="form-group">
    <label for="product_category">Product Category</label>
    <select class="form-control" name="category" id="product_category">
        <c:forEach items="${cat_list}" var="cat">
                <option value="${cat.id}" ${edit_product.category.name eq cat.name ? "selected" : ""}>${cat.name}
            </option>
        </c:forEach>
    </select>
</div>
                    
                    <div class="form-group">
                    <input type="submit" value="submit">
                    </div>
                    
                    </form>
                    </div>
                    </div>
                    </div>
                    </div>
                    </c:otherwise>
                    </c:choose>
                    
                    
                    <div class="row">
                    <div class="col">
                    <div class="card">
                    <div class="card-header">All Product</div>
                    <div class="card-body">
                    <table class="table table-responsive table-striped">
                    <thead>
                    <tr>
                    <th>Product Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Tags</th>
                    <th>Image</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Added Date</th>
                    <th>Category</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${product_list}" var="prod">
                    <tr>
                    <td>${prod.id}</td>
                    <td>${prod.name}</td>
                    <td>${prod.description}</td>
                    <td>${prod.tags}</td>
                    <td><img src="${cp}/product_image/${prod.imageName}" height="100px" alt="${prod.imageName}"></td>
                    <td>${prod.quantity}</td>
                    <td>${prod.price}</td>
                    <td>${prod.addedDate}</td>
                    <td>${prod.category.name}</td>
                    <td><a class="btn btn-warning" href="${cp }/admin/product/edit/${prod.id}"><i class="fa fa-edit"></i></a></td>
                     <td><a class="btn btn-danger" onclick="return confirmDelete();" href="${cp }/admin/product/delete/${prod.id}"><i class="fa fa-trash"></i></a></td>
                    </c:forEach>
                    </tbody>
                    </table>
                    </div>
                    </div>
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