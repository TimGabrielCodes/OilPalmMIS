
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
        <h4 class="content-title content-title-xs">Create New Batch</h4>

    </div>
    <div class="info">

    </div>


</div><!-- content-header -->
<div class="content-body">
    <form method="POST"  action="${pageContext.request.contextPath}/batches">
        <div class="row">
            <div class="col">
                <input type ="text" name="batchName" value="" placeholder="Batch Name" class="form-control" required="true"><br>
            </div>

        </div>
        <div class="row">

            <div class="col">
                <label for="batchDate">Batch Date</label>
                <input id="batchDate" type ="Date" name="batchDate" value="" placeholder="First Name" class="form-control" required="true"><br>
            </div>
            <div class="col"><label for="logger">Batch Logged By:</label>
            <input type ="text"  id="logger" name="logger" value="<%out.print(getUserName());%>" placeholder="logger name" class="form-control" disabled/>
        </div>

        </div>

        <div class="row">

        </div>
        </br>



        </br>

        <div class="row">
            <div class="col">
                <input type="hidden" value="" name="batchId"/>
            </div>
        </div>
        </br>

        <div class="form-group">
            <button class="btn btn-primary" type="submit"> Log Batch </button>
        </div>


    </form>
</div><!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp"%>
