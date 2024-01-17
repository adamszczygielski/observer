function countItems() {
    var sum = 0;
    var rows = document.getElementById("items-table").rows;
    for (var i = 1; i < rows.length; i++) {
        val = rows[i].cells[7].innerText;
        if (val) {
            sum += parseInt(val);
        }
    }
    return sum;
}

function editSearch(id) {
    window.location.href = "/form/search/" + id;
}

function executeSearch(id) {
    window.location.href = "items/" + id + "/preview";
}

function onDelete(event) {
    if (!confirm('Are you sure?')) {
        event.preventDefault();
    }
}