<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <style>
        /* Custom Styles */
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 600px;
            margin: auto;
        }

        .form-group {
            margin-bottom: 20px;
        }
    </style>
    <script>
    $(function() {
        // Use jQuery UI datepicker for month and year selection
        $("#expiry_date").datepicker({
            dateFormat: 'mm/yy',
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            onClose: function (dateText, inst) {
                $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
            }
        });
    });
    function validateForm() {
        // Card Number Validation
        var cardNumber = document.getElementById("card_number").value;
        if (cardNumber.length !== 16 || isNaN(cardNumber)) {
            alert("Please enter a valid 16-digit card number.");
            return false;
        }

        // CVC Validation
        var cvc = document.getElementById("cvc").value;
        if (cvc.length !== 3 || isNaN(cvc)) {
            alert("Please enter a valid 3-digit CVC.");
            return false;
        }

        // Expiry Date Validation
        var expiryDate = document.getElementById("expiry_date").value;
        var currentDate = new Date();
        var selectedDate = new Date(expiryDate);

        if (selectedDate <= currentDate) {
            alert("Please select a future expiry date.");
            return false;
        }

        return true;
    }
</script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Next Spare</title>

    <!-- ::::::::::::::Favicon icon::::::::::::::-->
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

         <c:forEach var="cus" items="${cusDetails}">
      
      	<c:set var="id" value="${cus.id}"/>
	    <c:set var="name" value="${cus.name}"/>
	    <c:set var="email" value="${cus.email}"/>
	    <c:set var="phone" value="${cus.phone}"/>
	    <c:set var="username" value="${cus.userName}"/>
	    <c:set var="password" value="${cus.password}"/>
	     </c:forEach>
    <!-- Start Header Area -->
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

        </div> <!-- End Offcanvas Mobile Menu Wrapper -->
    </div>
    <div class="container mt-5">
        <form action="CardinsertServlet" method="post" onsubmit="return validateForm()">

            <div class="form-group">
                <label for="card_number">Card Number:</label>
                <input type="text" class="form-control" id="card_number" name="card_number" required>
            </div>

            <div class="form-group">
                <label for="cardholder_name">Name of Card holder:</label>
                <input type="text" class="form-control" id="cardholder_name" name="cardholder_name" required>
            </div>

            <div class="form-group">
                <label for="cvc">CVC:</label>
                <input type="text" class="form-control" id="cvc" name="CVC" required>
            </div>

            <div class="form-group">
                <label for="expiry_date">Expired Date:</label>
                <input type="date" class="form-control" id="expiry_date" name="expiry_date" required>
            </div>

            <button type="submit" name="submit" value="Add Card" class="btn btn-warning btn-lg ms-2">Add Card</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js CDN (add these scripts at the end of the body for better performance) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
