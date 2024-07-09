<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Feedback Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Bootstrap Icons CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Animate CSS -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">

    <!-- Owl Carousel CSS -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Tempus Dominus CSS -->
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet">

    <!-- Bootstrap Datepicker CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/css/bootstrap-datepicker.min.css">

    <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <style>
  
        .booking {
            background-color: #007bff;
            border-radius: 15px;
        }

        h1, h6 {
            font-family: 'Nunito', sans-serif;
        }

        input.form-control, textarea.form-control {
            border-radius: 8px;
            margin-bottom: 10px;
        }

        .btn-outline-light {
            border-color: #fff;
            color: #fff;
            border-radius: 8px;
        }

        .btn-outline-light:hover {
            background-color: #fff;
            color: #007bff;
        }
        
        #datepicker {
  height: calc(3.5rem + 2px);
  padding: 1rem .75rem;
}

input::placeholder {
        color: #fff; /* Placeholder text color */
        opacity: 0.8; /* Placeholder opacity */
    }
    </style>
</head>
<body>

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
    <!-- Start Header Area -->

    <div class="container-xxl py-5 mt-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="container">
            <div class="booking  bg-info  p-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-6 text-white">
                        <h6 class="text-white text-uppercase">Feedback</h6>
                        <p class="mb-4">You can send feedback about your experience.</p>
                    </div>
                    <div class="col-md-6">
                        <h1 class="text-white mb-4">Send Feedback</h1>
                        <form action="CustomerFeedbackServlet" method="post" onsubmit="return validateForm()">
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="input-group date">
                                        <input name="date" type="text" class="form-control" id="datepicker" placeholder="Date" readonly required/>
                                        <div class="input-group-append">
                                            <span class="input-group-text mt-2"><i class="bi bi-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input name="name" type="text" class="form-control bg-transparent" id="name" placeholder="Your Name" required>
                                        <label for="name">Name</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <textarea name="feedbacks" class="form-control bg-transparent" placeholder="Special Request" id="message" required style="height: 100px"></textarea>
                                    <label for="message">Feedback</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-outline-light w-100 py-3" type="submit" name="submit">Send Feedback</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Wow JS -->
    <script src="lib/wow/wow.min.js"></script>

    <!-- Easing JS -->
    <script src="lib/easing/easing.min.js"></script>

    <!-- Waypoints JS -->
    <script src="lib/waypoints/waypoints.min.js"></script>

    <!-- Owl Carousel JS -->
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Tempus Dominus JS -->
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Bootstrap Datepicker JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/js/bootstrap-datepicker.min.js"></script>

    <!-- Custom JavaScript for Date Picker and Validation -->
    <script>
        // Set up the datepicker
        $(document).ready(function () {
            var currentDate = new Date();
            $('#datepicker').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true,
                startDate: currentDate,
                endDate: currentDate,
                todayHighlight: true,
            });
        });

        // Form validation function
        function validateForm() {
            var name = document.getElementById('name').value;
            var feedbacks = document.getElementById('message').value;

            if (!name || !feedbacks) {
                alert('Please fill in all fields.');
                return false;
            }

            return true;
        }
    </script>

</body>
</html>
