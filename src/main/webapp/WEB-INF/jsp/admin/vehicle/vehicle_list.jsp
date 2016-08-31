<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <p></p>
        <fieldset>

            <legend>Vehicle List</legend>
            <%--LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Color</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
                </thead>
                    <tbody>
                    <form:form  modelAttribute="VehicleVO" action="/admin/vehicle_list/" method="post">
                    <c:forEach var="vehicleVO" items="${vehicleVOList}">

                        <%--<input:hidden path="${vehicleVO.vehicle.id}" id="id" name="id" value="${vehicleVO.vehicle.id}"/>--%>
                        <tr>
                            <td>${vehicleVO.vehicle.id}</td>
                            <td>${vehicleVO.vehicle.year}</td>
                            <td>${vehicleVO.vehicle.licensePlate}</td>
                            <td>${vehicleVO.vehicle.VIN}</td>
                            <td>${vehicleVO.vehicle.color}</td>
                            <td>${vehicleVO.vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                            <td>${vehicleVO.vehicle.vehicleModel.vehicleModelName}</td>
                            <td><a href="/admin/vehicle/edit/${vehicleVO.vehicle.id}">Edit</a></td>
                            <td><a href="/admin/vehicle/delete/${vehicleVO.vehicle.id}">Delete</a></td>
                         </tr>
                    </c:forEach>
                    </form:form>
                    </tbody>

                </table>
                    <blockquote>
                        <p>"Has Anyone Been As Far As Decided To Use Even Go Want To Do Look More Like"</p>
                        <small>Charles Deniger from <cite title="Source Title">Aston Tech</cite></small>
                    </blockquote>
            </fieldset>
        </div>
    </div>

</div>


<%@include file="../../includes/footer.jsp"%>