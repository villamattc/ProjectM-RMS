<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="View Users">
	<jsp:attribute name="content">
		<div class="content-wrapper" style="min-height: 925.8px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						Logs Details
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
						<div class="col-md-6">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Equipment Logs</h3>

									<div class="box-tools">
										<ul class="pagination pagination-sm no-margin pull-right">
											<li><a href="#"><<</a></li>
											<li><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">>></a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Room No.</th>
												<th>Equipment Name</th>                                                
												<th>Action</th>
												<th>Description</th>
                                                <th>Date</th>
											</tr>
										
											<tr>
													<td>1</td>
													<td>Aircon</td>		
													<td>Needs Maintainance</td>									
													<td>Checks the parts of the unit</td>	
                                                    <td>2020-02-12</td>
												</tr>										
										</tbody>
									</table>
										
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
									<h3 class="box-title">Inventory Logs</h3>

									<div class="box-tools">
										<ul class="pagination pagination-sm no-margin pull-right">
											<li><a href="#"><<</a></li>
											<li><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">>></a></li>
										</ul>
									</div>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Room No.</th>
												<th>Inventory Name</th>                                                
												<th>Action</th>
												<th>Description</th>
                                                <th>Date</th>
											</tr>
										
											<tr>
													<td>1</td>
													<td>Aircon</td>		
													<td>Add</td>									
													<td>Adding soap, towel </td>	
                                                    <td>2020-02-13</td>
												</tr>										
										</tbody>
									</table>
										
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

			


	</div>
	</jsp:attribute>
</mt:admin_template>
