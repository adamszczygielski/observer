function onSourceChange() {
    var source = document.getElementById("inputSource");
    var button = document.getElementById("selectCategoryButton");
    var category = document.getElementById("category");

    clearCategories();
    if (source.value == "EBAY") {
        button.disabled = true;
        category.disabled = true;
    } else {
        button.disabled = false;
        category.disabled = false;
    }
}

function clearCategories() {
    document.getElementById("category").length = 0;
    getCategories();
}

function getCategories(isFirstCall) {
    var xhr = new XMLHttpRequest();
    var categorySelector = document.getElementById("category");
    var sourceSelector = document.getElementById("inputSource");
    var selectedParentId = '';
    var selectedSourceId = sourceSelector.options[sourceSelector.selectedIndex].id
    var url = '/categories?sourceId=' + selectedSourceId;

    if (typeof categorySelector.options[categorySelector.selectedIndex] != 'undefined') {
        selectedParentId = categorySelector.options[categorySelector.selectedIndex].value;
        url += '&parentId=' + selectedParentId;
    }
    xhr.open('GET', url, true);

    xhr.onload = function() {
        var data = JSON.parse(this.response);

        if (!isFirstCall) {
            document.getElementById("inputCategory").value = selectedParentId;
        }

        if (Object.keys(data).length == 0) {
            return;
        }

        categorySelector.options.length = 0;

        data.forEach((category) => {
            var el = document.createElement("option");
            el.textContent = category.name;
            el.value = category.id;
            categorySelector.appendChild(el);
        })
    }
    xhr.send();
}