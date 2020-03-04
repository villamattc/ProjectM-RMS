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
						Room
						<small>Time: <span id="time"></small>
					</h1>
					
				</section>

				<!-- Main content -->
				<section class="content">
				<div class="row"></div>


					<div class="row">
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-green"><i class="fa fa-check"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Vacant</span>
              <span class="info-box-number"><h1>${vacantNumbers}</h1></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-red"><i class="fa fa-minus"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Occupied</span>
              <span class="info-box-number"><h1>${occupiedNumbers}</h1></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->

        <!-- fix for small devices only -->
        <div class="clearfix visible-sm-block"></div>

        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-yellow"><i class="fa fa-calendar"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Reserved</span>
              <span class="info-box-number"><h1>${reservedNumbers}</h1></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
      <div class="col-md-1" style="margin-top: 55.5px">
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#roomModal">
								Add Room
							</button>
						</div>
<div class="col-md-2" style="margin-top: 55.5px">
<form action="/searchroom" method="get">
        <div class="input-group">
          <input type="text" name="find" class="form-control" placeholder="Search...">
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
						<div class="col-md-4">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Vacant</h3>

								
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 380px;">
									<table class="table table-head-fixed">
										<tbody>
											<tr>
												<th hidden="true">Room Id</th>
												<th>Room</th>
												<th>Condition</th>
												<th>Type</th>
												<th width="110px"></th>
												
										
											</tr>
											<c:forEach items="${vacantRooms}" var="item" >
											<tr>
													<td hidden="true">${item.roomId}</td>
													<td>${item.roomName}</td>
													<td>${item.roomClean ? 'Clean' : 'UNCLEAN'}</td>		
													<td>${item.roomType == 1 ? 'Deluxe Room': ''}${item.roomType == 2 ? 'Amumum Spa Suite': ''}
														${item.roomType == 3 ? 'Premiere Deluxe Room': ''}${item.roomType == 4 ? 'Royal Bungalow': ''}
													</td>									
													<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewusers">
													<i class="fa  fa-users"></i></a>
												
														<a class="btn btn-xs btn-default delete" href="" >
														<i class="fa  fa-trash"></i></a>
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
						<!-- /.col -->
						<div class="col-md-4">
							<div class="box box-danger">
								<div class="box-header bg-red">
									<h3 class="box-title">Occupied</h3>

									
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 380px;">
									<table class="table table-striped table-hover">


										<tbody><tr>
										<th hidden="true">Room Id</th>
											<th>Room</th>
											<th>Condition</th>
											<th>Type</th>
											<th width="110px"></th>
											
										</tr>
										<c:forEach items="${occupiedRooms}" var="item">
										<tr>
										<td hidden="true">${item.roomId}</td>
											<td>${item.roomName}</td>
											<td>${item.roomClean ? 'Clean' : 'UNCLEAN'}</td>
											<td>${item.roomType == 1 ? 'Deluxe Room': ''}${item.roomType == 2 ? 'Amumum Spa Suite': ''}
												${item.roomType == 3 ? 'Premiere Deluxe Room': ''}${item.roomType == 4 ? 'Royal Bungalow': ''}
											</td>
											<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewusers">
													<i class="fa  fa-users"></i></a>
												
														<a class="btn btn-xs btn-default delete"  href="" >
														<i class="fa  fa-trash"></i></a>
													</td>
													
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
							<div class="box box-warning">
								<div class="box-header bg-yellow">
									<h3 class="box-title">Reserved</h3>

								
								</div>
								<!-- /.box-header -->

								<!--Reserved-->
								<div class="box-body no-padding table-responsive" style="height: 380px;">
									<table class="table table-striped table-hover">

										<tbody>
											<tr>
											<th hidden="true">Room Id</th>
												<th>Room</th>
												<th>Condition</th>
												<th>Type</th>
												<th width="110px"></th>
					
											</tr>
											<tr>
											<c:forEach items="${reservedRooms}" var="item">
											<td hidden="true">${item.roomId}</td>
												<td>${item.roomName}</td>
												<td>${item.roomClean ? 'Clean' : 'UNCLEAN'}</td>
												<td>${item.roomType == 1 ? 'Deluxe Room': ''}${item.roomType == 2 ? 'Amumum Spa Suite': ''}
												${item.roomType == 3 ? 'Premiere Deluxe Room': ''}${item.roomType == 4 ? 'Royal Bungalow': ''}
											</td>
												<td><a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}">
														<i class="fa fa-eye"></i></a>
													<a class="btn btn-xs btn-default" href="/viewroom/${item.roomId}/viewusers">
													<i class="fa  fa-users"></i></a>
												
														<a class="btn btn-xs btn-default delete" href="" >
														<i class="fa fa-trash"></i></a>
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

			<!-- Modal for Add Room-->
			<div class="modal fade in" id="roomModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
										<form:label path="roomType">Room Type:</form:label>
									</label>
									<form:select class="form-control" path="roomType" multiple="false">
										<form:options items="${roomTypeOptions}"></form:options>
									</form:select>
								</div>
								<div class="form-group">
									<label>
										<form:label path="roomStatus">Room Status:</form:label>
									</label>
									<form:select class="form-control" path="roomStatus" multiple="false">
										<form:options items="${roomStatusOptions}"></form:options>
									</form:select>
								</div>
								<div class="form-group">
									<label>
										<form:label path="roomClean">Room Clean:</form:label>
									</label>
									<form:select class="form-control" path="roomClean" multiple="false">
										<form:options items="${roomCleanOptions}"></form:options>
									</form:select>
								</div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >Save changes</button>
						</div>
						</form:form>
					</div>
					<!-- /.modal-content -->
				</div>

				<!-- /.modal-dialog -->
			</div>


	</div>


<script >
$(document).ready(function(){

	//DELETE CLICK
	 $('.delete').on('click', function () {
	        var $tds = $(this).parents("tr").find('td');
			roomId = $tds.eq(0).text().trim();
 	        roomName = $tds.eq(1).text().trim();
 	        roomStatus = $tds.eq(2).text().trim();
 	        roomType = $tds.eq(3).text().trim();
	        var r = confirm('Are you sure to delete '+roomName+', '+roomStatus+' '+roomType+'?');
	        if (r==true) {
     	        deleteRoom(roomId);
	            $(this).parents("tr").remove();
				swal("Deleted!", "Room is successfully deleted!", "success")
	        }
	        return false;
	 });
	

   	//AJAX DELETE ROOM
    function deleteRoom(roomId){

        $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/deleteroom/"+roomId,
        dataType : 'json',
        success : function(result) {
			
        },
        error : function(e) {
        }
      }); 
    } 
});
</script>
		</jsp:attribute>
	</mt:admin_template>