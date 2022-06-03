<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">

    <!-- Meta -->
    <meta content="Responsive Bootstrap 4 Dashboard and Admin Template" name="description">
    <meta content="ThemePixels" name="author">

    <!-- Favicon -->
    <link href="../assets/img/favicon.png" rel="shortcut icon" type="image/x-icon">

    <title>Error</title>

    <!-- vendor css -->
    <link href="../lib/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">

    <!-- template css -->
    <link href="../assets/css/cassie.css" rel="stylesheet">

</head>
<body class="page-error">

<div class="error-panel">
    <a class="sidebar-logo mg-b-40" href="${pageContext.request.contextPath}/dashboard"><span>OilPalmMIS</span></a>

    <div class="svg-wrapper mg-b-40">
        <object data="http://themepixels.me/cassie/assets/svg/notfound.svg" type="image/svg+xml"></object>
    </div>
    <h1 class="tx-28 tx-sm-36 tx-numeric tx-md-40 tx-semibold">404 Page Not Found</h1>
    <h4 class="tx-16 tx-sm-18 tx-md-24 tx-light mg-b-20 mg-md-b-30">${message}</h4>
    <p class="tx-12 tx-sm-13 tx-md-14 tx-color-04">You may have mistyped the address or the page may have moved. Try
        searching below.</p>

<%--    <div class="search-form wd-250 wd-md-400">--%>
<%--        <input class="form-control" placeholder="Search for page" type="search">--%>
<%--        <button class="btn" type="button"><i data-feather="search"></i></button>--%>
<%--    </div><!-- search-form -->--%>
</div><!-- error-panel -->

<script src="../lib/jquery/jquery.min.js"></script>
<script src="../lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../lib/feather-icons/feather.min.js"></script>
<script>
    $(function () {

        'use strict'

        feather.replace();

    })
</script>
</body>
</html>
