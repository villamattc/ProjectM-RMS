	<%--
	Created by IntelliJ IDEA.
	User: Dan
	Date: 10/02/2020
	Time: 8:38 PM
	To change this template use File | Settings | File Templates.
	--%>

	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<mt:admin_template title="Room">
		<jsp:attribute name="content">
			<div class="content-wrapper" style="min-height: 925.8px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						Rooms
						<small>Date today</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
						<li><a href="#">Tables</a></li>
						<li class="active">Simple</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<br>
					<div class="row">
						<div class="col-md-10">

						</div>
						<div class="col-md-2">
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#roomModal">
								Add Room
							</button>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Vacant</h3>

									<div class="box-tools">
										<ul class="pagination pagination-sm no-margin pull-right">
											<li><a href="#">«</a></li>
											<li><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">»</a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped table-hover">
										<tbody>
											<tr>
												<th>Room</th>
												<th>Condition</th>
												<th width="10px"></th>
												<th width="10px"></th>
											</tr>
											<c:forEach items="${vacantRooms}" var="item">
												<tr>
													<td>${item.roomName}</td>
													<td>${item.roomClean}</td>
													<td><a class="btn btn-xs btn-default">
														<i class="fa  fa-user-plus"></i>
													</a></td>
													<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i>
													</a></td>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>



								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!-- /.col -->
						<div class="col-md-4">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Occupied</h3>

									<div class="box-tools">
										<ul class="pagination pagination-sm no-margin pull-right">
											<li><a href="#">«</a></li>
											<li><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">»</a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped table-hover">


										<tbody><tr>
											<th>Room</th>
											<th>Condition</th>
											<th width="10px"></th>
												<th width="10px"></th>
										</tr>
										<c:forEach items="${occupiedRooms}" var="item">
										<tr>
											<td>${item.roomName}</td>
											<td>${item.roomClean}</td>
											<td><a class="btn btn-xs btn-default" data-toggle="modal" data-target="#addRoomUserModal">
														<i class="fa  fa-user-plus"></i>
													</a></td>
													<td><a class="btn btn-xs btn-default" data-toggle="modal" data-target="#viewRoomForOccupiedModal">
														<i class="fa fa-eye"></i>
													</a></td>
										</tr>
										</c:forEach>
										</tbody></table>

								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!--Occupied-->
						<div class="col-md-4">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Reserved</h3>

									<div class="box-tools">
										<ul class="pagination pagination-sm no-margin pull-right">
											<li><a href="#">«</a></li>
											<li><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">»</a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-header -->

								<!--Reserved-->
								<div class="box-body no-padding">
									<table class="table table-striped table-hover">

										<tbody>
											<tr>
												<th>Room</th>
												<th>Condition</th>
												<th width="10px"></th>
												<th width="10px"></th>
											</tr>
											<tr>
											<c:forEach items="${reservedRooms}" var="item">
												<td>${item.roomName}</td>
												<td>${item.roomClean}</td>
												<td><a class="btn btn-xs btn-default" >
														<i class="fa  fa-user-plus"></i>
													</a></td>
													<td><a class="btn btn-xs btn-default">
														<i class="fa fa-eye"></i>
													</a></td>
												
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
				<!-- The Modal -->


			</div>

			<!-- Modal for Add Room-->
			<div class="modal fade" id="roomModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">x</span></button>
							<h4 class="modal-title">Add Room</h4>
						</div>
						<div class="modal-body">
							<form:form action="/add" method="POST" modelAttribute="room">
								<div class="form-group">
									<label>
										<form:label path="roomName">Room Name:</form:label>
									</label>
									<form:input class="form-control" path="roomName" />
								</div>
								<div class="form-group">
									<label>
										<form:label path="roomStatus">Room Status:</form:label>
									</label>
									<form:select class="form-control" path="roomStatus" multiple="false">
										<form:options items="${options}"></form:options>
									</form:select>
								</div>
								<div class="form-group">
									<label>
										<form:label path="roomClean">Room Clean:</form:label>
									</label>
									<form:input class="form-control" path="roomClean" value="true" />
								</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >Save changes</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" onClick="saveRoom();">SweetAlert2</button>
						</div>
						</form:form>
					</div>
					<!-- /.modal-content -->
				</div>

				<!-- /.modal-dialog -->
			</div>


	</div>


	<script type="text/javascript">
	function saveRoom(){
		Swal.fire({
	position: 'center',
	icon: 'success',
	title: 'Your work has been saved',
	showConfirmButton: false,
	timer: 1500
	})
	}
	</script>

		</jsp:attribute>
	</mt:admin_template>