function disableElements() {
    var source = document.getElementById("inputSource");
    var button = document.getElementById("selectCategoryButton");
    var category = document.getElementById("category");
    if (source.value != "ALLEGRO") {
        button.disabled = true;
        category.disabled = true;
        clearCategories();
    } else {
        category.disabled = false;
        button.disabled = false;
    }
}

function clearCategories() {
    document.getElementById("category").length = 0;
    getCategories();
}

function getCategories() {
    var request = new XMLHttpRequest()
    var select = document.getElementById("category");
    var url = '/util/categories/allegro';
    var selectedId = '';

    if (typeof select.options[select.selectedIndex] != 'undefined') {
        selectedId = select.options[select.selectedIndex].value;
        url += '?id=' + selectedId;
    }
    request.open('GET', url, true);

    request.onload = function() {
        var data = JSON.parse(this.response);
        document.getElementById("inputCategory").value = selectedId;

        if (Object.keys(data).length == 0) return;
        select.options.length = 0;

        data.forEach((category) => {
            var el = document.createElement("option");
            el.textContent = category.name;
            el.value = category.id;
            select.appendChild(el);
        })
    }
    request.send()
}