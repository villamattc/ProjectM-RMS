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

			<div class="col-md-12">
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Equipment of ${room.roomName}</h3>
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
						<th>Assessment Score
						</th>
						<th width="240px">
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
							<td>${item.assessmentScore}</td>
							<td class="pull-right">
							<a href="/updateequip/${item.equipId}" type="button" class="btn btn-xs btn-info">Update</a>
							<a href="/viewroom/${item.equipId}/viewequip/equiplogs/${item.equipId}" type="button" class="btn btn-xs btn-success">View Logs</a>
							<a class="btn btn-xs btn-danger" href="/deleteequip/${item.equipId}">Delete</a>
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