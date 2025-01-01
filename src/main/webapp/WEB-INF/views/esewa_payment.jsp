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
					<div class="card-header">Proceed to checkout</div>
					<div class="card-body">
					<form action="https://rc-epay.esewa.com.np/api/epay/main/v2/form" method="POST">
					 <input type="text" id="amount" name="amount" value="${payment.amount }" required>
					 <input type="text" id="tax_amount" name="tax_amount" value="${payment.taxAmount }"  required>
					 <input type="text" id="total_amount" name="total_amount" value="${payment.totalAmount }" required>
					 <input type="text" id="transaction_uuid" name="transaction_uuid" value="${payment.transactionUID }"  required>
					 <input type="text" id="product_code" name="product_code" value="${payment.productCode }"  required>
					 <input type="text" id="product_service_charge" name="product_service_charge" value="${payment.psc}"  required>
					 <input type="text" id="product_delivery_charge" name="product_delivery_charge" value="${payment.pdc }"  required>
					 <input type="text" id="success_url" name="success_url" value="${payment.sucessUrl}"  required>
					 <input type="text" id="failure_url" name="failure_url" value="${payment.faliureUrl}"  required>
					 <input type="text" id="signed_field_names" name="signed_field_names" value="${payment.signedFields}"  required>
					 <input type="text" id="signature" name="signature" value="${payment.signature }"  required>
					 <input value="Submit" type="submit">
					 </form>
					
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