function onSourceChange() {
    var sourceSelector = document.getElementById("inputSource");
    var categorySelector = document.getElementById("category");
    var button = document.getElementById("selectCategoryButton");

    clearCategories();
    if (sourceSelector.value == "EBAY") {
        button.disabled = true;
        categorySelector.disabled = true;
    } else {
        button.disabled = false;
        categorySelector.disabled = false;
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
    var selectedCategoryId = '';
    var selectedCategoryName = '';
    var selectedSourceId = sourceSelector.options[sourceSelector.selectedIndex].id
    var url = '/categories?sourceId=' + selectedSourceId;

    if (typeof categorySelector.options[categorySelector.selectedIndex] != 'undefined') {
        selectedCategoryId = categorySelector.options[categorySelector.selectedIndex].value;
        selectedCategoryName = categorySelector.options[categorySelector.selectedIndex].text;
        url += '&parentId=' + selectedCategoryId;
    }
    xhr.open('GET', url, true);

    xhr.onload = function() {
        var data = JSON.parse(this.response);

        if (!isFirstCall) {
            document.getElementById("inputCategoryId").value = selectedCategoryId;
            document.getElementById("inputCategoryName").value = selectedCategoryName;
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