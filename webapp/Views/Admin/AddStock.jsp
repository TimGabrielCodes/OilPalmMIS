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
        <h4 class="content-title content-title-xs">Document Milling Activity</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->


<div class="content-body">
    <form class="form-group" method="get" name="validateBatchForm"
          action="${pageContext.request.contextPath}/validateBatch">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="batch">Select Harvest Batch to Mill</label>
                <select id="batch" class="col form-control" name="batch" placeholder="Select Harvest"
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
                    <option class="form-control" value="<%=batch_id%>"><%=selectedBatchName%>
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
        <br>
        <div class="form-group">
            <button class="btn btn-success" type="submit"> Log Mill</button>
        </div>

    </form>
    <span class="alert">${message}</span>
    <form method="POST" action="${pageContext.request.contextPath}/mills">
        <input type="hidden" name="harId" value="${harvest.id}">
        <hr class="hr-component-section">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="harvestStock">Harvest Batch Name</label>
                <input id="batchName" type="text" name="batchName" value="${harvest.batch.batchName}"
                       class="form-control" required="true" min="0" disabled><br>
            </div>


        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="harvestStock">Harvest Stock in Bunches</label>
                <input id="harvestStock" type="number" name="stockInBunches" value="${harvest.stockInBunches}"
                       class="form-control" required="true" min="0" disabled><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="harvestStockCost">Harvest Stock Cost <span>(&#8358;)</span></label>
                <input id="harvestStockCost" type="number" name="harvestStockCost" value="${harvest.harvestStockCost}"
                       class="form-control" required="true" min="0" step=".01" disabled><br>
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
                <input id="fuel" type="number" name="fuel" value="${millingExpense.fuel}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="storage">Storage Cost
                    <span>(&#8358;)</span></label>
                <input id="storage" type="number" name="storage" value="${millingExpense.storage}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>


            <div class="col">
                <label class="col-form-label col-form-label-lg" for="numberOfPresses">Number of Presses</label>
                <input type="text" id="numberOfPresses" name="numberOfPresses" value="${mill.numberOfPresses}"
                       class="form-control"/>
            </div>

        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="adhocLabour">Adhoc Labour
                    <span>(&#8358;)</span></label>
                <input id="adhocLabour" type="number" name="adhocLabour" value="${millingExpense.adhocLabour}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="firewood">Firewood Cost
                    <span>(&#8358;)</span></label>
                <input id="firewood" type="number" name="firewood" value="${millingExpense.firewood}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="plantParts">Plant Parts Cost <span>(&#8358;)</span></label>
                <input id="plantParts" type="number" name="plantParts" value="${millingExpense.plantParts}"
                       class="form-control"  min="0" step=".01"><br>
            </div>


            </br>

            <div class="row">
                <div class="col">
                    <input type="hidden" value="${mill.id}" name="millId"/>

                </div>
            </div>
            </br>
        </div>

        <div class="form-group">
            <button class="btn btn-primary" type="submit"> Log Mill</button>
        </div>


    </form>

    <!-- content-body -->
</div>
<!-- content -->
<%@include file="AdminFooter.jsp" %>
