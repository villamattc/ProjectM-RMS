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
			<div class="content-wrapper" style="min-height: 901.2px;">
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
						
						<div class="form-group col-md-3">
                  <label>Select Room</label>
                  <select class="form-control">
                    <option value="viewroominvent"><a href="/viewroominvent">View Room Inventory</a></option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
				<div class="col-md-9">

						</div>
					</div>
					<br>
					<div class="row">

					<!--Option 1-->
						<div class="col-md-6">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Room Name</h3>

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
												<th width="500px">Name</th>
												<th>Quantity:</th>
												
												
												
										
											</tr>
										
											<tr>											
													<td>equip 1</td>
													<td></td>											
												
											
													
												</tr>
						
										</tbody>
									</table>



								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>

						<div class="col-md-6">
							<div class="box box-warning">
								<div class="box-header bg-yellow">
									<h3 class="box-title">Logs</h3>

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
												<th>Date:</th>
												<th>Inventory log:</th>
												<th>Last Maintainance:</th>
												
												
										
											</tr>
										
											<tr>											
													<td>equip 1</td>
													<td>420</td>											
												<td>2020-02-28</td>		
											
													
												</tr>
						
										</tbody>
									</table>



								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
					
						
							<!-- /.box -->
						</div>
					</section></div>
	</jsp:attribute>
</mt:admin_template>
