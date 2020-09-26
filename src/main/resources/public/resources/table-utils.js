function toggle(source) {
    checkboxes = getCheckboxes();
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = source.checked;
    }
}

function getSelectedId() {
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

function displayCounter(sum) {
    if (sum > 0) {
        document.title = "(" + sum + ")" + " " + document.title;
    }
}