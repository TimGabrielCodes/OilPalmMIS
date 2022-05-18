<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Transactions</a></li>
                <li class="breadcrumb-item active" aria-current="page">Make Sales</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Make Sales</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">
    <form method="POST" action="${pageContext.request.contextPath}/sales">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="incomeType">Select Income Type</label>
                <select id="incomeType" class=" form-control col-form-select-lg" name="incomeType"
                        placeholder="Select Income Type"
                        data-value="${income.incomeType}" required>
                    <option value="CRUDE_PALM_OIL">Crude Palm Oil</option>
                    <option value="FIBRE_PALM_OIL">Fibre Palm Oil</option>
                    <option value="MILLING_CHARGE_PO">Milling Charge PO</option>
                    <option value="PKO">PKO</option>
                    <option value="PKC">PKC</option>
                    <option value="PKS">PKS</option>
                    <option value="MILLING_CHARGE_PKO">Milling Charge PKO</option>
                    <option value="KERNEL_SHELLS">Kernel Shells</option>
                    <%--                    <option class="form-control" value="<%=selectedBatchName%>"><%=selectedBatchName%>--%>
                    </option>
                </select>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="productUnit">Select Product Unit</label>
                <select id="productUnit" class=" form-control col-form-select-lg" name="productUnit"
                        placeholder="Select  product unit"
                        data-value="${income.productUnit}" required>
                    <option value="CANS">Cans</option>
                    <option value="DRUMS">Drums</option>
                    <option value="BAGS_50KG">50kg Bags</option>
                    <option value="BAGS_25KG">25Kg Bags</option>

                    <%--                    <option class="form-control" value="<%=selectedBatchName%>"><%=selectedBatchName%>--%>
                    </option>
                </select>
            </div>
        </div>
        <div class="row">

            <div class="col">
                <label for="date" class="col-form-label-lg">Date Received</label>
                <input id="date" type="Date" name="date" value="${income.date}" placeholder="Date" class="form-control"
                       required="true"><br>
            </div>
            <div class="col">
                <label class="col-form-label-lg" for="logger">Payment Logged By:</label>
                <input type="text" id="logger" name="logger" value="<%out.print(getUserName());%>"
                       placeholder="logger name" class="form-control" disabled/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="amount">Amount Received
                    <span>(&#8358;)</span></label>
                <input id="amount" type="number" name="amount" value="${income.amount}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="receivedFrom">Payment Received From</label>
                <input id="receivedFrom" type="text" name="receivedFrom" value="${income.receivedFrom}"
                       class="form-control" required="true"><br>
            </div>

        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="remark">Remark </label>
                <textarea id="remark" name="remark" value="${income.remark}"
                          class="form-control" required="true" rows="3"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <input type="hidden" value="${income.id}" name="id"/>
            </div>
        </div>
        </br>

        <div class="form-group">
            <button class="btn btn-primary" type="submit">Save!</button>
        </div>


    </form>
</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
