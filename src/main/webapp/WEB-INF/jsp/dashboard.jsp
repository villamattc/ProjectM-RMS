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
                    <small>Date today</small>
                  </h1>
                  <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                  </ol>
                </section>
            
                <!-- Main content -->
                <section class="content">
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
                          <h3 class="box-title">Most Visited Room</h3>
            
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
                'rgba(251, 141, 166)',
                'rgba(151, 213, 231)',
                'rgba(255, 242, 157)',
                'rgba(171, 209, 175)'
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
                'rgba(255, 166, 254)',
                'rgba(168, 193, 168)',
                'rgba(159, 157, 186)'
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
                'rgba(121, 168, 166)',
                'rgba(166, 141, 165)',
                'rgba(185, 153, 136)'
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
        labels: ['Filipino', 'Chinese', 'Korean', 'American', 'Japanese', 'Vietnamese', 'Taiwanese', 'Others'],
        datasets: [
          {
            label: 'Nationalities',
            data: [${filipino},${chinese},${korean},${american},${japanese},${vietnamese},${taiwanese},${others}],
            backgroundColor: [
                'rgba(250, 209, 64)',
                'rgba(189, 65, 58)',
                'rgba(250, 164, 149)',
                'rgba(183, 177, 220)',
                'rgba(78, 179, 205)',
                'rgba(117, 200, 158)',
                'rgba(136, 144, 153)',
                'rgba(208, 192, 146)'
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


              
    </jsp:attribute>
</mt:admin_template>