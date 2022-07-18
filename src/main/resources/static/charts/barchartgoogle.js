google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function getExpense(){
  let items = document.getElementsByClassName("item");
  let installments = document.getElementsByClassName("vInstallments");
  let vItems = [];
  let vInstallments =[];
  for (const item of items) {
    vItems.push(item.innerHTML);
  }

  console.log(vItems);
}
getExpense()
function drawChart() {
  let data = google.visualization.arrayToDataTable([
    ["Element", "Density", { role: "style" } ],
    ["Renda", 100, "#0D6EFD"],
    ["Meta", 30, "#0D6EFD"],
    ["Faculdade", 10.49, "#14DBA9"],
    ["Emprestimo", 19.30, "#14DBA9"],
    ["Carro", 30.30, "#14DBA9"],
    ["Platinum", 90.45, "#14DBA9"],
  ]);

  let view = new google.visualization.DataView(data);
  view.setColumns([0, 1,
                   { calc: "stringify",
                     sourceColumn: 1,
                     type: "string",
                     role: "annotation" },
                   2]);

  let options = {
    title: "Impacto sobre a renda ",
    width: 300,
    height: 200,
    bar: {groupWidth: "95%"},
    legend: { position: "none" },
  };
  let chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
  chart.draw(view, options);
}
