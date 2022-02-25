function countItems() {
    return document
        .getElementById('items-table')
        .getElementsByTagName("tbody")[0]
        .getElementsByTagName("tr")
        .length;
}