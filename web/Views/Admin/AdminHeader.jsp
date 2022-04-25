<%@ page import="DAO.UserDAO" %>
<%@ page import="DAO.UserDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/04/2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    String email;
    UserDAO userDAO = new UserDAOImpl();

    public String getEmail() {


        return email;
    }


    public String getUserName() {
        String fName = userDAO.getLogger("zinwotatimothy@gmail.com").getFullName();


        return fName;
    }
%>
<%
    try{
        email = (String) session.getAttribute("email");
        if (email == null) {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e){
        response.sendRedirect("/Error_Pages/page-500.jsp");
    }

%>


<html lang="en">
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Meta -->
    <meta name="description" content="Responsive Bootstrap 4 Dashboard and Admin Template">
    <meta name="author" content="ThemePixels">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

    <title>
        <%out.print(request.getAttribute("title")); %>
    </title>

    <!-- vendor css -->
    <link href="lib/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="lib/jqvmap/jqvmap.min.css" rel="stylesheet">

    <!-- template css -->
    <link rel="stylesheet" href="assets/css/cassie.css">
</head>
<body>

<div class="sidebar">
    <div class="sidebar-header">
        <div>
            <a href="../index.html" class="sidebar-logo"><span>OPM</span></a>
            <small class="sidebar-logo-headline">Oil Plantation MIS</small>
        </div>
    </div><!-- sidebar-header -->
    <div id="dpSidebarBody" class="sidebar-body">
        <ul class="nav nav-sidebar">
            <li class="nav-label"><label class="content-label">Actions</label></li>
            <li class="nav-item show">
                <a href="" class="nav-link with-sub active"><i data-feather="box"></i> Dashboard</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link active">Analytics &amp; Monitoring</a>
                    <a href="#" class="nav-sub-link">Projects &amp; Web Services</a>
                    <a href="#" class="nav-sub-link">Blog &amp; Social Media</a>
                </nav>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link with-sub"><i data-feather="layout"></i> Mills</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link">Document Milling Activity</a>
                    <a href="#" class="nav-sub-link">View Milling Activities</a>
                    <a href="#" class="nav-sub-link">Analytics</a>
                </nav>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link with-sub"><i data-feather="lock"></i> Harvests</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link"></a>
                    <a href="#" class="nav-sub-link">Sign Up</a>
                    <a href="#" class="nav-sub-link">Forgot Password</a>
                </nav>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link with-sub"><i data-feather="printer"></i> Transactions</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link">Log Transactions</a>
                    <a href="#" class="nav-sub-link">View Transactions</a>
                    <a href="#" class="nav-sub-link">Income</a>
                    <a href="#" class="nav-sub-link">Reports</a>
                </nav>
            </li>    <li class="nav-item">
                <a href="" class="nav-link with-sub"><i data-feather="send"></i> Expenses</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link">Expenditures</a>
                    <a href="#" class="nav-sub-link">Create Expenditures</a>
                    <a href="#" class="nav-sub-link">Reports</a>
<%--                    <a href="page-505.html" class="nav-sub-link">Forbidden Access</a>--%>
                </nav>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link with-sub"><i data-feather="user"></i> Users</a>
                <nav class="nav nav-sub">
                    <a href="#" class="nav-sub-link">All Users</a>
                    <a href="#" class="nav-sub-link">Add Users</a>
<%--                    <a href="page-people.html" class="nav-sub-link">People</a>--%>
<%--                    <a href="page-settings.html" class="nav-sub-link">Profile Settings</a>--%>
                </nav>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a href="" class="nav-link with-sub"><i data-feather="file-text"></i> Extras</a>--%>
<%--                <nav class="nav nav-sub">--%>
<%--                    <a href="page-invoice.html" class="nav-sub-link">Invoice</a>--%>
<%--                    <a href="page-pricing.html" class="nav-sub-link">Pricing</a>--%>
<%--                </nav>--%>
<%--            </li>--%>
        </ul>


    </div><!-- sidebar-body -->
</div><!-- sidebar -->

<div class="content">
    <div class="header">
        <div class="header-left">
            <a href="" class="burger-menu"><i data-feather="menu"></i></a>

            <div class="header-search">
                <i data-feather="user"></i>
                Welcome, <%out.print(getUserName());%>
            </div><!-- header-search -->
        </div><!-- header-left -->

        <div class="header-right">
<%--            <a href="" class="header-help-link"><i data-feather="help-circle"></i></a>--%>
            <div class="dropdown dropdown-notification">
                <a href="" class="dropdown-link new" data-toggle="dropdown"><i data-feather="bell"></i></a>
                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-menu-header">
                        <h6>Notifications</h6>
                        <a href=""><i data-feather="more-vertical"></i></a>
                    </div><!-- dropdown-menu-header -->
                    <div class="dropdown-menu-body">
                        <a href="" class="dropdown-item">
                            <div class="avatar"><span class="avatar-initial rounded-circle text-primary bg-primary-light">s</span></div>
                            <div class="dropdown-item-body">
                                <p><strong>Socrates Itumay</strong> marked the task as completed.</p>
                                <span>5 hours ago</span>
                            </div>
                        </a>
                        <a href="" class="dropdown-item">
                            <div class="avatar"><span class="avatar-initial rounded-circle tx-pink bg-pink-light">r</span></div>
                            <div class="dropdown-item-body">
                                <p><strong>Reynante Labares</strong> marked the task as incomplete.</p>
                                <span>8 hours ago</span>
                            </div>
                        </a>
                        <a href="" class="dropdown-item">
                            <div class="avatar"><span class="avatar-initial rounded-circle tx-success bg-success-light">d</span></div>
                            <div class="dropdown-item-body">
                                <p><strong>Dyanne Aceron</strong> responded to your comment on this <strong>post</strong>.</p>
                                <span>a day ago</span>
                            </div>
                        </a>
                        <a href="" class="dropdown-item">
                            <div class="avatar"><span class="avatar-initial rounded-circle tx-indigo bg-indigo-light">k</span></div>
                            <div class="dropdown-item-body">
                                <p><strong>Kirby Avendula</strong> marked the task as incomplete.</p>
                                <span>2 days ago</span>
                            </div>
                        </a>
                    </div><!-- dropdown-menu-body -->
                    <div class="dropdown-menu-footer">
                        <a href="">View All Notifications</a>
                    </div>
                </div><!-- dropdown-menu -->
            </div>
            <div class="dropdown dropdown-loggeduser">
                <a href="" class="dropdown-link" data-toggle="dropdown">
                    <div class="avatar avatar-sm">
                        <img src="https://via.placeholder.com/500/637382/fff" class="rounded-circle" alt="">
                    </div><!-- avatar -->
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-menu-header">
                        <div class="media align-items-center">
                            <div class="avatar">
                                <img src="https://via.placeholder.com/500/637382/fff" class="rounded-circle" alt="">
                            </div><!-- avatar -->
                            <div class="media-body mg-l-10">
                                <h6><%out.print(getUserName());%></h6>
                                <span>Administrator</span>
                            </div>
                        </div><!-- media -->
                    </div>
                    <div class="dropdown-menu-body">
                        <a href="${pageContext.request.contextPath}/admin?action=VIEWPROFILE" class="dropdown-item"><i data-feather="user"></i> View Profile</a>
                        <a href="" class="dropdown-item"><i data-feather="edit-2"></i> Edit Profile</a>
                        <a href="" class="dropdown-item"><i data-feather="briefcase"></i> Account Settings</a>
                        <a href="" class="dropdown-item"><i data-feather="shield"></i> Privacy Settings</a>
                        <a href="${pageContext.request.contextPath}/Logout.jsp"  class="dropdown-item"><i data-feather="log-out"></i> Sign Out</a>
                    </div>
                </div><!-- dropdown-menu -->
            </div>
        </div><!-- header-right -->
    </div><!-- header -->
