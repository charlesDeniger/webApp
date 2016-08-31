<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>

    $(document).ready(function(){
        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(10000).fadeOut(2000);

    });
</script>
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
            //todo: should be vehicleModel but give error saying vmakeId doesnt exist
            $('#vehicleModel').submit();
        })
    });
</script>
<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <c:set var="idx" value="1" scope="page"/>

            <form:form cssClass="form-horizontal" modelAttribute="vehicleModel" action="/admin/vehicle_models/update" method="POST">
                <input type="hidden" hidden name="vmakeId" value="${vehicleModel.vehicleMake.id}"/>
                <fieldset>
                    <legend>${vehicleModel.vehicleMake.vehicleMakeName}</legend>
                    <form:hidden path="vehicleMake.vehicleMakeName" value="vehicleModel.vehicleMake.vehicleMakeName" ></form:hidden>
                    <c:forEach items="${vehicleModelList}" var="vehicleModel">

                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-3" for="${idx}">Model:</label>
                                <div class="col-sm-7">
                                    <div class="input-group">

                                        <form:input path="vehicleModelName" type="text" id="${idx}" cssClass="form-control" value="${vehicleModel.vehicleModelName}" ></form:input>
                                            <span class="input-group-addon" >
                                                <a href="/admin/vehicle_models/delete/${vehicleModel.vehicleMake.id}/${vehicleModel.id}">Remove</a>
                                            </span>
                                        <input type="hidden" type="text" name="ids" value="${vehicleModel.id}"/>


                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:set var="idx" value="${idx + 1}" scope="page"/>
                    </c:forEach>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-3" for="inputNewModel">Add New <br> Vehicle Model:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="inputNewModel" id="inputNewModel"/>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <form:button  class="btn btn-primary" type="submit">Update</form:button>

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