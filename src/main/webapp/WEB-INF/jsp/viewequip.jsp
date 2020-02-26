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
		  <div class="col-md-1"></div>
			<div class="col-md-9">
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
						<th>Completeness of Parts
						</th>
						<th>Appearance
						</th>
						<th>Functionality
						</th>

						<th width="100px">
						</th>
						
						
					</tr>

						<c:forEach items="${equip}" var="item" varStatus="status">
						<tr>
							<td>${item.equipName}</td>
							<td>${item.equipStatus}</td>
							<td>${item.dateOfPurchase}</td>
							<td>${item.dateOfLastMaintenance}</td>
							<td>${item.functionalLife}</td>
							<td>${item.completenessOfParts}</td>
							<td>${item.appearance}</td>
							<td>${item.functionality}</td>
							<td><a href="/updateequip/${item.equipId}" type="button" class="btn btn-info">Update</a></td>
							<td><button type="button" class="btn btn-success">View Logs</button></td>
							<td>
								<a class="btn btn-danger" href="/deleteequip/${item.equipId}">Delete</a>
							</td>
						
					</tr>
					</c:forEach>
				  </tbody>
				  </table>
				</div>
				<!-- /.box-body -->
			  </div>
			  <!-- /.box -->
			  <div class="col-md-1"></div>
			</div>
		  </div>

		</section>
		<!-- /.content -->


	  </div>
	</jsp:attribute>
</mt:admin_template>