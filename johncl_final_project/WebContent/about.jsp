<!doctype html>
<html lang="en">

<head>
  <title>About</title>
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
              <a class="nav-link active" href="about.jsp">About</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="class.jsp" id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
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
            <h1 class="mb-4">About Us</h1>
            <p class="custom-breadcrumbs"><a href="index.jsp">Home</a> <span class="mx-3">/</span> About</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  
 
  <div class="section">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6">
          <img src="images/img_1_sm.jpg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-5 ml-auto">
          <h2 class="heading mb-4">We Have Unique Fitness Programs</h2>
          <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, quos, adipisci aliquid similique saepe ipsa minus maxime alias libero nam quis officia eum impedit. At quisquam reprehenderit cum hic enim?</p>
          <p>Necessitatibus eligendi molestias similique tempore, optio nobis numquam temporibus debitis cum aspernatur, eius, nihil soluta sapiente enim. Incidunt ipsam praesentium voluptate in pariatur dignissimos, ab corporis minima ea odio asperiores.</p>
          
        </div>
      </div>
    </div>
  </div>

  <div class="section">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6 order-md-2">
          <img src="images/img_2_sm.jpg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-5 mr-auto">
          <h2 class="heading mb-4">Be Fit &amp; Healthy</h2>
          <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi, quos, adipisci aliquid similique
            saepe ipsa minus maxime alias libero nam quis officia eum impedit. At quisquam reprehenderit cum hic enim?</p>
          <p>Necessitatibus eligendi molestias similique tempore, optio nobis numquam temporibus debitis cum aspernatur,
            eius, nihil soluta sapiente enim. Incidunt ipsam praesentium voluptate in pariatur dignissimos, ab corporis
            minima ea odio asperiores.</p>
  
        </div>
      </div>
    </div>
  </div>

  <div class="section">
    <div class="container">
      <div class="row justify-content-center mb-5 element-animate">
        <div class="col-md-8 text-center">
          <h2 class="heading mb-4">Meet Our Team</h2>
          <p class="mb-5 lead">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
            there live the blind texts. Separated they live in Bookmarksgrove.</p>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-4">
          <div class="media d-block media-custom text-center">
            <a href="#"><img src="images/person_1.jpg" alt="Image Placeholder" class="img-fluid"></a>
            <div class="media-body">
              <h3 class="mt-0 text-black">Mellisa Howard</h3>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="media d-block media-custom text-center">
            <a href="#"><img src="images/person_2.jpg" alt="Image Placeholder" class="img-fluid"></a>
            <div class="media-body">
              <h3 class="mt-0 text-black">Mike Richardson</h3>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="media d-block media-custom text-center">
            <a href="#"><img src="images/person_3.jpg" alt="Image Placeholder" class="img-fluid"></a>
            <div class="media-body">
              <h3 class="mt-0 text-black">Laura Smith</h3>
            </div>
          </div>
        </div>
  
      </div>
  
    </div>
  </div>
  <!-- END section -->
  

  

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