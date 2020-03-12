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
						<small>Time: <span id="time"></small>
					</h1>
					
					
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-green"><img src="${pageContext.request.contextPath}/imgs/1-deluxeroom.png" style="width: 80px; height: 80px; margin-bottom: 11px;"></span>

            <div class="info-box-content">
              <span class="info-box-text">Deluxe Room</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countGoodCondition}</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-yellow"><img src="${pageContext.request.contextPath}/imgs/2-amumaspasuite.png" style="width: 80px; height: 80px; margin-bottom: 11px;"></span>

            <div class="info-box-content">
              <span class="info-box-text">Amuma Spa Suite</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countNeedsMaint}</span>
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
            <span class="info-box-icon bg-red"><img src="${pageContext.request.contextPath}/imgs/3-premierdeluxeroom.png" style="width: 80px; height: 80px; margin-bottom: 11px;"></span>

            <div class="info-box-content">
              <span class="info-box-text">Premier Deluxe Room</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countNeedsRepair}</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->

		 	<div class="col-md-3 col-sm-6 col-xs-12">
         	 <div class="info-box">
          	  <span class="info-box-icon" style="background-color: #00C0EF"><img src="${pageContext.request.contextPath}/imgs/4-royalbungalow.png" style="width: 80px; height: 80px; margin-bottom: 11px;"></span>

           	 <div class="info-box-content">
              <span class="info-box-text">Royal Bungalow</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countNeedReplace}</span>
           	 </div>
           	 <!-- /.info-box-content -->
          	</div>
          <!-- /.info-box -->
    	</div>
	</div>
					
					<div class="row">
					<div class="col-md-8"></div>
						<div class="col-md-2">
					    <div class="form-group pull-right">
                
                 <div class="dropdown">
              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Select Room
             <span class="caret"></span>
             </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2" style="">
                <c:forEach items="${roomDropDown}" var="item" varStatus = "status"> 
                <li><a href="/inventory/${item.roomId}">Room ${item.roomName}</a></li>    
                </c:forEach>
            </ul>
            </div>
                </div>
				</div>

<div class="col-md-2">
<form action="/searchinventbyroom" method="get">
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

					<!--Option 1-->
						<div class="col-md-3">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Deluxe Room</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 500px">
									<table class="table table-head-fixed">
										<tbody>
											<tr>
												<th>Room No.</th>
												<th>Item</th>
												<th>Current out of Max</th>
											</tr>
										<c:forEach items="${deluxeInventList}" var="item" varStatus = "status">
											<tr>			
												<td>${deluxeRoomNameList[status.index]}</td>								
												<td>${item.inventName}</td>					
												<td>${item.inventCurrentQuantity} out of ${item.inventMaxQuantity}</td>
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
									<h3 class="box-title">Amuma Spa Suite</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 500px" >
									<table class="table table-head-fixed">


										<tbody><tr>
											<th>Room No.</th>
											<th>Item</th>
											<th>Current out of Max</th>
										</tr>
										<c:forEach items="${amumuSuiteInventList}" var="item" varStatus = "status">
										<tr>
											<td>${amumaSuiteRoomNameList[status.index]}</td>								
												<td>${item.inventName}</td>					
												<td>${item.inventCurrentQuantity} out of ${item.inventMaxQuantity}</td>	
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
									<h3 class="box-title">Premier Deluxe Room</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 500px">
									<table class="table table-head-fixed">


										<tbody><tr>
											<th>Room No.</th>
											<th>Item</th>
											<th>Current out of Max</th>
											
										</tr>
										<c:forEach items="${premierDeluxeInventList}" var="item" varStatus = "status">
										<tr>
												<td>${premierDeluxeRoomNameList[status.index]}</td>								
												<td>${item.inventName}</td>					
												<td>${item.inventCurrentQuantity} out of ${item.inventMaxQuantity}</td>	
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
									<h3 class="box-title">Royal Bungalow</h3>
								</div>
								<!-- /.box-header -->
									<div class="box-body no-padding table-responsive" style="height: 500px">
									<table class="table table-head-fixed">
										<tbody>
											<tr>
											<th>Room No.</th>
											<th>Item</th>
											<th>Current out of Max</th>
																
											</tr>

											<c:forEach items="${royalBungalowInventList}" var="item" varStatus = "status">
											<tr>										
												<td>${royalBungalowRoomNameList[status.index]}</td>								
												<td>${item.inventName}</td>					
												<td>${item.inventCurrentQuantity} out of ${item.inventMaxQuantity}</td>											
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
						<div class="row">

						<!--Option 1-->
				
						<div class="col-md-12">
							<div class="box box-default">
								<div class="box-header bg-default">
									<h3 class="box-title">Inventory List</h3>

								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 450px">
									<table class="table table-head-fixed">
										<tbody>
											<tr>
												<th>Room No.</th>
												<th>Name</th>
												<th>Current</th>
												<th>Max</th>
										
											</tr>
										<c:forEach items="${inventList}" var="item" varStatus = "status">
												<tr>			
													<td>${inventListRoomName[status.index]}</td>								
													<td>${item.inventName}</td>
													<td>${item.inventCurrentQuantity}</td>		
													<td>${item.inventMaxQuantity}</td>
												</tr>
										</c:forEach>
										</tbody>
										</table>
								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
                        

					
						
							<!-- /.box -->
				</div>
				</div>
					
					</section>
					</div>
	</jsp:attribute>
</mt:admin_template>

