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

    <title>Ecommerce - Register</title>

    <!-- Custom fonts for this template-->
    <link href="${cp }/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${cp }/assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Login</h1>
                            </div>
                            <form class="user" action="${cp }/login" method="post">
                        
                                   
                                   
                               
                                <div class="form-group">
                                <label>Username:</label>
                                   <input type="text" class="form-control form-control-user" name="username" id="exampleFirstName"
                                            placeholder="username">
                                </div>
                                
                                <div class="form-group">
                                <label>Password:</label>
                                   <input type="password" class="form-control form-control-user" name="password" id="exampleFirstName"
                                            placeholder="Password">
                                </div>
                               
                                              
                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-primary btn-user btn-block" value="login">
                                </div>                         
                            </form>
                            <hr>
                           
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${cp }/assets/vendor/jquery/jquery.min.js"></script>
    <script src="${cp }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${cp }/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${cp }/assets/js/sb-admin-2.min.js"></script>

</body>

</html>

