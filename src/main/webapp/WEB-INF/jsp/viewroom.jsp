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
        Room Info
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
            
            <div class="box-body">
                <form:form action="/updateroom/${room.roomId}" method ="POST" modelAttribute = "room">
                <!-- text input -->
                <div class="form-group">
                  <form:label path="roomName">Room Name:</form:label>
                  <form:input type="text" class="form-control" path="roomName" value="${room.roomName}"/>
                </div>
                <div class="form-group">
               
									<label>
                  
										<form:label path="roomType">Room Type:</form:label>
									</label>
									<form:select class="form-control" path="roomType" multiple="false">
										<form:options items="${roomTypeOptions}"></form:options>
									</form:select>
								</div>
                 <div class="form-group">
                  <label>
										<form:label path="roomStatus">Room Status:</form:label>
									</label>
									<form:select class="form-control" path="roomStatus" multiple="false" value="${room.roomStatus}">
										<form:options items="${roomStatusOptions}"></form:options>
									</form:select>
                </div>
                 <div class="form-group">
                  <label>
										<form:label path="roomClean">Room Clean:</form:label>
									</label>
									<form:select class="form-control" path="roomClean" multiple="false" value="${room.roomClean}">
										<form:options items="${roomCleanOptions}"></form:options>
									</form:select>
                </div>
                <div class="box-footer with-border">


                <div class="row">
                <div class="col-md-6">
                <button type="submit" class="btn btn-primary">Update Room</button>
                </div>
                <div class="col-md-6">
                <div class="pull-right">
                <a class="btn btn-primary" href="/viewroom/${id}/adduserform">Add User</a>
                <a type="button" class="btn btn-primary" href="/viewroom/${id}/addequipform">Add Equipment</a>
                <a type="button" class="btn btn-primary" href="/viewroom/${id}/addinventoryform">Add Inventory</a>
                </div>
                </div>
                
                </div>

                </div>
                
                <div class="col-md-2">
                </div>
               

              </form:form>
            </div>
            
            <!-- /.box-body -->
          </div>
        
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
	</jsp:attribute>
</mt:admin_template>
