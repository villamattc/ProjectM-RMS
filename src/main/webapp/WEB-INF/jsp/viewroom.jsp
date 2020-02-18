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
        Data Tables
        <small>advanced tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="http://localhost:8010/room"><i class="fa fa-dashboard"></i> Home</a></li>
        
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
              <form role="form">
                <!-- text input -->
                <div class="form-group">
                  <label>Room Name:</label>
                  <input type="text" class="form-control" value="${room.roomName}" readonly>
                </div>
                 <div class="form-group">
                  <label>Room Status:</label>
                  <input type="text" class="form-control" value="${room.roomStatus}" readonly>
                </div>
                 <div class="form-group">
                  <label>Room Clean:</label>
                  <input type="text" class="form-control" value="${room.roomClean}" readonly>
                </div>
                <div class="box-footer with-border">
                <a class="btn btn-primary" href="/viewroom/${room.roomId}/adduserform">Add User</a>
                <a type="button" class="btn btn-primary" href="#">Add Equipment</a>
                <a type="button" class="btn btn-primary" href="#">Add Inventory</a>
                </div>
                
                <div class="col-md-2">
                </div>
               

              </form>
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
