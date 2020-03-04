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
                
                 <div class="dropdown">
              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Select Room
             <span class="caret"></span>
             </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2" style="">
                <c:forEach items="${room}" var="item" varStatus = "status"> 
                <li><a href="/inventory/${item.roomId}">Room ${item.roomName}</a></li>    
                </c:forEach>
            </ul>
            </div>
                </div>
				</div>
<div class="col-md-8"></div>
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
				<div class="col-md-1"></div>
						<div class="col-md-10">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Room Name</h3>

								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped">
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
                        <div class="col-md-1"></div>

					
						
							<!-- /.box -->
						</div>
					</section></div>
	</jsp:attribute>
</mt:admin_template>

