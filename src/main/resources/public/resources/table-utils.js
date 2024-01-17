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

function handleKeyDown(event) {
    if (event.key >= '0' && event.key <= '9') {
        const checkbox = document.getElementById(event.key);
        if (checkbox) {
            checkbox.checked = !checkbox.checked;
            if (event.key === '0') {
                toggleCheckboxes(checkbox.checked);
            }
        }
    } else if (event.key == 'Delete') {
        document.forms[0].submit();
    }
}

document.addEventListener('keydown', handleKeyDown);