function toggleCheckboxes(checked) {
    checkboxes = getCheckboxes();
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = checked;
    }
}

function getFirstSelectedId() {
    checkboxes = getCheckboxes();
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        if (checkboxes[i].checked) {
            return checkboxes[i].value;
        }
    }
}

function getSelectedIds() {
    checkboxes = getCheckboxes();
    var ids = [];
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        if (checkboxes[i].checked) {
            ids.push(checkboxes[i].value);
        }
    }
    return ids;
}

function getCheckboxes() {
    return document.getElementsByName('id');
}

function displayCounter(val) {
    if (val > 0) {
        document.title = "(" + val + ")" + " " + document.title;
    }
}