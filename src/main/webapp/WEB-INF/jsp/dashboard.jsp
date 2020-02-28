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
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>

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
                      <!-- AREA CHART -->
                      <div class="box box-primary">
                        <div class="box-header with-border">
                          <h3 class="box-title">Area Chart</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="areaChart" style="height: 251px; width: 514px;" height="251" width="514"></canvas>
                          </div>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                      <!-- DONUT CHART -->
                      <div class="box box-danger">
                        <div class="box-header with-border">
                          <h3 class="box-title">Donut Chart</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                         <canvas id="pieChart" class="chartjs" width="830" height="415" style="display: block; height: 332px; width: 664px;"></canvas>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                    </div>
                    <!-- /.col (LEFT) -->
                    <div class="col-md-6">
                      <!-- LINE CHART -->
                      <div class="box box-info">
                        <div class="box-header with-border">
                          <h3 class="box-title">Line Chart</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="lineChart" style="height: 251px; width: 514px;" height="251" width="514"></canvas>
                          </div>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
            
                      <!-- BAR CHART -->
                      <div class="box box-success">
                        <div class="box-header with-border">
                          <h3 class="box-title">Bar Chart</h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                          <div class="chart">
                            <canvas id="barChart" style="height: 231px; width: 514px;" height="231" width="514"></canvas>
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
    //----AREA CHART----//
    var ctx = document.getElementById('areaChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Junuary', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
            {fill: 'origin'},
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
//----LINE CHART----//
var ctx = document.getElementById('lineChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['Junuary', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
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
//----DONUT CHART----//
var ctx = document.getElementById('barChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Junuary', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
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
//----BAR CHART----//
var ctx = document.getElementById('barChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
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
new Chart(document.getElementById("pieChart"),{"type":"pie","data":{"labels":["Red","Blue","Yellow"],"datasets":[{"label":"My First Dataset","data":[300,50,100],"backgroundColor":["rgb(255, 99, 132)","rgb(54, 162, 235)","rgb(255, 205, 86)"]}]}});
</script>


              
    </jsp:attribute>
</mt:admin_template>