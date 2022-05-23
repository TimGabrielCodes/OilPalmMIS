<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">Batches</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Batches</h4>

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
            <th>Batch Date</th>
            <th> Batch Month</th>
            <th>Logger</th>
            <th>Harvested</th>
            <th>Action</th>


        </tr>
        </thead>
        <%--<%@page import="javax.xml.bind.DatatypeConverter"%>
        <%@page import="javax.imageio.ImageIO"%>
        <%@page import="java.awt.image.*"%>
        <%@page import="java.io.*"%>--%>
        <tbody>

        <c:forEach items="${list}" var="batch" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${batch.batchName}</td>
                <td>${batch.batchDate}</td>
                <td>${batch.batchMonth}</td>
                <td>${batch.logger.fullName}</td>
                <td>${batch.harvested}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/batches?action=EDIT&id=${batch.id}">Edit</a>
                    |
                    <a href="${pageContext.request.contextPath}/batches?action=DELETE&id=${batch.id}">Delete</a>
                </td>


            </tr>
        </c:forEach>
        </tbody>


    </table>
    <button class="btn btn-primary pull-right" onclick="window.location.href = 'batches?action=ADDBATCH'">View Batches
    </button>
    <button class="btn btn-primary pull-left " onclick="window.location.href = 'batches?action=ADDBATCH'">Add new
        Batch
    </button>
    <div>
        <p> ${message} </p>
    </div>

</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
