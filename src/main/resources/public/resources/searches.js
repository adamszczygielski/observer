function countItems() {
    var sum = 0;
    var text;
    var table = document.getElementById("items-table");

    for (var i = 1; i < table.rows.length; i++) {
        text = table.rows[i].cells[6].innerText;
        if (text) {
            sum += parseInt(text);
        }
    }

    if (sum > 0) {
        document.title = "(" + sum + ")" + " " + document.title;
    }
}

function edit(source) {
    var id = getSelectedId();

    if (typeof id != 'undefined') {
        window.location.href = "/form/search/" + id;
        return;
    }
    alert("No item selected!");
}

function remove(source) {
    if (typeof getSelectedId() == 'undefined') {
        alert("No item selected!");
        return false;
    }
    return confirm('Are you sure?');
}

function getSelectedId() {
    checkboxes = document.getElementsByName('id');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        if (checkboxes[i].checked) {
            return checkboxes[i].value;
        }
    }
}