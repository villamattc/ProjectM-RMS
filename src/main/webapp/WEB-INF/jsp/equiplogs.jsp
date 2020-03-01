<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<mt:admin_template title="View Equipment Logs">
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
		  <div class="row">
		  
			<div class="col-md-12">
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Equipment of ${room.roomName}</h3>
	
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
						
						<th>Log Time
						</th>
						<th>Log Date
						</th>
						<th>Username
						</th>
						<th>Equipment ID
						</th>
						<th>Description
						</th>
						<th>Equipment Name
						</th>
						<th>Equipment Status
						</th>
						<th>Date of Purchase
						</th>
                        <th>Date of Last Maintainance
						</th>
                        <th>Completeness of Parts
						</th>
                        <th>Appearance
						</th>
                        <th>Functionality
						</th>
                        <th>Assesment Score
						</th>

						
						
					</tr>

					<c:forEach items="${equipLog}" var="item" varStatus="status">
					<tr>
							<td>${item.logTime}</td>
                            <td>${item.logDate}</td>
							<td>${item.username}</td>
							<td>${item.eqId}</td>
							<td>${item.description}</td>
							<td>${item.equipName}</td>
							<td>${item.equipStatus}</td>
							<td>${item.dateOfPurchase}</td>
                            <td>${item.dateOfLastMaintenance}</td>
                            <td>${item.completenessOfParts}</td>
                            <td>${item.appearance}</td>
                            <td>${item.functionality}</td>
                            <td>${item.assessmentScore}</td>
                      

						
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

<div class="modal fade" id="equipLogs" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Room Equipment Logs</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


	  </div>
	</jsp:attribute>
</mt:admin_template>