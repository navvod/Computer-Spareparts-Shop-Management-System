<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Booking</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Bootstrap Datepicker CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">

    <!-- Custom Styles -->
       <link rel="stylesheet" href="assets/css/plugins/plugins.min.css">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <link rel="stylesheet" href="useraccount.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .booking {
            background-color: #343a40;
            border-radius: 15px;
        }

        .form-floating {
            margin-bottom: 20px;
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
    
    <div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="container">
            <div class="booking p-5 bg-info">
                <div class="row g-5 align-items-center">
                    <div class="col-md-6 text-white">
                        <h1 class="text-white mb-4">Online Request Computer Repair</h1>
                    </div>
                    <div class="col-md-6">
                        <form action="CustomerBookingServlet" method="post" onsubmit="return validateForm()">
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating date" id="date3" data-target-input="nearest">
                                        <input name="date" type="text" class="form-control bg-transparent datetimepicker-input" id="datetime" placeholder="Date & Time" data-target="#date3" data-toggle="datetimepicker" required/>
                                        <label for="datetime">Requesting Date</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input name="destination" type="text" class="form-control bg-transparent" id="name" placeholder="Your Name" required>
                                        <label for="name">Customer Name</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <textarea name="requests" class="form-control bg-transparent" placeholder="Special Request" id="message" style="height: 100px" required></textarea>
                                    <label for="message">Special Request</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-outline-light w-100 py-3" type="submit" name="submit">Create Appointment</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Datepicker JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.8/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

    <script>
        // Set up the datepicker
        $(document).ready(function () {
            var currentDate = new Date();
            $('#datetime').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true,
                startDate: currentDate, // Users can select only from the current date and future dates
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
