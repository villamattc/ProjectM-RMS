<%--
  Created by IntelliJ IDEA.
  User: Dan
  Date: 10/02/2020
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="Inventory">
	<jsp:attribute name="content">
			<div class="content-wrapper" style="min-height: 925.8px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						Inventory
						<small>Date today</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="/room"><i class="fa fa-dashboard"></i> Home</a></li>
						
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
							<div class="box box-success">
								<div class="box-header bg-green">
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
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Room</th>
												<th>Condition</th>
												<th width="140px"></th>
												
										
											</tr>
										
											<tr>
											
													<td>${item.roomName}</td>
													<td>${item.roomClean}</td>											
													<td><a class="btn btn-xs btn-default" href="#">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="#">
													<i class="fa  fa-users"></i></a>
												<a class="btn btn-xs btn-default" href="#">
													<i class="fa  fa-briefcase"></i></a>
														<a class="btn btn-xs btn-default" href="#">
														<i class="fa  fa-cubes"></i></a>
													</td>
											
													
												</tr>
						
										</tbody>
									</table>



								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!-- /.col -->
						<div class="col-md-4">
							<div class="box box-danger">
								<div class="box-header bg-red">
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
											<th width="140px"></th>
											
										</tr>
										
										<tr>
											<td>${item.roomName}</td>
											<td>${item.roomClean}</td>
											<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewusers">
													<i class="fa  fa-users"></i></a>
												<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewequip">
													<i class="fa  fa-briefcase"></i></a>
														<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewinvent">
														<i class="fa  fa-cubes"></i></a>
													</td>
													
										</tr>
									
										</tbody></table>

								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!--Occupied-->
						<div class="col-md-4">
							<div class="box box-warning">
								<div class="box-header bg-yellow">
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
												<th width="140px"></th>
					
											</tr>
											<tr>
										
												<td>${item.roomName}</td>
												<td>${item.roomClean}</td>
												<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewusers">
													<i class="fa  fa-users"></i></a>
												<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewequip">
													<i class="fa  fa-briefcase"></i></a>
														<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewinvent">
														<i class="fa  fa-cubes"></i></a>
													</td>
											
											</tr>
									
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
							
								<div class="form-group">
									<label>
										<label path="roomName">Room Name:</label>
									</label>
									<input class="form-control" path="roomName" />
								</div>
								<div class="form-group">
									<label>
										<label path="roomStatus">Room Status:</label>
									</label>
									<select class="form-control" path="roomStatus" multiple="false">
										<option items="${options}"></option>
									</select>
								</div>
								<div class="form-group">
									<label>
										<label path="roomClean">Room Clean:</label>
									</label>
									<input class="form-control" path="roomClean" value="true" />
								</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >Save changes</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" onClick="saveRoom();">SweetAlert2</button>
						</div>
				
					</div>
					<!-- /.modal-content -->
				</div>

				<!-- /.modal-dialog -->
			</div>


	</div>
	</jsp:attribute>
</mt:admin_template>
