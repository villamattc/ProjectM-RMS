<%--
  Created by IntelliJ IDEA.
  User: Dan
  Date: 11/02/2020
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="Add Equipment">
	<jsp:attribute name="content">
		<div class="content-wrapper" style="min-height: 925.8px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Equipment Form
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
            <form:form action="/room/${roomId}/addequip" method ="POST" modelAttribute = "equip">
            <div class="box-body">
              
                <!-- text input -->
                <div class="form-group">
                 <form:label path = "equipName">Equipment Name:</form:label>
                  <form:input class="form-control" path="equipName" />
                </div>
                <div class="form-group">
                  <label>
										<form:label path="equipStatus">Equipment Status:</form:label>
									</label>
									<form:select class="form-control" path="equipStatus" multiple="false">
										<form:options items="${equipmentStatusOptions}"></form:options>
									</form:select>
                </div>
                <div class="form-group">
                 <form:label path = "dateOfPurchase">Date of Purchase:</form:label>
                  <form:input class="form-control" path="dateOfPurchase" type="date"/>
                </div>
                <div class="form-group">
                 <form:label path = "dateOfLastMaintenance">Date of Last Maintainance:</form:label>
                  <form:input class="form-control" path="dateOfLastMaintenance" type="date"/>
                </div>
                <div class="form-group">
                 <form:label path = "functionalLife">Functional Life (Year/s):</form:label>
                  <form:input class="form-control" path="functionalLife" type="number"/>
                </div>
                <div class="box-footer with-border">
                <button type="submit" class="btn btn-primary"> Add Equipment</button>
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
