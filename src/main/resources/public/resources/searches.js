function countItems() {
    var sum = 0;
    var text;
    var table = document.getElementById("items-table");

    for (var i = 1; i < table.rows.length; i++) {
        text = table.rows[i].cells[9].innerText;
        if (text) {
            sum += parseInt(text);
        }
    }
    displayCounter(sum);
}

function edit() {
    var id = getSelectedId();

    if (typeof id != 'undefined') {
        window.location.href = "/form/search/" + id;
        return;
    }
    alert("No searches selected!");
}

function remove() {
    if (typeof getSelectedId() == 'undefined') {
        alert("No searches selected!");
        return false;
    }
    return confirm('Are you sure?');
}