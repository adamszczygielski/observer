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

function update() {
    var url = createUpdateUrl();

    if (typeof url == 'undefined') {
        return;
    }
    var xhr = new XMLHttpRequest();
    xhr.open('PATCH', url, true);
    xhr.onload = function () {
        if (xhr.status == "200") {
            location.reload();
        }
    }
    xhr.send();
}

function createUpdateUrl() {
    var ids = getSelectedIds();
    var url;

    if (ids.length > 0) {
        url = "/searches?id=" + ids[0];
        for (var i = 1; i < ids.length; i++) {
            url += "," + ids[i];
        }
    } else {
        alert("No searches selected!");
    }
    return url;
}
