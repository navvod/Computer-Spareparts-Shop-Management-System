<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>User Account</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }

        .container {
            margin-top: 50px;
        }

        .card-details {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-details p {
            margin-bottom: 10px;
        }

        .action-buttons {
            margin-top: 20px;
        }

        .action-buttons a {
            text-decoration: none;
        }

        .action-buttons button {
            margin-right: 10px;
            transition: all 0.3s;
        }

        .action-buttons button:hover {
            transform: scale(1.05);
        }
    </style>
        <link rel="shortcut icon" href="assets/images/favicon.ico" type="image/png">

    <!-- ::::::::::::::All CSS Files here :::::::::::::: -->
    <!-- Vendor CSS -->
    <!-- <link rel="stylesheet" href="assets/css/vendor/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/vendor/ionicons.css">
    <link rel="stylesheet" href="assets/css/vendor/simple-line-icons.css">
    <link rel="stylesheet" href="assets/css/vendor/jquery-ui.min.css"> -->

    <!-- Plugin CSS -->
    <!-- <link rel="stylesheet" href="assets/css/plugins/swiper-bundle.min.css">
    <link rel="stylesheet" href="assets/css/plugins/animate.min.css">
    <link rel="stylesheet" href="assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="assets/css/plugins/venobox.min.css">
    <link rel="stylesheet" href="assets/css/plugins/jquery.lineProgressbar.css">
    <link rel="stylesheet" href="assets/css/plugins/aos.min.css"> -->

    <!-- Main CSS -->
    <!-- <link rel="stylesheet" href="assets/sass/style.css"> -->

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
    <link rel="stylesheet" href="assets/css/style.min.css">
</head>
<body>
    <header class="header-section d-none d-xl-block">
        <div class="header-wrapper">
            <div class="header-bottom header-bottom-color--golden section-fluid sticky-header sticky-color--golden">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 d-flex align-items-center justify-content-between">
                            <!-- Start Header Logo -->
                            <div class="header-logo">
                                <div class="h3">
                                    <a href="index.html">Next Spare</a>
                                </div>
                            </div>
                            <!-- End Header Logo -->

                            <!-- Start Header Main Menu -->
                            <div class="main-menu menu-color--black menu-hover-color--golden">
                                <nav>
                                    <ul>
                                        <li>
                                            <a  href="frontmain.jsp">Home </a>
                                            
                                            
                                        </li>

                                        <li>
                                            <a href="LoginServlet">Profile</a>
                                        </li>
                                        <li class="has-dropdown">
                                            <a class="active main-menu-link" href="index.html">CATEGORIES <i
                                                    class="fa fa-angle-down"></i></a>
                                            <!-- Sub Menu -->
                                            <ul class="sub-menu">
                                                <li><a href="">Keyboard</a></li>
                                                <li><a href="">Mouse </a></li>
                                                <li><a href="">Monitors</a></li>
                                                <li><a href="">Ram</a></li>
                                                <li><a href="">VGA</a></li>
                                                <li><a href="">Casing</a></li>
                                                <li><a href="">Hard Disks</a></li>
                                        </li>
                                        </ul>
                                      
                                        <li>
                                            <a href="about-us.html">About Us</a>
                                        </li>
                                        <li>
                                            <a href="feedback.jsp">Feedback</a>
                                        </li>
                                        <li><a href="booking.jsp">Request</a></li>
                                        <li><a href="BookingDetailsServlet">View My Current Request</a></li>
                                    </ul>
                                </nav>
                            </div>
                            <!-- End Header Main Menu Start -->

                            <!-- Start Header Action Link -->
                            <ul class="header-action-link action-color--black action-hover-color--golden">
                                
                                <li>
                                    <a href="#offcanvas-add-cart" class="offcanvas-toggle">
                                        <i class="icon-bag"></i>
                                        <span class="item-count">3</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#search">
                                        <i class="icon-magnifier"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#offcanvas-about" class="offacnvas offside-about offcanvas-toggle">
                                        <i class="icon-menu"></i>
                                    </a>
                                </li>
                            </ul>
                            <!-- End Header Action Link -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

         <c:forEach var="cus" items="${cusDetails}">
      
      	<c:set var="id" value="${cus.id}"/>
	    <c:set var="name" value="${cus.name}"/>
	    <c:set var="email" value="${cus.email}"/>
	    <c:set var="phone" value="${cus.phone}"/>
	    <c:set var="username" value="${cus.userName}"/>
	    <c:set var="password" value="${cus.password}"/>
	     </c:forEach>
    <!-- Start Header Area -->


    <div class="container card-details">
        <c:forEach var="card" items="${cardDetails}">
            <c:set var="idcard" value="${card.getIdcard()}"/>
            <c:set var="CardNumber" value="${card.getCardNumber()}"/>
            <c:set var="CardHolderName" value="${card.getCardHolderName()}"/>
            <c:set var="CVC" value="${card.getCVC()}"/>
            <c:set var="ExpiredDate" value="${card.getExpiredDate()}"/>
        </c:forEach>

        <p>Card Number: ${CardNumber}</p>
        <p>Card Holder Name: ${CardHolderName}</p>
        <p>CVC: ${CVC}</p>
        <p>Expired Date: ${ExpiredDate}</p>

        <div class="mt-3 action-buttons">
            <c:url value="deletecard.jsp" var="carddelete">
                <c:param name="idcard" value="${idcard}"/>
                <c:param name="CardNumber" value="${CardNumber}"/>
                <c:param name="CardHolderName" value="${CardHolderName}"/>
                <c:param name="CVC" value="${CVC}"/>
                <c:param name="ExpiredDate" value="${ExpiredDate}"/>
            </c:url>
            <a href="${carddelete}">
                <button name="delete" class="btn btn-outline-danger">Delete My Card</button>
            </a>

            <c:url value="CardUpdate.jsp" var="cardupdate">
                <c:param name="idcard" value="${idcard}"/>
                <c:param name="CardNumber" value="${CardNumber}"/>
                <c:param name="CardHolderName" value="${CardHolderName}"/>
                <c:param name="CVC" value="${CVC}"/>
                <c:param name="ExpiredDate" value="${ExpiredDate}"/>
            </c:url>
            <a href="${cardupdate}">
                <button name="update" class="btn btn-outline-primary">Update Card</button>
            </a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
