function countItems() {
    var sum = 0;
    var table = document.getElementById("items-table");
    var length = table.rows.length;
    if (length == 1) {
        return;
    }
    for (var i = 1; i < length; i++) {
        val = table.rows[i].cells[9].innerText;
        if (val) {
            sum += parseInt(val);
        }
    }
    return sum;
}

function redirectToEdit() {
    var id = getFirstSelectedId();
    if (typeof id != 'undefined') {
        window.location.href = "/form/search/" + id;
        return;
    }
    alert("No searches selected!");
}

function onDelete() {
    if (typeof getFirstSelectedId() == 'undefined') {
        alert("No searches selected!");
        return false;
    }
    return confirm('Are you sure?');
}