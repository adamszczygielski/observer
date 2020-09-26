function countItems() {
    var rows = document
        .getElementById('items-table')
        .getElementsByTagName("tbody")[0]
        .getElementsByTagName("tr")
        .length;

    displayCounter(rows);
}

function remove(source) {
    if (typeof getSelectedId() == 'undefined') {
        alert("No items selected!");
        return false;
    }
    return true;
}