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

    <title>Products</title>

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
                    <c:forEach items="${ all_products}" var="product">
                    <div class="col col-lg-3 col-md-4 col-sm-6">
                    <div class="card m-2 p-2">
                    <div class="card-heading">${product.name}/${product.category.name}</div>
                    <div class="card-body p-0">
                    <img class="img-fluid mx-auto img-thumbnail" src="${cp}/product_image/${product.imageName}" height="200px" alt="${product.name}"/>
                    <br>
                    <p>
                    ${product.description }
                    </p>
                    <p>
                    ${product.price}
                    </p>
                    <p>
                    <a class="btn btn-info" href="${cp}/user/cart/add/${product.id}"><i class="fas fa-shopping-cart"></i></a>
                    </p>
                    <div>
                    <form  action="${cp }/user/comments/add" method="post">
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                            <div class="from-group">
							<label for="inputComment">Add a Comment:</label>
							<textarea id="inputComment" rows="1" name="comment"class="form-control"></textarea>
							<input type="hidden" name="product_id" value="${product.id}"/>
							</div>
                            <input type="submit"/>
                            </form>
                    </div>
                    <p class="mt-3"><strong>Comments:</strong></p>
<div>
    <c:forEach items="${all_comments}" var="comment">
        <c:if test="${comment.product.id == product.id}">
            <p class="mb-2">
                <strong>${comment.userDetail.username}</strong>: ${comment.comment}
            </p>
        </c:if>
    </c:forEach>
</div>

                    </div>
                    </div>
                    </div>
                    </c:forEach>
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

