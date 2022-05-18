<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">Harvests</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Harvests</h4>

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
            <th>Batch</th>
            <th>Stock In Bunches</th>
            <th>Cost Per Bunch</th>
            <th>Other Costs</th>
            <th>Honorarium</th>
            <th>Date Added</th>
            <th>Milled</th>
            <th>Logger</th>


        </tr>
        </thead>
        <tbody>
        <fmt:setLocale value = "en_NG"/>
        <c:forEach items="${list}" var="harvest" varStatus="loop">
            <tr>

                <td>${loop.index+1}</td>
                <td>${harvest.batch.batchName}</td>
                <td>${harvest.stockInBunches}</td>
                <td>
                    <fmt:formatNumber value = "${harvest.costPerBunch}" type = "currency"/>
                </td>
                <td>
                    <fmt:formatNumber value = "${harvest.otherCosts}" type = "currency"/></td>
                <td>
                    <fmt:formatNumber value = "${harvest.honorarium}" type = "currency"/>
                </td>
                <td>${harvest.dateAdded}</td>
                <td>${harvest.milled}</td>
                <td>${harvest.logger.fullName}</td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
    <button class="btn btn-primary pull-right" onclick="window.location.href = 'harvests'">View Harvests</button>
    <button class="btn btn-primary pull-left " onclick="window.location.href = 'harvests?action=NEW'">Add new Harvest
    </button>
    <div>
        <p> ${message} </p>
    </div>

</div>
<!-- content-body -->
</div>
<!-- content -->
<%@include file="AdminFooter.jsp" %>
