<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>

    $(document).ready(function(){
        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(10000).fadeOut(2000);

    });
</script>
<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="VehicleMake" action="/admin/vehicle_makes/update" method="post">

                <fieldset>
                    <legend>Vehicle Makes</legend>

                    <c:forEach items="${vehicleMakeList}" var="vehicleMake">

                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-3" for="makes"><a href="/admin/vehicle_models/${vehicleMake.id}">Edit Models</a></label>
                                <div class="col-sm-7">
                                    <div class="input-group">

                                        <form:input path="vehicleMakeName" id="makes" cssClass="form-control" value="${vehicleMake.vehicleMakeName}"></form:input>
                                        <span class="input-group-addon" >
                                                <a href="/admin/vehicle_makes/delete/${vehicleMake.id}">Remove</a>
                                        </span>
                                        <input type="hidden" path="id" name="ids" value="${vehicleMake.id}"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-3" for="inputNewMake">Add New <br> Vehicle Make:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="inputNewMake" id="inputNewMake"/>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <form:button class="btn btn-primary" type="submit">Update</form:button>
                    </div>
                </fieldset>

            </form:form>
        </div>

        <div class="col-sm-4">

            <%--ALERTS--%>
            <%--SUCCESS ALERT--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert" >
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element Added Successfully To The Database!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
            <%--WARNING ALERT--%>
            <div class="${warningAlert == null ? 'hidden' : successAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required. Please enter an Element Type and associated Elements seperated by a new line. <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <%--ERROR ALERT--%>
            <div class="${errorAlert == null ? 'hidden' : successAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp"%>