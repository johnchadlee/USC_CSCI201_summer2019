<!doctype html>
<html lang="en">

<head>
  <title>Class</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Oxygen:400,700" rel="stylesheet">

  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/jquery.fancybox.min.css">

  <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

  <!-- Theme Style -->
  <link rel="stylesheet" href="css/style.css">

</head>

<body>
	<%
    String useremail = (String)request.getSession().getAttribute("user");
    if (useremail == null) {
    	useremail = "";
    }
    %>
  <header role="banner">
    <nav class="navbar navbar-expand-lg  bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand " href="index.jsp">Trojan Fitness</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05"
          aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample05">
          <ul class="navbar-nav pl-md-5 mr-auto">
            <li class="nav-item">
              <a class="nav-link " href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.jsp">About</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle active" href="class.jsp" id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">Class</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
                <a class="dropdown-item" href="#">All</a>
                  <a class="dropdown-item" href="#">Cycle</a>
                  <a class="dropdown-item" href="#">Yoga</a>
                  <a class="dropdown-item" href="#">CrossFit</a>
                  <a class="dropdown-item" href="#">Cardio Jam</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="gallery.jsp">Gallery</a>
            </li>
            
              <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Contact Us!</a>
              </li>
              
          </ul>

           <% if (useremail == null || useremail.equals("")) { %>
                <a class="nav-link" href = "signin.jsp">Sign-in</a>
                <a class="nav-link" href = "register.jsp">Register</a>
              <%} else {%>
                <a class="nav-link" href = "profile.jsp">My Account</a>
                <a class="nav-link" href = "SignoutServlet">Sign-out</a>
              <%} %>

        </div>
      </div>
    </nav>
  </header>
  <!-- END header -->

  <div class="inner-page">
    <div class="slider-item overlay" style="background-image: url('images/village.jpg');">
      <div class="container">
        <div class="row slider-text align-items-center justify-content-center">
          <div class="col-lg-9 text-center col-sm-12 element-animate">
            <h1 class="mb-4">Our Services</h1>
            <p class="custom-breadcrumbs"><a href="index.jsp">Home</a> <span class="mx-3">/</span> Services</p>
          </div>
        </div>
      </div>
    </div>
  </div>


  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-yoga-mat"></span>
            </div>
            <div class="service-text">
              <h3>Quality Service</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo amet.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-weight-1"></span>
            </div>
            <div class="service-text">
              <h3>Spacious Gym</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo
                amet.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-bike"></span>
            </div>
            <div class="service-text">
              <h3>Live Healthy</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo
                amet.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-pulse"></span>
            </div>
            <div class="service-text">
              <h3>Crossfit</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo
                amet.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-weight"></span>
            </div>
            <div class="service-text">
              <h3>Weight Lifting</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo
                amet.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 mb-5 mb-lg-5 col-lg-4">
          <div class="service-box">
            <div class="square-figure">
              <span class="flaticon-skip-rope"></span>
            </div>
            <div class="service-text">
              <h3>Roping</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia molestias id voluptatum unde sequi
                soluta illo
                amet.</p>
            </div>
          </div>
        </div>
        
      </div>
    </div>
  </div>

  <!-- loader -->
  <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
      <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
      <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
        stroke="#f4b214" /></svg></div>

  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/main.js"></script>
</body>

</html>