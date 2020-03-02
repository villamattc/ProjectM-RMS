	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="View Room">
	<jsp:attribute name="content">
  <div class="content-wrapper" style="min-height: 925.8px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Add User Form
      <small>Time: <span id="time"></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/room"><i class="fa fa-dashboard"></i> Home</a></li>
        
      </ol>
    </section>

    <!-- Main content -->
    <br>
    <section class="content">
      <div class="row">


      <div class="col-md-2">
      </div>

      
        <div class="col-md-8">
        <div class="box box-warning">
            <div class="box-header with-border">
              <h3 class="box-title">Room ${room.roomName}</h3>
            </div>
            <!-- /.box-header -->
            <form:form action="/room/${roomId}/adduser" method ="POST" modelAttribute = "user">
            <div class="box-body">
              
                <!-- text input -->
                <div class="form-group">
                 <form:label path = "lastName">Last Name:</form:label>
                  <form:input class="form-control" path="lastName" />
                </div>
                 <div class="form-group">
                   <form:label path = "firstName">First Name</form:label>
                 <form:input class="form-control" path="firstName" />
                </div>
                <div class="row">
                <div class="col-md-6 form-group">
                <label>Adult/s:</label>
                 <input class="form-control" type="number" value="0"/>
                </div>
                <div class="col-md-6 form-group">
                <label>Child/Children:</label>
                <input class="form-control" type="number" value="0"/>
                </div>
                </div>
                 <div class="form-group">
                  <form:label path = "checkin">Check in date:</form:label>
                  <form:input class="form-control" path="checkin" type="date"/>
                </div>
                <div class="form-group">
                  <form:label path = "checkout">Check out date:</form:label>
                  <form:input class="form-control" path="checkout" type="date"/>
                </div>
                <div class="form-group">
                  <form:label path = "nationality">Nationality: </form:label>
                  <form:input class="form-control" path="nationality" />
                </div>
                <div class="form-group">
                  <form:label path = "age">Age:</form:label>
                  <form:input class="form-control" path="age" input="number"/>
                </div>
                <div class="form-group">
                 <form:label path = "occupation">Occupation:</form:label>
                  <form:input class="form-control" path="occupation" />
                </div>
                <div class="form-group">
                   <form:label path = "businessOrvacay">Business Or Vacation</form:label>
                   <form:select class="form-control" path="businessOrvacay" multiple="false">
										<form:options items="${busiOrVacaOption}"></form:options>
									</form:select>
                </div>

                <div class="box-footer with-border">
                <button type="submit" class="btn btn-primary"> Add User</button>
                </div>
                
                <div class="col-md-2">
                </div>            
            </div>
            </form:form>
            <!-- /.box-body -->
          </div>
        
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  </jsp:attribute>
</mt:admin_template>