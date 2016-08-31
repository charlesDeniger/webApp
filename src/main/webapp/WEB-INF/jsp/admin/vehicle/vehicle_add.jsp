<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function(){
        var boxes = $("input:checkbox").click(function(){
            boxes.not(this).attr('checked', false);
        })

});
</script>

<div class="wrapper">
    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">

                <form:form cssClass="form-horizontal" modelAttribute="VehicleVO" action="/admin/vehicle/" method="post">

                    <p></p>
                    <fieldset>

                                <legend>Vehicle Management <h4>(Insert a Vehicle)</h4></legend>
                                <div class="form-group">
                                    <label for="inputYear" class="col-lg-2 control-label">Year</label>
                                    <div class="col-lg-10">
                                        <form:input path="vehicle.year" type="text" class="form-control" id="inputYear" placeholder="Year"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputLicense" class="col-lg-2 control-label">License Plate</label>
                                    <div class="col-lg-10">
                                        <form:input path="vehicle.licensePlate" type="text" class="form-control" id="inputLicense" placeholder="License Plate"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputVIN" class="col-lg-2 control-label"> VIN</label>
                                    <div class="col-lg-10">
                                        <form:input path="vehicle.VIN" type="text" class="form-control" id="inputVIN" placeholder="VIN"></form:input>
                                    </div>
                                </div>

                                    <div class="form-group">
                                        <label for="inputColor" class="col-lg-2 control-label"> Color</label>
                                        <div class="col-lg-10">
                                            <div class="checkbox">
                                                <label>
                                                    <form:checkbox path="vehicle.color" id="inputColor" value="red" ></form:checkbox>Red
                                                </label>
                                                <label>
                                                    <form:checkbox path="vehicle.color"  value="orange"></form:checkbox>Orange
                                                </label>
                                                <label>
                                                    <form:checkbox path="vehicle.color"  value="yellow"></form:checkbox>Yellow
                                                </label>
                                                <label>
                                                    <form:checkbox path="vehicle.color"  value="green"></form:checkbox>Green
                                                </label>
                                                <label>
                                                    <form:checkbox path="vehicle.color"  value="blue"></form:checkbox>Blue
                                                </label>
                                                <label>
                                                    <form:checkbox path="vehicle.color"  value="purple"></form:checkbox>Purple
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                <div class="form-group">
                                    <label for="selectMake" class="col-lg-2 control-label">Select Make</label>
                                    <div class="col-lg-10">
                                        <form:select path="vehicle.vehicleModel.vehicleMake" class="form-control" name="selectMake" id="selectMake">
                                            <c:forEach var="make" items="${newVehicleMakes}">

                                                <form:option value="${make.id}">${make.vehicleMakeName}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>



                                    <div class="form-group">
                                        <label for="selectModel" class="col-lg-2 control-label">Select Model</label>
                                        <div class="col-lg-10">
                                            <form:select path="vehicle.vehicleModel" class="form-control" name="selectModel" id="selectModel">
                                                <c:forEach var="model" items="${newVehicleModels}">

                                                    <form:option value="${model.id}">${model.vehicleModelName}</form:option>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>

                                <div class="form-group">
                                    <div class="col-lg-10 col-lg-offset-2">
                                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                                        <form:button type="submit" value="save" class="btn btn-primary">Submit</form:button>
                                    </div>
                                </div>


                    </fieldset>

                </form:form>
            </div>

            <div class="col-sm-4">
                <img src="\static\images\jon.PNG" class="img-polaroid" width="100%">
                <blockquote>
                    <p>"I'm gone for a few hours and you've already thrown me underneath the bus?"</p>
                    <small>Jon Gille from <cite title="Source Title">Aston Tech</cite></small>
                </blockquote>
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
                        <p>All fields required. Please enter an Element Type and associated Elements separated by a new line. <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
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
<%--</div>--%>

<%--<select class="form-control" id="selectMake">--%>
    <%--<c:forEach var="vehicleMake" items="${vehicleMake.vehicleMakeList}">--%>
    <%--<form:hidden path="vehicleList[${idx}].id" />--%>
    <%--<form:hidden path="vehicleList[${idx}].version" />--%>
    <%--<div class="form-group">--%>
        <%--<div class="col-lg-10">--%>
            <%--<label for="${idx}" class="col-lg-2 control-label">Select Make</label>--%>

            <%--<form:option path="adsf" value="${vehicleMake.vehicleMakeName}">${vehicleMake.vehicleMakeName}</form:option>--%>

            <%--<c:set var="idx" value="${idx + 1}" scope="page"/>--%>
        <%--</div>--%>
        <%--</c:forEach>--%>
<%--</select>--%>
<%--</fieldset>--%>

<%--</div>--%>
<%--</div>--%>
