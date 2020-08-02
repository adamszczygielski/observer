sum = 0;
var table = document.getElementById("items-table");
for (var i = 1; i < table.rows.length; i++) {
    sum += parseInt(table.rows[i].cells[5].innerText);
}
if (sum > 0) {
    document.title = "(" + sum + ")" + " " + document.title;
}