function countItems() {
    return document
        .getElementById('items-table')
        .getElementsByTagName("tbody")[0]
        .getElementsByTagName("tr")
        .length;
}

function onDelete() {
    if (typeof getFirstSelectedId() == 'undefined') {
        alert("No items selected!");
        return false;
    }
    return true;
}