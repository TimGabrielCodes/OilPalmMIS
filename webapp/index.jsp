<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 24/04/2022
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Meta -->
  <meta name="description" content="Responsive Bootstrap 4 Dashboard and Admin Template">
  <meta name="author" content="ThemePixels">

  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

  <title>Sign In</title>

  <!-- vendor css -->
  <link href="lib/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">

  <!-- template css -->
  <link rel="stylesheet" href="assets/css/cassie.css">

</head>
<body>

<div class="row h-100" >
  <svg-to-inline path="http://themepixels.me/cassie/assets/svg/citywalk.svg" class-Name="svg-bg"></svg-to-inline>

  <div class="signin-sidebar">
    <div class="signin-sidebar-body">
      <a href="dashboard-one.html" class="sidebar-logo mg-b-40"><span>Oil Plantation </span></a>
      <h4 class="signin-title">Welcome back!</h4>
      <h5 class="signin-subtitle">Please sign in to continue.</h5>

      <div class="signin-form">

          <form action="loginprocess" method="post" role="form">
            <div class="form-group">

              <label>Email address</label>
              <input type="email" name="email" class="form-control" placeholder="Enter your email address" value="mail@example.com">
            </div>

            <div class="form-group">
              <label class="d-flex justify-content-between">
                <span>Password</span>
                <a href="" class="tx-13">Forgot password?</a>
              </label>
              <input type="password" name="password" class="form-control" placeholder="Enter your password" value="password">
            </div>

            <div class="form-group d-flex mg-b-0">
              <button type="submit" class="btn btn-brand-01 btn-uppercase flex-fill">Sign In</button>
              <a href="page-signup.html" class="btn btn-white btn-uppercase flex-fill mg-l-10">Sign Up</a>
            </div>


          </form>


      <p class="mg-t-auto mg-b-0 tx-sm tx-color-03">By signing in, you agree to our <a href="">Terms of Use</a> and <a href="">Privacy Policy</a></p>
    </div><!-- signin-sidebar-body -->
  </div><!-- signin-sidebar -->
</div><!-- signin-panel -->

<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="lib/feather-icons/feather.min.js"></script>
<script src="lib/perfect-scrollbar/perfect-scrollbar.min.js"></script>

<script src="assets/js/svg-inline.js"></script>
</body>
</html>
