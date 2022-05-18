<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">mills</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Mills</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">


    <table class="" id="datatable">
        <thead>
        <tr class="thead-light">
            <th>SN</th>
            <th>Batch Name</th>
            <th>Harvest Stock (Bunches)</th>
            <th>Number of Presses</th>
            <th>Milling Date</th>
            <th>Logger</th>
            <th>Action</th>


        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="mill" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${mill.batch.batchName}</td>
                <td>${mill.harvestStock}</td>
                <td>${mill.numberOfPresses}</td>
                <td>${mill.millingDate}</td>
                <td>${mill.logger.fullName}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/mills?action=EDIT&id=${mill.id}">Edit</a>
                    |
                    <a href="${pageContext.request.contextPath}/mills?action=DELETE&id=${mill.id}">Delete</a>
                </td>


            </tr>
        </c:forEach>
        </tbody>


    </table>
    <button class="btn btn-primary pull-right" onclick="window.location.href = 'mills'">View mills</button>
    <button class="btn btn-primary pull-left " onclick="window.location.href = 'mills?action=ADD'">Add new mill</button>
    <div>
        <p> ${message} </p>
    </div>

</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
