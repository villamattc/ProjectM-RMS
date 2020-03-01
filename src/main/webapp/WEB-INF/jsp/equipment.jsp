<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="Equipment">
	<jsp:attribute name="content">
			<div class="content-wrapper" style="min-height: 925.8px;">
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
				
					<br>
					
					<div class="row">
						<div class="col-md-2">
					<div class="form-group">
                
                  <select class="form-control">
                    <option value="viewroominvent">View Room Equipment</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
				</div>
<div class="col-md-8"></div>
<div class="col-md-2 pull-right">
<form action="#" method="get">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-default"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
</div>
</div>
					<br>
					<div class="row">

					<!--Option 1-->
						<div class="col-md-3">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Good Condition</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Name</th>
												<th>Room No.</th>
												<th>Last Maintainance</th>
												
												
										
											</tr>
										<c:forEach items="${goodcondition}" var="item" varStatus = "status">
											<tr>											
													<td>${item.equipName}</td>
													<td>${goodconditionRoomName[status.index]}</td>											
												<td>${item.dateOfLastMaintenance}</td>		
											
													
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
						<!--Option 2-->
						<div class="col-md-3">
							<div class="box box-warning">
								<div class="box-header bg-yellow">
									<h3 class="box-title">Need Maintainance</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped table-hover">


										<tbody><tr>
											<th>Name</th>
											<th>Room No.</th>
											<th>Last Maintainance</th>
											
											
										</tr>
										<c:forEach items="${needsmaint}" var="item" varStatus = "status">
										<tr>
											<td>${item.equipName}</td>
													<td>${needsmaintRoomName[status.index]}</td>											
												<td>${item.dateOfLastMaintenance}</td>				
													
										</tr>
										</c:forEach>
									
										</tbody></table>

								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!--Option 3-->
						<div class="col-md-3">
							<div class="box box-danger">
								<div class="box-header bg-red">
									<h3 class="box-title">Need Repair</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped table-hover">


										<tbody><tr>
											<th>Name</th>
											<th>Room No.</th>
											<th>Last Maintainance</th>
											
										</tr>
										<c:forEach items="${needsrepair}" var="item" varStatus = "status">
										<tr>
												<td>${item.equipName}</td>
													<td>${needsrepairRoomName[status.index]}</td>											
												<td>${item.dateOfLastMaintenance}</td>		
													
										</tr>
										</c:forEach>
									
										</tbody></table>

								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!--Option 4-->
						<div class="col-md-3">
							<div class="box box-info">
								<div class="box-header" style="background-color: #00C0EF">
									<h3 class="box-title">Need Replace</h3>
								</div>
								<!-- /.box-header -->
									<div class="box-body no-padding">
									<table class="table table-striped table-hover">
										<tbody>
											<tr>
											<th>Name</th>
											<th>Room No.</th>
											<th>Last Maintainance</th>
																
											</tr>

											<c:forEach items="${needreplace}" var="item" varStatus = "status">
											<tr>										
												<td>${item.equipName}</td>
													<td>${needreplaceRoomName[status.index]}</td>											
												<td>${item.dateOfLastMaintenance}</td>												
											</tr>	
											</c:forEach>								
										</tbody>
									</table>
								</div>
						

								</div>
								<!-- /.box-header -->
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
