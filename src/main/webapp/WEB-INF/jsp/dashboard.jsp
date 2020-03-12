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
<script src="${pageContext.request.contextPath}/Chart.js"></script>

<mt:admin_template title="Dasboard">
    <jsp:attribute name="content">
       
            <div class="content-wrapper" style="min-height: 986px;">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                  <h1>
                    Dashboard
                    <small>Time: <span id="time"></small>
                  </h1>
                  <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                  </ol>
                </section>
            
                <!-- Main content -->
                <section class="content">
                
<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-green"><i class="fa fa-thumbs-o-up" style="margin-top: 15px;"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Good Condition</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countGoodCondition}</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-yellow"><i class="fa fa-calendar-check-o" style="margin-top: 15px;"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Need Maintainance</span>
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
            <span class="info-box-icon bg-red"><i class="fa fa-wrench" style="margin-top: 15px;"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Need Repair</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countNeedsRepair}</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->

		 	<div class="col-md-3 col-sm-6 col-xs-12">
         	 <div class="info-box">
          	  <span class="info-box-icon" style="background-color: #00C0EF"><i class="fa fa-refresh" style="margin-top: 15px;"></i></span>

           	 <div class="info-box-content">
              <span class="info-box-text">Need Replacement</span>
              <span class="info-box-number" style="font-size: 40px; font-weight: normal;">${countNeedReplace}</span>
           	 </div>
           	 <!-- /.info-box-content -->
          	</div>
          <!-- /.info-box -->
    	</div>
	</div>

                
                  <div class="row">
                  <div class="col-md-4">
							<div class="box box-warning">
								<div class="box-header bg-yellow">
									<h3 class="box-title">Scheduled Maintainance</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding table-responsive" style="height: 250px">
									<table class="table table-head-fixed">
										<tbody>
											<tr>
												<th>Name</th>
												<th>Room No.</th>
												<th>Date</th>
                        <th></th>
											</tr>
                      <c:forEach items="${EquipmentOneMonthBeforeMaintenance}" var="item" varStatus = "status">
											<tr>											
												<td>${item.equipName}</td>
												<td>${EquipmentOneMonthBeforeMaintenanceRoomNumbers[status.index]}</td>											
												<td>${DatePlus90[status.index]}</td>		
                        
											</tr>
                      </c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
                  
						</div>

            <div class="col-md-4">
							<div class="box box-danger">
								<div class="box-header bg-red">
									<h3 class="box-title">To be repaired</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding" style="height: 250px">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Name</th>
												<th>Room No.</th>
												<th>Date</th>
											</tr>
                      <c:forEach items="${needsrepair}" var="item" varStatus = "status">
										<tr>
												<td>${item.equipName}</td>
													<td>${needsrepairRoomName[status.index]}</td>											
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

            <div class="col-md-4">
							<div class="box box-info">
								<div class="box-header" style="background-color: #00C0EF">
									<h3 class="box-title">To be replaced</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding" style="height: 250px">
									<table class="table table-striped">
										<tbody>
											<tr>
												<th>Name</th>
												<th>Room No.</th>
												<th>Date</th>
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
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
            <!--/.row-->
                  </div>


                  <div class="row">
                    <div class="col-md-6">
                      <!-- PIE CHART -->
                      <div class="box box-primary">
                        <div class="box-header with-border">
                          <h3 class="box-title">Equipment Status</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="pieChart" style="height: 251px; width: 514px;" height="251" width="514"></canvas>
                          </div>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                      <!-- DONUT CHART -->
                      <div class="box box-danger">
                        <div class="box-header with-border">
                          <h3 class="box-title">Room Types</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <canvas id="doughnutChart" style="height: 257px; width: 514px;" height="257" width="514"></canvas>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                    </div>
                    <!-- /.col (LEFT) -->
                    <div class="col-md-6">
                      <!-- POLAR AREA CHART -->
                      <div class="box box-info">
                        <div class="box-header with-border">
                          <h3 class="box-title">Room Status</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="polarChart" style="height: 251px; width: 514px;" height="251" width="514"></canvas>
                          </div>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                      <!-- BAR CHART -->
                      <div class="box box-success">
                        <div class="box-header with-border">
                          <h3 class="box-title">Top Nationalities</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="barChart" style="height: 256px; width: 514px;" height="256" width="514"></canvas>
                          </div>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                    </div>
                    <!-- /.col (RIGHT) -->
                  </div>
                  <!-- /.row -->
            
                </section>
                <!-- /.content -->
              </div>
              
<script>
    //----PIE CHART----//
    var ctx = document.getElementById('pieChart').getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['Good Condition', 'Need Maintenance', 'Need Repair', 'Need Replacement'],
        datasets: [
          { 
            label: 'Equipment Status',
            data: [${goodCondition},${needMaintenance},${needRepair},${needReplacement}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    }
});
//----POLAR AREA CHART----//
var ctx = document.getElementById('polarChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'polarArea',
    data: {
        labels: ['Vacant', 'Occupied', 'Reserved'],
        datasets: [{
            label: 'Room Status',
            data: [${vacant},${occupied},${reserved}],
            fill: false,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    }
});
//----DONUT CHART----//
var ctx = document.getElementById('doughnutChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Deluxe Room', 'Amuma Spa Suite', 'Premier Deluxe Room', 'Royal Bungalow'],
        datasets: [
          {
            label: 'Most Visited Room',
            data: [${deluxeRoom},${amumaSpaSuite},${premierDeluxeRoom},${royalBungalow}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    }
});
//----BAR CHART----//
var ctx = document.getElementById('barChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Afghan', 'Algerian', 'Australian', 'Bengali', 'Chinese', 'Colombian', 'Czech', 'Egyptian', 'Malaysian', 'Mexican',
                  'Mongolian', 'Pakistani', 'Filipino', 'Russian', 'Slovak', 'Spanish', 'Swedish', 'Thai', 'Turkish', 'Ugandan', 'Others'],
        datasets: [
          {
            label: 'Nationalities',
            data: [${afghan},${algerian},${australian},${bengali},${chinese},${colombian},${czech},${egyptian},${malaysian},${mexican},
            ${mongolian},${pakistani},${filipino},${russian},${slovak},${spanish},${swedish},${thai},${turkish},${ugandan},${others}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});

</script>

<script>
function addDate(){
  var theDate = new Date(${item.dateOfLastMaintenance});
var myNewDate = new Date(theDate);
myNewDate.setDate(myNewDate.getDate() + 90);

}
</script>

<script>
function addDays(date, days) {
  var result = new Date(date);
  result.setDate(result.getDate() + days);
  return result;
}
document.getElementById('addDays').innerHTML=v;
</script>

              
    </jsp:attribute>
</mt:admin_template>