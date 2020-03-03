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
				<div class="content-wrapper" style="min-height: 661px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		  <h1>
			Inventory
			<small>Time: <span id="time"></small>
		  </h1>
		  <ol class="breadcrumb">

			<li><a href="/room"><i class="fa fa-dashboard"></i> Home</a></li>
		  </ol>
		</section>
	
		<!-- Main content -->
		<section class="content">
		  <div class="row">
		  <div class="col-md-1"></div>
			<div class="col-md-10">
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Inventory of ${room.roomName}</h3>
	
				  <%-- <div class="box-tools">
					<div class="input-group input-group-sm hidden-xs" style="width: 150px;">

					  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
					  </div> 
					 
					</div>
				  </div> --%>
				</div>
				<!-- /.box-header -->


				<div class="box-body table-responsive no-padding">
				  <table class="table table-hover">
					<tbody><tr>
						<th>Name
						</th>
						<th>Quantity
						</th>	
						<th width="400px"></th>
					</tr>
						<c:forEach items="${invent}" var="item">
						<tr>
							<td>${item.inventName}</td>
							<td>${item.inventCurrentQuantity} out of ${item.inventMaxQuantity}</td>						
							<td class="pull-right">

							<button type="button" class="btn btn-xs btn-success">View Logs</button>
							<a class="btn btn-xs btn-danger" href="#">Delete</a>

							</td>
					
						
					</tr>
					</c:forEach>
				  </tbody>
				  </table>
				</div>
				<!-- /.box-body -->
			  </div>
			  <a href="/inventory/${room.roomId}" type="button" class="btn btn-info pull-right">Update</a>
			  <!-- /.box -->
			</div>
			 <div class="col-md-1"></div>
		  </div>

		</section>
		<!-- /.content -->

	  </div>
	</jsp:attribute>
</mt:admin_template>