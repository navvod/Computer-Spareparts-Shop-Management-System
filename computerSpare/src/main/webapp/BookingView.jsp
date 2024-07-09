<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .data-display {
    background-color: #fff; /* White background */
    padding: 100px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Box shadow for depth effect */
    margin: 20px 0;
}

        html, body {
            height: 100%;
        }

        body {
            display: flex;
            flex-direction: column;
        }

        .content-wrapper {
            flex: 1;
        }

        .footer-section {
            flex-shrink: 0;
        }
    </style>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
    <link rel="stylesheet" href="assets/css/style.min.css">
    
    
<title>Insert title here</title>
<link rel="stylesheet" href="useraccount.css">

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
                                    <a href="frontmain.jsp">Next Spare</a>
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

        <c:forEach var="book" items="${bookDetails}">
      
      	<c:set var="idbooking" value="${book.id}"/>
	    <c:set var="date" value="${book.date}"/>
	    <c:set var="destination" value="${book.destination}"/>
	    <c:set var="requests" value="${book.requests}"/>

	     </c:forEach>
	     <div class="data-display">
	     
	                <div class="content-wrapper">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Requested ID</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ${idbooking}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Requesting date</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ${date}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Customer Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ${destination}
                    </div>
                  </div>
                  <hr>
                 <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Special Request</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ${requests}
                    </div>
                  </div>
                  <hr>
                 
                
                  <hr>
                  <div class="row">
                    <div class="col-sm-12">
                    <c:url value="updatebooking.jsp" var="bookingupdate">
		                 <c:param name="idbooking" value="${idbooking}"/>
		                 <c:param name="date" value="${date}"/>
		                 <c:param name="destination" value="${destination}"/>
		                 <c:param name="requests" value="${requests}"/>
		         
	                </c:url>
                          
                      <a href="${bookingupdate}" type="button" class="btn btn-info "  href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills">Edit My Request</a>
                    </div>
                  </div>
                  <div class="mt-3">
                      
                      <c:url value="deletebooking.jsp" var="bookingdelete">
		                 <c:param name="idbooking" value="${idbooking}"/>
		                 <c:param name="date" value="${date}"/>
		                 <c:param name="destination" value="${destination}"/>
		                 <c:param name="requests" value="${requests}"/>
	                  </c:url>
	                  <a href="${bookingdelete}">
                      <button name="delete" class="btn btn-outline-primary">Delete My Request</button>
                      
                      <!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Launch demo modal
</button> -->
                      </a>
                    </div>
                </div>
              </div>




            </div> 
            </div>
                <footer class="footer-section footer-bg">
        <div class="footer-wrapper">
            <!-- Start Footer Top -->
            <div class="footer-top">
                <div class="container">
                    <div class="row mb-n6">
                        <div class="col-lg-3 col-sm-6 mb-6">
                            <!-- Start Footer Single Item -->
                            <div class="footer-widget-single-item footer-widget-color--golden" data-aos="fade-up"
                                data-aos-delay="0">
                                <h5 class="title">NAVIGATION</h5>
                                <ul class="footer-nav">
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="my-account.html">Profile</a></li>
                                    <li><a href="contact-us.html">Contact-Us</a></li>
                                    <li><a href="about-us.html">About-US</a></li>
                                </ul>
                            </div>
                            <!-- End Footer Single Item -->
                        </div>
                        <div class="col-lg-3 col-sm-6 mb-6">
                            
                        </div>
                        <div class="col-lg-3 col-sm-6 mb-6">
                            
                        </div>
                        <div class="col-lg-3 col-sm-6 mb-6">
                            <!-- Start Footer Single Item -->
                            <div class="footer-widget-single-item footer-widget-color--golden" data-aos="fade-up"
                                data-aos-delay="600">
                                <h5 class="title">ABOUT US</h5>
                                <div class="footer-about">
                                    <p>We are Selling Quality Products </p>

                                    <address class="address">
                                        <span>Address: Kaduwela road,Malabe</span>
                                        <span>Email: </span>
                                    </address>
                                </div>
                            </div>
                            <!-- End Footer Single Item -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Footer Top -->

            

            <!-- Start Footer Bottom -->
            <div class="footer-bottom">
                <div class="container">
                    <div
                        class="row justify-content-between align-items-center align-items-center flex-column flex-md-row mb-n6">
                        <div class="col-auto mb-6">
                            <div class="footer-copyright">
                                <p class="copyright-text">&copy;2023 <a href="index.html">Next Spare</a> All Rights Reserved <i
                                        class="fa fa-heart text-danger"></i> by <a href=""
                                        target="_blank">SLIIT</a> </p>

                            </div>
                        </div>
                        <div class="col-auto mb-6">
                            <div class="footer-payment">
                                <div class="image">
                                    <img src="assets/images/company-logo/payment.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Start Footer Bottom -->
        </div>
    </footer>
        <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    

    <!-- Main JS -->
    <script src="assets/js/main.js"></script>

</body>
</html>