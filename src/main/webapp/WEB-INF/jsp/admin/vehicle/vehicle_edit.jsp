<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>
<script>

    $(document).ready(function(){
        //attach an onClick function to the remove buttons
        $('.remove_button').click(function(){
            //log name of the button and contents of associated text box
            console.log(this.name);
            console.log($('#'+ this.name).val())
            //clear the value / contents of the textbox
            $('#'+ this.name).val('')
            //submit the form
            $('#vehicle').submit();
        })
    });
</script>
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
            <form:form cssClass="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                <p></p>

                <form:hidden path="id"/>
                <fieldset>

                    <legend>Vehicle Management <h4>(Edit a Vehicle)</h4></legend>

                    <div class="form-group">
                        <label for="inputYear" class="col-lg-2 control-label">Year</label>
                        <div class="col-lg-10">
                            <form:input path="year" type="text" class="form-control" id="inputYear" ></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputLicense" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="LicensePlate" type="text" class="form-control" id="inputLicense"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVIN" class="col-lg-2 control-label"> VIN</label>
                        <div class="col-lg-10">
                            <form:input path="VIN" type="text" class="form-control" id="inputVIN"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputColor" class="col-lg-2 control-label"> Color</label>
                        <div class="col-lg-10">
                            <div class="checkbox">
                                <label>
                                    <form:checkbox path="color" id="inputColor" value="red" ></form:checkbox>Red
                                </label>
                                <label>
                                    <form:checkbox path="color"  value="orange"></form:checkbox>Orange
                                </label>
                                <label>
                                    <form:checkbox path="color"  value="yellow"></form:checkbox>Yellow
                                </label>
                                <label>
                                    <form:checkbox path="color"  value="green"></form:checkbox>Green
                                </label>
                                <label>
                                    <form:checkbox path="color"  value="blue"></form:checkbox>Blue
                                </label>
                                <label>
                                    <form:checkbox path="color"  value="purple"></form:checkbox>Purple
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="selectMake" class="col-lg-2 control-label">Select Make</label>
                        <div class="col-lg-10">
                            <form:select path="vehicleModel.vehicleMake" class="form-control" name="selectMake" id="selectMake" >
                                <c:forEach var="make" items="${vehicleMakes}">
                                    <form:option value="${make.id}">${make.vehicleMakeName}</form:option>
                                </c:forEach>
                            </form:select>
                            <br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selectModel" class="col-lg-2 control-label">Select Model</label>
                        <div class="col-lg-10">
                            <form:select path="vehicleModel" class="form-control" name="selectModel" id="selectModel">
                                <c:forEach var="model" items="${vehicleModels}">
                                    <form:option value="${model.id}">${model.vehicleModelName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <div class="col-sm-4">
            <img src="\static\images\ghandi.jpg" class="img-polaroid" width="100%">
            <blockquote>
                <p>"Too big to fail"</p>
                <small>Mahatma Gandhi from <cite title="Source Title">New Delhi, India</cite></small>
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