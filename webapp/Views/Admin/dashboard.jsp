<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/04/2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Dashboard, Charts and Analytics</h4>
    </div>
</div>
<!-- content-header -->
<div class="content-body">
    <div class="stat-profile">
        <div class="stat-profile-body">
            <div class="row row-xs">
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-primary-light">
                        <h1 class="tx-light tx-sans tx-spacing--4 tx-primary mg-b-5">${util.unmilledBatches}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-02 mg-b-0">Harvests to be Milled</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-teal-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-teal">${util.milledBatches}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Milled Harvests</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-pink-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink">${util.month}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Current Batch Month</p>
                    </div>
                </div>
            </div><!-- row -->
        </div><!-- stat-profile-body -->
    </div><!-- stat-profile -->
<%--    <div class="component-section no-code">--%>
<%--        <h5 id="section7" class="tx-semibold">Income Generated from Sources</h5>--%>

<%--            <div class="ht-250 ht-lg-300">--%>
<%--                <canvas id="incomeVSsource"></canvas>--%>
<%--            </div>--%>

<%--    </div><!-- component-section -->--%>
    <div class="row">
        <div class="col-sm-12">
            <canvas id="incomeVsSource"></canvas>
        </div>
    </div>



            <script>
                let jsonfile = ${dataPoints}

                const labels = jsonfile.map(function (e) {
                    return e.x;
                });
                const data = jsonfile.map(function (e) {
                    return e.y;
                });
                ;
                const ctx = document.getElementById('incomeVsSource').getContext('2d');
                const config = {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Income vs Source',
                            data: data,
                            backgroundColor: 'rgba(0, 119, 204, 0.3)'
                        }]
                    }
                };

                const chart = new Chart(ctx, config);
            </script>
        </div>
        <!-- content-body -->
    </div><!-- content -->
    <%@include file="AdminFooter.jsp" %>

