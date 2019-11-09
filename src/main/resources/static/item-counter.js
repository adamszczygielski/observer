var rows = document.getElementById('items-table').getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
if(rows > 0) {
    document.title = "(" + rows + ")" + " " + document.title;
}