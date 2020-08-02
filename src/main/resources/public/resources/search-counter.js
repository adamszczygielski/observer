var sum = 0;
var text;
var table = document.getElementById("items-table");

for (var i = 1; i < table.rows.length; i++) {
    text = table.rows[i].cells[5].innerText;
    if (text) {
        sum += parseInt(text);
    }
}

if (sum > 0) {
    document.title = "(" + sum + ")" + " " + document.title;
}