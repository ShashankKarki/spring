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
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user" action="${cp }/signup" method="post">
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                                
                                   <div class="form-group">
                                   <input type="text" class="form-control form-control-user" name="firstName" id="exampleFirstName"
                                            placeholder="FirstName">
                                </div>
                                <div class="form-group">
                                   <input type="text" class="form-control form-control-user" name="lastName" id="exampleFirstName"
                                            placeholder="LastName">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" name="phoneNo" id="exampleFirstName"
                                            placeholder="Phone">
                                        
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="address" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="address">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="username" id="exampleFirstName"
                                            placeholder="username">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="date" name="dob" class="form-control form-control-user" id="exampleLastName">
                                    </div>
                                </div>
                                                            
                                 <div class="form-group">
                                    <input type="email" name="email" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Email Address">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" name="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repeat Password">
                                    </div>
                                </div>
                                 <div class="form-group">
                                 <label for="authority">Authority: </label> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio"  name="authority" value="admin">&nbsp; Admin &nbsp;&nbsp;
                                    <input type="radio" name="authority" value="user">&nbsp; User 
                                </div>

                                
                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-primary btn-user btn-block" value="Register">
                                </div>                         
                            </form>
                            <hr>
                           
                            <div class="text-center">
                                <a class="small" href="#">Already have an account? Login!</a>
                            </div>
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

