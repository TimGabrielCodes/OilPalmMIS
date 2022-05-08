<%@ page import="java.sql.Connection" %>
<%@ page import="Util.DBConnectionUtil" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@include file="AdminHeader.jsp" %>
<%!
    String selectedBatchName = null;
    int batch_id = 0;

%>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">Mills</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Create New Mill</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">
    <form method="POST" action="${pageContext.request.contextPath}/mills">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="batch">Batch</label>
                <select id="batch" class=" form-control" name="batch" placeholder="Select Batch"
                        data-value="${mill.batch}" required>
                    <option value="${mill.batch}" selected="selected">-- Select Batch --</option>
                    <% try {
                        String query = "select * from batch order by batchName";
                        Connection conn = DBConnectionUtil.openConnection();
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery(query);
                        while (rs.next()) {
                            selectedBatchName = rs.getString("batchName");
                            batch_id = rs.getInt("id");
                    %>
                    <option class="form-control" value="<%=selectedBatchName%>"><%=selectedBatchName%>
                    </option>
                    <%
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            out.println("Error" + ex.getMessage());
                        }
                    %>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="harvestStock">Harvest Stock in Bunches</label>
                <input id="harvestStock" type="number" name="harvestStock" value="${mill.harvestStock}"
                       class="form-control" required="true" min="0"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="numberOfPresses">Number of Presses</label>
                <input type="text" id="numberOfPresses" name="numberOfPresses" value="${mill.numberOfPresses}"
                       class="form-control"/>
            </div>

        </div>


        <div class="row">

            <div class="col">
                <label class="col-form-label col-form-label-lg" for="millingDate">Milling Date</label>
                <input type="date" id="millingDate" name="millingDate" value="${mill.millingDate}" class="form-control">
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="logger">Mill Logged By:</label>
                <input type="text" id="logger" name="logger" value="<%out.print(getUserName());%>"
                       placeholder="logger name" class="form-control" disabled/>
            </div>
        </div>
        <hr>
        <h3>Milling Expenses</h3>

        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="fuel">Fuel <span>(&#8358;)</span></label>
                <input id="fuel" type="number" name="fuel" value="${mill.millingExpense.fuel}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="storage">Storage Cost
                    <span>(&#8358;)</span></label>
                <input id="storage" type="number" name="storage" value="${mill.millingExpense.storage}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
            <label class="col-form-label col-form-label-lg" for="harvestStockCost">Harvest Stock Cost
                <span>(&#8358;)</span></label>
            <input id="harvestStockCost" type="number" name="harvestStockCost"
                   value="${mill.millingExpense.harvestStockCost}"
                   class="form-control" required="true" min="0" step=".01"><br>
        </div>
        </div>


<div class="col">
<h5>Adhoc Labour Costs</h5>

    <input type="number" class="form-control" required="true" min="0" step=".01" id="ad" name="adhocLabour" value="${mill.millingExpense.adhocLabour}">
</div>



<div class="col">

    <label class="col-form-label col-form-label-lg" for="firewood">Firewood Cost <span>(&#8358;)</span></label>
    <input id="firewood" type="number" name="firewood" value="${mill.millingExpense.firewood}"
           class="form-control" required="true" min="0" step=".01"><br>
</div>
<div class="col">
    <label class="col-form-label col-form-label-lg" for="fruitPurchase">Fruit Purchase Cost
        <span>(&#8358;)</span></label>
    <input id="fruitPurchase" type="number" name="fruitPurchase" value="${mill.millingExpense.fruitPurchase}"
           class="form-control" required="true" min="0" step=".01"><br>
</div>
<div class="col">
    <label class="col-form-label col-form-label-lg" for="plantParts">Plant Parts Cost <span>(&#8358;)</span></label>
    <input id="plantParts" type="number" name="plantParts" value="${mill.millingExpense.plantParts}"
           class="form-control" required="true" min="0" step=".01"><br>
</div>


</br>

<div class="row">
    <div class="col">
        <input type="hidden" value="${mill.id}" name="millId"/>

    </div>
</div>
</br>


<div class="form-group">
    <button class="btn btn-primary" type="submit"> Log Mill</button>
</div>


</form>
</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
