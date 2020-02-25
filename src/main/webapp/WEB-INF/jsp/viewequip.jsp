<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="View Equipment">
	<jsp:attribute name="content">
			<div class="content-wrapper" style="min-height: 661px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		  <h1>
			Equipment
			<small>list</small>
		  </h1>
		  <ol class="breadcrumb">

			<li><a href="/room"><i class="fa fa-dashboard"></i> Home</a></li>
		  </ol>
		</section>
	
		<!-- Main content -->
		<section class="content">
		  <div class="row">
		  <div class="col-md-2"></div>
			<div class="col-md-8">
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Equipment of ${room.roomName}</h3>
	
				  <div class="box-tools">
					<div class="input-group input-group-sm hidden-xs" style="width: 150px;">

					  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
					  </div> 
					 
					</div>
				  </div>
				</div>


				<!-- /.box-header -->
				<div class="box-body table-responsive no-padding">
				  <table class="table table-hover">
					<tbody><tr>
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
						<th width="100px">
						</th>
						
						
					</tr>

						<c:forEach items="${equip}" var="item">
						<tr>
							<td>${item.equipName}</td>
							<td>${item.equipStatus}</td>
							<td>${item.dateOfPurchase}</td>
							<td>${item.dateOfLastMaintenance}</td>
							<td>${item.functionalLife}</td>
							<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#updateEquipModal">Update</button></td>
							<td><button type="button" class="btn btn-success">View Logs</button></td>
						
					</tr>
					</c:forEach>
				  </tbody>
				  </table>
				</div>
				<!-- /.box-body -->
			  </div>
			  <!-- /.box -->
			  <div class="col-md-2"></div>
			</div>
		  </div>

		</section>
		<!-- /.content -->

<!-- Modal for Add Room-->
			<div class="modal fade in" id="updateEquipModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">x</span></button>
							<h4 class="modal-title">Add Room</h4>
						</div>
						<div class="modal-body">
							<form:form action="/updateequip/${equip.equipId}" method="POST" modelAttribute="equip">
								 <div class="form-group">
                 <form:label path = "equipName">Equipment Name:</form:label>
                  <form:input class="form-control" path="equipName" value="${equip.equipName}"/>
                </div>
                <div class="form-group">
                  <label>
										<form:label path="equipStatus">Equipment Status:</form:label>
									</label>
									<form:select class="form-control" path="equipStatus" multiple="false" value="${equip.equipStatus}">
										<form:options items="${equipmentStatusOptions}"></form:options>
									</form:select>
                </div>
                <div class="form-group">
                 <form:label path = "dateOfPurchase">Date of Purchase:</form:label>
                  <form:input class="form-control" path="dateOfPurchase" value="${equip.dateOfPurchase}" type="date"/>
                </div>
                <div class="form-group">
                 <form:label path = "dateOfLastMaintenance">Date of Last Maintainance:</form:label>
                  <form:input class="form-control" path="dateOfLastMaintenance" value="${equip.dateOfLastMaintenance}" type="date"/>
                </div>
                <div class="form-group">
                 <form:label path = "functionalLife">Functional Life (Year/s):</form:label>
                  <form:input class="form-control" path="functionalLife" value="${equip.functionalLife}" type="number"/>
                </div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >Update Equipment</button>
						
						</div>
						</form:form>
					</div>
					<!-- /.modal-content -->
				</div>

				<!-- /.modal-dialog -->
			</div>


	  </div>
	</jsp:attribute>
</mt:admin_template>