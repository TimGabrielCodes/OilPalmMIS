
<%@include file="AdminHeader.jsp"%>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">Batches</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Sales History</h4>

    </div>
    <div class="info">

    </div>


</div><!-- content-header -->
<div class="content-body">




    <table  class="" id="datatable">
        <thead>
        <tr class="thead-light">
            <th>SN</th>
            <th>Received By</th>
            <th>Income Type</th>
            <th>Amount (Naira)</th>
            <th>Received From</th>
<%--            <th>Action</th>--%>



        </tr>
        </thead>
        <%--<%@page import="javax.xml.bind.DatatypeConverter"%>
        <%@page import="javax.imageio.ImageIO"%>
        <%@page import="java.awt.image.*"%>
        <%@page import="java.io.*"%>--%>
        <tbody>

        <c:forEach items="${list}" var="income" varStatus="loop">
            <tr>  <td>${loop.index+1}</td>
                <td>${income.logger.fullName}</td>
                <td>${income.incomeType}</td>
                <td>${income.amount}</td>
                <td>${income.receivedFrom}</td>
<%--                <td>--%>
<%--                    <a href="${pageContext.request.contextPath}/sales?action=EDIT&id=${income.id}">Edit</a>--%>
<%--                    |--%>
<%--                    <a href="${pageContext.request.contextPath}/sales?action=DELETE&id=${income.id}">Delete</a>--%>
<%--                </td>--%>


            </tr>
        </c:forEach>
        </tbody>


    </table>
    <button class="btn btn-primary pull-right" onclick="window.location.href = 'sales?action=NEW'">Make Sales</button>
<%--    <button class="btn btn-primary pull-left " onclick="window.location.href = 'incomees?action=ADDBATCH'"></button>--%>
    <div>
        <p> ${message} </p>
    </div>

</div><!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp"%>
