<%@include file="AdminHeader.jsp" %>
<div class="content-header">

    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item"><a href="#">User Pages</a></li>
                <li class="breadcrumb-item active" aria-current="page">Profile Settings</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-sm">Profile Settings</h4>
    </div>
</div>
<!-- content-header -->
<div class="content-body">
    <div class="row row-xs">
        <div class="col-md-4">
            <ul class="list-group list-group-settings">
                <li class="list-group-item list-group-item-action">
                    <a href="#paneProfile" data-toggle="tab" class="media active">
                        <i data-feather="user"></i>
                        <div class="media-body">
                            <h6>Profile Information</h6>
                            <span>About your personal information</span>
                        </div>
                    </a>
                </li>
                <li class="list-group-item list-group-item-action">
                    <a href="#paneAccount" data-toggle="tab" class="media">
                        <i data-feather="settings"></i>
                        <div class="media-body">
                            <h6>Account Settings</h6>
                            <span>Manage your account setting options</span>
                        </div>
                    </a>
                </li>
                <li class="list-group-item list-group-item-action">
                    <a href="#paneSecurity" data-toggle="tab" class="media">
                        <i data-feather="shield"></i>
                        <div class="media-body">
                            <h6>Security</h6>
                            <span>Manage your security information</span>
                        </div>
                    </a>
                </li>
                <li class="list-group-item list-group-item-action">
                    <a href="#paneNotification" data-toggle="tab" class="media">
                        <i data-feather="bell"></i>
                        <div class="media-body">
                            <h6>Notification</h6>
                            <span>Choose how you receive notifications</span>
                        </div>
                    </a>
                </li>
                <li class="list-group-item list-group-item-action">
                    <a href="#paneBilling" data-toggle="tab" class="media">
                        <i data-feather="credit-card"></i>
                        <div class="media-body">
                            <h6>Billing</h6>
                            <span>Your billing and payment information</span>
                        </div>
                    </a>
                </li>
            </ul>
        </div><!-- col -->
        <div class="col-md-8">
            <div class="card card-body pd-sm-40 pd-md-30 pd-xl-y-35 pd-xl-x-40">
                <div class="tab-content">
                    <div id="paneProfile" class="tab-pane active show">
                        <h6 class="tx-uppercase tx-semibold tx-color-01 mg-b-0">Your Profile Information</h6>
                        <hr>
                        <div class="form-settings">
                            <div class="form-group">
                                <label class="form-label">First Name</label>
                                <input type="text" class="form-control" placeholder="Enter your fullname"
                                       value="${user.firstName}">
                                <%--                      <div class="tx-11 tx-sans tx-color-04 mg-t-5">Your name may appear around here where you are mentioned. You can change or remove it at any time.</div>--%>
                            </div><!-- form-group -->

                            <div class="form-group">
                                <label class="form-label">Other Names</label>
                                <input type="text" class="form-control" placeholder="" value="${user.otherNames}"/>
                            </div><!-- form-group -->

                            <div class="form-group">
                                <label class="form-label">Surname</label>
                                <input type="text" class="form-control" placeholder="Enter your website address"
                                       value="${user.surname}">
                            </div><!-- form-group -->

                            <div class="form-group">
                                <label class="form-label">email</label>
                                <input type="text" class="form-control" value="${user.email}">
                            </div><!-- form-group -->

                            <div class="form-group tx-13 tx-color-04">
                                All of the fields on this page are read only.
                            </div>

                            <hr class="op-0">

                            <%--                    <button class="btn btn-brand-02">Update Profile</button>--%>
                            <%--                    <button class="btn btn-white mg-l-2">Reset Changes</button>--%>
                        </div>
                    </div><!-- tab-pane -->
                    <%--                <div id="paneAccount" class="tab-pane">--%>
                    <%--                  <h6 class="tx-uppercase tx-semibold tx-color-01 mg-b-0">Account Settings</h6>--%>

                    <%--                  <hr>--%>
                    <%--                  <div class="form-settings">--%>
                    <%--                    <div class="form-group">--%>
                    <%--                      <label class="form-label">Username</label>--%>
                    <%--                      <input type="text" class="form-control" placeholder="Enter your username" value="dwayne.johnson">--%>
                    <%--                      <div class="tx-11 tx-sans tx-color-04 mg-t-5">After changing your username, your old username becomes available for anyone else to claim.</div>--%>
                    <%--                    </div><!-- form-group -->--%>

                    <%--                    <hr>--%>

                    <%--                    <div class="form-group">--%>
                    <%--                      <label class="form-label text-danger">Delete Account</label>--%>
                    <%--                      <p class="tx-sm tx-color-04">Once you delete your account, there is no going back. Please be certain.</p>--%>
                    <%--                      <button class="btn btn-sm btn-danger">Delete Account</button>--%>
                    <%--                    </div><!-- form-group -->--%>
                    <%--                  </div><!-- form-settings -->--%>
                    <%--                </div><!-- tab-pane -->--%>
                    <div id="paneSecurity" class="tab-pane">
                        <h6 class="tx-uppercase tx-semibold tx-color-01 mg-b-0">Security Settings</h6>
                        <hr>
                        <div class="form-settings">
                            <div class="form-group">
                                <form name="changePasswordForm" method="post" action="${pageContext.request.contextPath}/changePassword"
                                      onsubmit="return validateForm()">
                                    <label class="form-label">Change Old Password</label>

                                    <input type="password" class="form-control" id="oldPassword"
                                           placeholder="Enter your old password" name="oldPassword">

                                    <input type="password" class="form-control mg-t-5" id="newPassword1"
                                           placeholder="New password" name="newPassword1">

                                    <input type="password" class="form-control mg-t-5" id="newPassword2"
                                           placeholder="Confirm new password" name="newPassword2">
                                    <%--                     form-group -->--%>

                                    <hr>

                                    <div class="form-group">
                                        <label class="form-label" id="blankMsg"></label>
                                        <button type="submit" class="btn btn-brand-02 tx-sm">Change Password</button>
                                        <%--                      <div class="tx-11 tx-sans tx-color-04 mg-t-7">Two-factor authentication adds an additional layer of security to your account by requiring more than just a password to log in.</div>--%>

                                </form>
                            </div><!--
  </div>


                    <hr>



                </div>
                <!-- tab-pane -->
                        </div><!-- tab-content -->
                    </div><!-- card -->
                </div><!-- col -->
            </div><!-- row -->
        </div><!-- content-body -->
    </div><!-- content -->

    <script>
        function validateForm() {
            console.log("Funcetion called");
            //collect form data in JavaScript variables
            const oldPw = document.getElementById("password").value;
            const pw1 = document.getElementById("newPassword1").value;
            const pw2 = document.getElementById("newPassword2").value;


            if (!(oldPw == document.getElementsByName("oldPw")) || oldPw == "") {
                document.getElementById("blankMsg").innerHTML = "**Invalid Old Password";
                return false;
            }
            //check empty password field
            if (pw1 == "") {
                document.getElementById("message1").innerHTML = "**Fill the password please!";
                return false;
            }

            //check empty confirm password field
            if (pw2 == "") {
                document.getElementById("message2").innerHTML = "**Enter the password please!";
                return false;
            }

            //minimum password length validation
            if (pw1.length < 8) {
                document.getElementById("message1").innerHTML = "**Password length must be atleast 8 characters";
                return false;
            }

            //maximum length of password validation
            if (pw1.length > 15) {
                document.getElementById("message1").innerHTML = "**Password length must not exceed 15 characters";
                return false;
            }

            if (pw1 != pw2) {
                document.getElementById("message2").innerHTML = "**Passwords are not same";
                return false;
            } else {

                alert("Your password created successfully");
                document.write("JavaScript form has been submitted successfully");
                return true;
            }
        }
    </script>

<%@include file="AdminFooter.jsp" %>