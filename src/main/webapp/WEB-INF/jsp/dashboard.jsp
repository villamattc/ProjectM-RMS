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
                      <!-- PIE CHART -->
                      <div class="col-md-6">
                      <div class="box box-default">
                        <div class="box-header with-border">
                          <h3 class="box-title">Equipment Status <small>Pie Chart</small></h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                         <canvas id="pieChart" class="chartjs" width="770" height="385" style="display: block; width: 770px; height: 385px;"></canvas>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
                    </div>
                    <!--DOUGHNUT-->
                  <div class="col-md-6">
                      <div class="box box-default">
                        <div class="box-header with-border">
                          <h3 class="box-title">Room Type <small>Pie Chart</small></h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                         <canvas id="pieChart1" class="chartjs" width="770" height="385" style="display: block; width: 770px; height: 385px;"></canvas>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
                    </div>
                  </div>
                  <!-- /.row -->



                  <%-- <div class="row">

                  <div class="col-md-6">
                      <div class="box box-default">
                        <div class="box-header with-border">
                          <h3 class="box-title">Room Status <small>Polar Area Chart</small></h3>
            
                          <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                          </div>
                        </div>
                        <div class="box-body">
                         <canvas id="polarArea" class="chartjs" width="770" height="385" style="display: block; width: 770px; height: 385px;"></canvas>
                        </div>
                        <!-- /.box-body -->
                      </div>
                      <!-- /.box -->
                    </div>
                  </div>
                  
                  
                  </div> --%>
           
          

            
                </section>
                <!-- /.content -->
              </div>
              
<script>

        //PIE!
var ctx = document.getElementById('pieChart');
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['Good Condition', 'Need Maintainance', 'Need Repair', 'Need Replace'],
        datasets: [{
            label: '# of Votes',
            data: [${goodCondition},${needsMaint},${needsRepair},${needReplace}],
            backgroundColor: [
                '#00A65A',
                '#F39C12',
                '#DD4B39',
                '#00C0EF',
            ],
          
        }]
    }
});
//PIE2
var ctx = document.getElementById('pieChart1');
var myPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Deluxe Room', 'Amuma Spa Suite', 'Premier Deluxe Room', 'Royal Bungalow'],
        datasets: [{
            label: '# of Votes',
            data: [${deluxeRoom},${amumaSpaSuite},${premierDeluxeRoom},${royalBungalow}],
            backgroundColor: [
                '#00A65A',
                '#F39C12',
                '#DD4B39',
                '#00C0EF',
            ],
          
        }]
    }
});

// //POLAR
// var ctx = document.getElementById('pieChart1');
// var myPieChart = new Chart(ctx, {
//     type: 'polarArea',
//     data: {
//         labels: ['Deluxe Room', 'Amuma Spa Suite', 'Premier Deluxe Room', 'Royal Bungalow'],
//         datasets: [{
//             label: '# of Votes',
//             data: [${deluxeRoom},${amumaSpaSuite},${premierDeluxeRoom},${royalBungalow}],
//             backgroundColor: [
//                 '#00A65A',
//                 '#F39C12',
//                 '#DD4B39',
//                 '#00C0EF',
//             ],
          
//         }]
//     }
// });
</script>



              
    </jsp:attribute>
</mt:admin_template>