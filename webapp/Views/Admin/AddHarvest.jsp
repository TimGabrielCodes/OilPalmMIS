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
                <li class="breadcrumb-item"><a href="#">Harvests</a></li>
                <li class="breadcrumb-item active" aria-current="page">Mills</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Add Harvest</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">
    <form method="POST" action="${pageContext.request.contextPath}/harvests">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="batch">Batch</label>
                <select id="batch" class=" form-control" name="batch" placeholder="Select Batch"
                        data-value="${harvest.batch}" required>
                    <option value="${harvest.batch}" selected="selected">-- Select Batch --</option>
                    <% try {
                        String query = "select * from batch where harvested = 0  order by batchName";
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

            <div class="col">
                <label class="col-form-label col-form-label-lg" for="logger">Harvest Logged By:</label>
                <input type="text" id="logger" name="logger" value="<%out.print(getUserName());%>"
                       placeholder="logger name" class="form-control" disabled/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="stockInBunches">Harvest Stock in Bunches</label>
                <input id="stockInBunches" type="number" name="stockInBunches" value="${harvest.stockInBunches}"
                       class="form-control" required="true" min="0"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="costPerBunch">Cost Per Bunch</label>
                <input type="number" id="costPerBunch" name="costPerBunch" value="${harvest.costPerBunch}"
                       class="form-control" required="true" min="0" step=".01"/>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="otherCosts">Other Costs</label>
                <input type="number" id="otherCosts" name="otherCosts" value="${harvest.otherCosts}"
                       class="form-control" required="true" min="0" step=".01"/>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="honorarium">Honorarium</label>
                <input type="number" id="honorarium" name="honorarium" value="${harvest.honorarium}"
                       class="form-control"  min="0" step=".01"/>
            </div>


        </div>
        <div class="row">

            <div class="col">
                <label class="col-form-label col-form-label-lg" for="dateHarvested">Harvesting Date</label>
                <input type="date" id="dateHarvested" name="dateHarvested" value="${harvest.dateAdded}"
                       class="form-control">
            </div>

        </div>

        <input type="hidden" value="${harvest.id}" name="id"/>


        <br>
        <div class="form-group">
            <button class="btn btn-primary" type="submit"> Save!!!</button>
        </div>


    </form>
</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
