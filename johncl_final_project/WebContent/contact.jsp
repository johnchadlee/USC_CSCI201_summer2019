<!doctype html>
<html lang="en">

<head>
  <title>Contact</title>
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
              <a class="nav-link dropdown-toggle" href="class.jsp" id="dropdown04" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">Class</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
                <a class="dropdown-item" href="#">All</a>
                  <a class="dropdown-item" href="#">Cycle</a>
                  <a class="dropdown-item" href="#">Yoga</a>
                  <a class="dropdown-item" href="#">CrossFit</a>
                  <a class="dropdown-item" href="#">Cardio Jam</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="gallery.jsp">Gallery</a>
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
            <h1 class="mb-4">Contact Us</h1>
            <p class="custom-breadcrumbs"><a href="index.jsp">Home</a> <span class="mx-3">/</span> Contact</p>
          </div>
        </div>
      </div>
    </div>
  </div>


  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-md-6 mb-5 order-2">
          <form action="ContactUs" method="GET">
            <div class="row">
              <div class="col-md-6 form-group">
                <label for="name">Name</label>
                <input type="text" name = "name" id="name" class="form-control ">
              </div>
              <div class="col-md-6 form-group">
                <label for="phone">Phone</label>
                <input type="text" name = "phone" id="phone" class="form-control ">
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 form-group">
  
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 form-group">
                <label for="email">Email</label>
                <input type="email" name = "email" id="email" class="form-control ">
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 form-group">
                <label for="message">Write Message</label>
                <textarea name="message" id="message" class="form-control " cols="30" rows="8"></textarea>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 form-group">
                <input type="submit" value="Send Message" class="btn btn-primary px-3 py-3">
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-6 order-2 mb-5">
          <div class="row justify-content-right">
            <div class="col-md-8 mx-auto contact-form-contact-info">
              <p class="d-flex">
                <span class="ion-ios-location icon mr-5"></span>
                <span>929 W. Jefferson Blvd, Ste 1665, Los Angeles, CA 90087</span>
              </p>
  
              <p class="d-flex">
                <span class="ion-ios-telephone icon mr-5"></span>
                <span>+ 213.764.7940</span>
              </p>
  
              <p class="d-flex">
                <span class="ion-android-mail icon mr-5"></span>
                <span>trojanfitness@usc.edu</span>
              </p>
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