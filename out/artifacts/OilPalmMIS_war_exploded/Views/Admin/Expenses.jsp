<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Expenses</a></li>
                <li class="breadcrumb-item active" aria-current="page">Expenditures</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Expense History</h4>

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
            <th>Category</th>
            <th>Amount Spent</th>
            <th>Remark</th>
            <th>Date</th>
            <th>Logger</th>
        </tr>
        </thead>
        <tbody>
        <fmt:setLocale value="en_NG"/>
        <c:forEach items="${list}" var="expense" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${expense.expenseCategory}</td>
                <td><fmt:formatNumber value = "${expense.amount}" type = "currency"/>
                </td>
                <td>${expense.remark}</td>
                <td>${expense.date}</td>
                <td>${expense.logger.fullName}</td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
    <button class="btn btn-primary pull-right" onclick="window.location.href = 'sales?expenses=NEW'">Make Sales</button>
    <%--    <button class="btn btn-primary pull-left " onclick="window.location.href = 'incomees?action=ADDBATCH'"></button>--%>
    <div>
        <p> ${message} </p>
    </div>

</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
