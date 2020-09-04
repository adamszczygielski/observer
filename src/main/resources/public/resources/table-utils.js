function toggle(source) {
    checkboxes = document.getElementsByName('id');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = source.checked;
    }
}

function getSelectedId() {
    checkboxes = document.getElementsByName('id');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        if (checkboxes[i].checked) {
            return checkboxes[i].value;
        }
    }
}