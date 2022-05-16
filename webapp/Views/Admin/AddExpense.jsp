<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Expenses</a></li>
                <li class="breadcrumb-item active" aria-current="page">Create Expenditure</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Create New Expenditure</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">
    <form method="POST" action="${pageContext.request.contextPath}/expenses">
        <div class="row">
            <div class="col">
                <label class="col-form-label-lg" for="expenseCategory"> Select Expenditure Category </label>
                <select id="expenseCategory" class="form-control col-form-select-lg" name="category"
                        placeholder="Select Expense Category" data-value="${expense.expenseCategory}" required>
                    <option value="FIELD_CUTTING">Field Cutting</option>
                    <option value="BUSH_CUTTING">Bush Cutting</option>
                    <option value="PALM_PRUNING">Palm Pruning</option>
                    <option value="HARVEST_COST">Harvest Cost</option>
                    <option value="HONORARIUM">Honorarium</option>
                    <option value="OTHERS_PR">Others/PR</option>
                </select>
            </div>
            <div class="col">
                <label for="amount" class="col-form-label-lg">Amount Spent</label>
                <input id="amount" type="number" name="amount" value="${expense.amount}" class="form-control"
                       required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label for="date" class="col-form-label-lg"> Date</label>
                <input type="date" id="date" name="date" value="${expense.date}" class="form-control" required="true"
                       min="0"/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label for="remark" class="col-form-label-lg">Remarks</label>
                <textarea id="remark" name="remark" value="${expense.remark}" class="form-control" required="true"
                          min="0" col></textarea>

            </div>

        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label-lg" for="logger">Expense Logged By:</label>
                <input type="text" id="logger" name="logger" value="<%out.print(getUserName());%>"
                       placeholder="logger name" class="form-control" disabled/>

            </div>
        </div>
        </br>


        </br>

        <div class="row">
            <div class="col">
                <input type="hidden" value="${expense.id}" name="expenseId"/>
            </div>
        </div>
        </br>

        <div class="form-group">
            <button class="btn btn-primary" type="submit"> Log Expense</button>
        </div>


    </form>
</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
