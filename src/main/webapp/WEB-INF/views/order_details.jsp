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

       

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
              <%@include file="menu.jsp" %>
            
                <!-- End of Topbar -->
				
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Blank</h1>
                        
                    </div>
					
					<div class="row">
					<div class="col">
					<div class="card">
					<div class="card-header">Displaying OrderInformation</div>
					<div class="card-body">
					<table class="table table-responsive table-strinped">
					<thead>
					<tr>
					<th>S.No</th>
					<th>Order ID</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th>OrderDate</th>
					<th>Delivery Date</th>
					<th>Payment Method</th>
					<th>Status</th>
					<th>Action</th>
					</tr>
					<tbody>
					<c:set var="sn" value="${1}"/>
					<c:set var="grand_total" value="${0}"/>
					<c:forEach items ="${order_detail.orderedProducts }" var="ord_prod">
					
					
					<tr>
					<td>${sn}</td>
					
					<td>${ord_prod.product.name }</td>
					<td>${ord_prod.quantity}</td>
					<td>${order_detail.total_amount}</td>
					<td>${order_detail.orderDate}</td>
					<td>${order_detail.delivery_date}</td>
					<td>${order_detail.payment_method}</td>
					<td>${order_detail.status}</td>
					<td><a href="${cp}/user/order/delete/${order_detail.id}" class="btn btn-danger">Cancel</a>
					</tr>
					<c:set var="sn" value="${sn+ 1}"/>
					
					</c:forEach>
					</tbody>
					
					</table>
					</div>
					</div>
					</div>
					</div>
					
					<div class="row">
					<div class="col">
					<div class="card">
					<div class="card-header">Proceed to checkout..</div>
					<div class="card-body">
					<div class="row">
					<div class="col col-md-4">
					<div class="card">
					<div class="card-heading">Cash On delivery</div>
					<div class="card-body">
					<a class="btn btn-info" href="${cp}/user/payment/sucess?agent=cod">Place an order..</a>
					</div>
					
					
					</div>
					</div>
					<div class="col col-md-4">
					<div class="card">
					<div class="card-heading">Pay via E-sewa</div>
					<div class="card-body">
					<a class="btn btn-success" href="${cp}/user/payment/esewa">Place an order..</a>
					</div>
					</div>
					</div>
					
					<div class="col col-md-4">
					<div class="card">
					<div class="card-heading">Pay via Khalti</div>
					<div class="card-body">
					<a class="btn btn-secondary" href="${cp}/user/payment/khalti">Place an order..</a>
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

</body>

</html>