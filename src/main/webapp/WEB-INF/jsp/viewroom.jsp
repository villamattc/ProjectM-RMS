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
 
    <section class="content">
	<button class="btn btn-default" onclick="goBack()">Go Back</button>
    <br>
    <br>
      <div class="row">

      
        <div class="col-md-6">
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
                  <button type="submit" class="btn btn-sm btn-primary">Update Room</button>
                  </div>
                  <div class="col-md-6">
                  <div class="pull-right">
                  <a class="btn btn-xs btn-primary" href="/viewroom/${id}/adduserform">Add User</a>
                  <a type="button" class="btn btn-xs btn-primary" href="/viewroom/${id}/addequipform">Add Equipment</a>
                  <a type="button" class="btn btn-xs btn-primary" href="/viewroom/${id}/addinventoryform">Add Inventory</a>
                  </div>
                  </div>
                
                  </div>

                  </div>
                
               

                  </form:form>
                </div>
            
            <!-- /.box-body -->
            
          </div>
          
        
      </div>
      <div class="col-md-6">
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Inventory of ${room.roomName}</h3>
	
			
				</div>
				<!-- /.box-header -->


				<div class="box-body table-responsive no-padding" style="height: 339px;">
				  <table class="table table-hover">
					<tbody><tr>
						<th hidden="true">Invent Id
					</th>
						<th>Name
						</th>
						<th>Current
						</th>	
						<th>Max
						</th>	
						<th width="400px"></th>
					</tr>
						<c:forEach items="${invent}" var="item">
						<tr>
							<td hidden="true">${item.inventId}</td>
							<td>${item.inventName}</td>
							<td>${item.inventCurrentQuantity}</td>		
							<td>${item.inventMaxQuantity}</td>					
							<td class="pull-right">

							<button type="button" class="btn btn-xs btn-success">View Logs</button>
							<a class="btn btn-xs btn-danger delete" href="" >Delete</a>

							</td>
					
						
					</tr>
					</c:forEach>
				  </tbody>
				  </table>
				
        
        </div>
				<!-- /.box-body -->
				<div class="box-footer with-border">
        <a href="/inventory/${room.roomId}" type="button" class="btn btn-info btn-xs pull-right">Update</a>
        </div>
			  </div>
			  
			  <!-- /.box -->
			</div>
      </div>
      <!-- /.row -->
      <div class="row">

			<div class="col-md-12">
			  <div class="box" style="height: 500px;">
				<div class="box-header">
				  <h3 class="box-title">Equipment of ${room.roomName}</h3>
				</div>


				<!-- /.box-header -->
				<div class="box-body table-responsive no-padding">
				  <table class="table table-hover">
					<tbody><tr>
					<th hidden="true">ID</th>
						<th>Name
						</th>
						<th>Status
						</th>
						<th>Date of Purchase
						</th>
						<th>Date of Last Maintainance
						</th>
						<th>Functional Life
						</th>
						<th>Completeness of Parts
						</th>
						<th>Appearance
						</th>
						<th>Functionality
						</th>
						<th>Assessment Score
						</th>
						<th width="240px">
						</th>
						
						
					</tr>

						<c:forEach items="${equip}" var="item" varStatus="status">
						<tr>
						<td hidden="true">${item.equipId}</td>
							<td>${item.equipName}</td>
							<td>${item.equipStatus}</td>
							<td>${item.dateOfPurchase}</td>
							<td>${item.dateOfLastMaintenance}</td>
							<td>${item.functionalLife}</td>
							<td>${item.completenessOfParts}</td>
							<td>${item.appearance}</td>
							<td>${item.functionality}</td>
							<td>${item.assessmentScore}</td>
							<td class="pull-right">
							<a href="/updateequip/${item.equipId}" type="button" class="btn btn-xs btn-info">Update</a>
							<a href="/viewroom/${item.equipId}/viewequip/equiplogs/${item.equipId}" type="button" class="btn btn-xs btn-success">View Logs</a>
							<a class="btn btn-xs btn-danger deleteequip" href="">Delete</a>
							</td>
						
					</tr>
					</c:forEach>
				  </tbody>
				  </table>
				</div>
				<!-- /.box-body -->
			  </div>
			  <!-- /.box -->
			</div>
		  </div>
    </section>
    <!-- /.content -->
  </div>



 
	</jsp:attribute>
</mt:admin_template>
