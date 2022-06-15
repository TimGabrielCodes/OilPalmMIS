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
            <th>Stock Name</th>
            <th>Quantity</th>
            <th>Selling Price</th>
            <th>Unit</th>
            <th>Action</th>



        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="stock" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${stock.name}</td>
                <td>${stock.quantity}</td>
                <td>${stock.sellingPrice}</td>
                <td>${stock.productUnit}</td>


                <td>
                    <a href="${pageContext.request.contextPath}/mills?action=EDIT&id=${mill.id}">Update</a>
          ]\
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
