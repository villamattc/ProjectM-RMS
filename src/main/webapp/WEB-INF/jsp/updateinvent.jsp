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
						Update Inventory
						<small>Time: <span id="time"></small>
					</h1>
					
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
					<form:form action= "/${id}/testupdateinvent" method ="POST" modelAttribute = "attachInvents">
					<div class="row">

					<!--Option 1-->
					
						<div class="col-md-12">
							<div class="box box-success">
								<div class="box-header bg-green">
									<h3 class="box-title">Room Name</h3>

								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<table class="table table-striped">
									
										<tbody>
											<tr>
											
												<th>Name</th>
												<th>Max</th>
												<th>Current</th>
												
											</tr>
											<tr>
               									<td hidden="true">
                    							<%-- ${item.inventName} --%>
                   								<form:input class="form-control" path="attach" value = "${attachInvents.attach}"/>
                								</td>
            										</tr>
									   				<c:forEach items="${attachInvents.list}" var="item" varStatus="status">
													<tr>			
													<td>
                        							<form:input class="form-control" path="list[${status.index}].inventName" value="${item.inventName}" hidden="true" />
                    								</td>												
													<td>  
                        							<form:input class="form-control" path="list[${status.index}].inventMaxQuantity" value="${item.inventMaxQuantity}"/>
                   									</td>
													 <td>  
                        							<form:input type="number" class="form-control" path="list[${status.index}].inventCurrentQuantity" value="${item.inventCurrentQuantity}"/>

													<%-- <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                          <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    </span>
                                    <form:input type="text" id="quantity" name="quantity"  class="form-control input-number" path="list[${status.index}].inventCurrentQuantity" value="${item.inventCurrentQuantity}" min="1" max="${item.inventMaxQuantity}">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>
                        </div> --%>

                    								</td>
													<%-- <td>
                                                      <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                          <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    </span>
                                    <input type="text" id="quantity" name="quantity" class="form-control input-number" value="${item.inventCurrentQuantity}" min="1" max="${item.inventMaxQuantity}">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                               						 </div>
                                                    </td> --%>
									
												</tr>
												
											</c:forEach>
											
										</tbody>
										
										
									</table>
									



								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
							<button type="submit" class="btn btn-primary pull-right"> Update Invetory</button>
						</div>
						</form:form>
						


					
						
							<!-- /.box -->
						</div>
					</section></div>
	</jsp:attribute>
</mt:admin_template>

<script>
$(document).ready(function(){

var quantitiy=0;
   $('.quantity-right-plus').click(function(e){
        
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('#quantity').val());
        
        // If is not undefined
            
            $('#quantity').val(quantity + 1);

          
            // Increment
        
    });

     $('.quantity-left-minus').click(function(e){
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('#quantity').val());
        
        // If is not undefined
      
            // Increment
            if(quantity>0){
            $('#quantity').val(quantity - 1);
            }
    });
    
});
</script>