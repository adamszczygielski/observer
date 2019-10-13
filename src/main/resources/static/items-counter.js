sumVal = 0;
var table = document.getElementById("items-table");
for(var i = 1; i < table.rows.length - 1; i++) {
    sumVal = sumVal + parseInt(table.rows[i].cells[4].innerText);
};
if(sumVal > 0) {
    document.title = "(" + sumVal + ")" + " " + document.title;
}