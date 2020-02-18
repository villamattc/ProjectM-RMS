<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="Add Inventory">
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
            <form:form action="/room/${roomId}/addinventory" method ="POST" modelAttribute = "inventory">
            <div class="box-body">
              
                <!-- text input -->
                <div class="form-group">
                 <form:label path = "inventName">Item Name:</form:label>
                  <form:input class="form-control" path="inventName" />
                </div>
                <div class="form-group">
                 <form:label path = "inventCurrentQuantity">Item Quantity:</form:label>
                  <form:input class="form-control" path="inventCurrentQuantity" type="number"/>
                </div>
                <div class="form-group">
                 <form:label path = "inventMaxQuantity">Max Quantity:</form:label>
                  <form:input class="form-control" path="inventMaxQuantity" type="number"/>
                </div>              
                 <div class="box-footer with-border">
                <button type="submit" class="btn btn-primary"> Add Inventory</button>
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
