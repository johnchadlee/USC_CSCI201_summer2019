<!doctype html>
<html lang="en">
  <head>
    <title>Trojan Fitness</title>
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
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarsExample05">
            <ul class="navbar-nav pl-md-5 mr-auto">
              <li class="nav-item">
                <a class="nav-link active" href="index.jsp">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.jsp">About</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="class.jsp" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Class</a>
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

    <!-- <div class="top-shadow"></div> -->
    



    <div class="slider-item overlay" style="background-image: url('images/village.jpg');">
      <div class="container">
        <div class="row slider-text align-items-center justify-content-center">
          <div class="col-lg-9 text-center col-sm-12 element-animate">
            <h1 class="mb-4">Best Fitness In USC</h1>
            <div class="btn-play-wrap mx-auto">
              <p class="mb-4"><a href="https://www.youtube.com/watch?v=tGUjEMJd7PE" data-fancybox data-ratio="2"
                  class="btn-play"><span class="ion ion-ios-play"></span></a></p>
            </div>
            <span>Watch Video</span>
    
          </div>
        </div>
      </div>
    </div>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6 mb-4 mb-lg-0 col-lg-3">
            <div class="service-box">
              <div class="square-figure">
                <span class="flaticon-yoga-mat"></span>
              </div>
              <div class="service-text">
                <h3>Quality Service</h3>
                <p>Full locker room services are available to provide ultimate convenience and comforts.</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4 mb-lg-0 col-lg-3">
            <div class="service-box">
              <div class="square-figure">
                <span class="flaticon-weight-1"></span>
              </div>
              <div class="service-text">
                <h3>Spacious Gym</h3>
                <p> A wide range of resistance and cardio machines. Touch screens are on most treadmills and 
                ellipticals.</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4 mb-lg-0 col-lg-3">
            <div class="service-box">
              <div class="square-figure">
                <span class="flaticon-bike"></span>
              </div>
              <div class="service-text">
                <h3>Live Healthy</h3>
                <p>Our platform offers cycling machines that are equipped with the latest in STAGESIndoor Cycling technology.</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4 mb-lg-0 col-lg-3">
            <div class="service-box">
              <div class="square-figure">
                <span class="flaticon-pulse"></span>
              </div>
              <div class="service-text">
                <h3>Crossfit</h3>
                <p>Our class schedules are designed to include both the latest fitness trends and methods 
                for getting better results.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section position-relative">
      <div style="background-image: url('images/gym1.jpg');" class="img-1"></div>
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-5 ml-auto">
            <div class="padding-tb">
            <h2 class="heading mb-4">Enjoy The Gym</h2>
            <p>we are dedicated to offering the best amenities, equipment, classes, programs and professional staff. Anything to help our members reach their fitness goals.</p>
            <p>All members have up to 1 hour of free personal training per member, per month in all of our locations. Our student trainers will work with you, one on one, as you systematically change programs every month.</p>
            </div>

          </div>
        </div>
      </div>
    </div>

    <div class="section bg-primary">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-4 element-animate ">
            <div class="media block-6 d-block text-center">
              <div class="icon mb-3"><span class="flaticon-yoga-mat text-white"></span></div>
              <div class="media-body">
                <h3 class="heading text-white">Health Program</h3>
                <p class="text-white">An apple a day keeps the doctor away. Customize your own nutritional program with us to reach your personal goals.
                Our nutrition experts will collaborate with you in your overall fitness and health by keep tracking of your progress</p>
              </div>
            </div>
    
          </div>
          <div class="col-md-6 col-lg-4 element-animate ">
            <div class="media block-6 d-block text-center">
              <div class="icon mb-3"><span class="flaticon-bike text-white"></span></div>
              <div class="media-body">
                <h3 class="heading text-white">Lose Weight</h3>
                <p class="text-white">Build the body you want. Custom your own fitness and nutrition program based on the 
                results of your individual metabolic profile. Manage your healthy diet and weight training equipment at our gym!</p>
              </div>
            </div>
    
          </div>
          <div class="col-md-6 col-lg-4 element-animate ">
            <div class="media block-6 d-block text-center">
              <div class="icon mb-3"><span class="flaticon-pulse text-white"></span></div>
              <div class="media-body">
                <h3 class="heading text-white">Maintenance</h3>
                <p class="text-white">Learn energizing workout moves and healthy recipes with our trainers to make sure you have a steady progress.
                Living a healthy life means making lifestyle choices that support your physical, mental, spiritual, and emotional well-being. </p>
              </div>
            </div>
    
          </div>
        </div>
      </div>
    </div>
    <!-- END section -->


    <div class="site-section position-relative">
      <div style="background-image: url('images/gym2.jpg');" class="img-2"></div>
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-5 mr-auto">
            <div class="padding-tb">
            <h2 class="heading mb-4">Be Fit &amp; Healthy</h2>
            <p>Any slight change in angle of movement will work new muscle fiber, raising basal metabolism, improving 
            coordination and increasing the hardness of the muscle group being worked.</p>
            <p>When we continually work the same muscle fiber by doing the same movements over and over, the body adapts and progress increases.</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    

    <div class="bg-primary py-5">
      <div class="container text-center">
        <div class="row justify-content-center">
          <div class="col-lg-7">
            <h3 class="text-white mb-4">Join With Us Now!</h3>
            <p class="text-white lead mb-4">Start to be a healthy Trojan today!</p>
            <p class="mb-0"><a href="contact.html" class="btn btn-warning px-4 py-3">Get In Touch!</a></p>
          </div>
        </div>
        
      </div>
    </div>
    
    
    

    <!-- loader -->
    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>