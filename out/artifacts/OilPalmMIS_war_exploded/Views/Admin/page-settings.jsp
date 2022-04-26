
<%@include file="AdminHeader.jsp"%>
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
</div><!-- content-header -->
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
                      <input type="text" class="form-control" placeholder="Enter your fullname" value="${user.firstName}">
<%--                      <div class="tx-11 tx-sans tx-color-04 mg-t-5">Your name may appear around here where you are mentioned. You can change or remove it at any time.</div>--%>
                    </div><!-- form-group -->

                    <div class="form-group">
                      <label class="form-label">Other Names</label>
                      <input type="text" class="form-control" placeholder="" value="${user.otherNames}"/>
                    </div><!-- form-group -->

                    <div class="form-group">
                      <label class="form-label">Surname</label>
                      <input type="text" class="form-control" placeholder="Enter your website address" value="${user.surname}">
                    </div><!-- form-group -->

                    <div class="form-group">
                      <label class="form-label">email</label>
                      <input type="text" class="form-control"  value="${user.email}">
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
                      <label class="form-label">Change Old Password</label>
                      <input type="text" class="form-control" placeholder="Enter your old password">
                      <input type="text" class="form-control mg-t-5" placeholder="New password">
                      <input type="text" class="form-control mg-t-5" placeholder="Confirm new password">
                    </div><!-- form-group -->

                    <hr>

                    <div class="form-group">
                      <label class="form-label">Two Factor Authentication</label>
                      <button class="btn btn-brand-02 tx-sm">Enable two-factor authentication</button>
                      <div class="tx-11 tx-sans tx-color-04 mg-t-7">Two-factor authentication adds an additional layer of security to your account by requiring more than just a password to log in.</div>
                    </div><!-- form-group -->

                    <hr>


                  </div><!-- form-settings -->
                </div><!-- tab-pane -->
              </div><!-- tab-content -->
            </div><!-- card -->
          </div><!-- col -->
        </div><!-- row -->
      </div><!-- content-body -->
    </div><!-- content -->

   <%@include file="AdminFooter.jsp"%>