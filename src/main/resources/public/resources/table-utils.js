function toggleCheckboxes(checked) {
    checkboxes = document.getElementsByName('id');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = checked;
    }
}

function displayCounter(val) {
    if (val > 0) {
        document.title = "(" + val + ")" + " " + document.title;
    }
}