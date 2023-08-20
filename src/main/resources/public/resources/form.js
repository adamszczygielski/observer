function onPageLoad() {
    fillCategorySection();
    setComponentsAccess();
}

function onSourceChange() {
    clearCategorySection();
    fillCategorySection();
    setComponentsAccess();
}

function setComponentsAccess() {
    var inputCategoryName = document.getElementById("inputCategoryName");
    var inputCategoryId = document.getElementById("inputCategoryId");
    var categorySelector = document.getElementById("categorySelector");
    var button = document.getElementById("selectCategoryButton");

    switch (document.getElementById("inputSource").value) {
        case 'ALLEGRO':
            inputCategoryName.readOnly = true;
            inputCategoryId.readOnly = true;
            categorySelector.disabled = false;
            button.disabled = false;
            break;
        case 'ALLEGRO_LOKALNIE':
            inputCategoryName.readOnly = false;
            inputCategoryId.readOnly = false;
            categorySelector.disabled = true;
            button.disabled = true;
            break;
        case 'OLX':
            inputCategoryName.readOnly = true;
            inputCategoryId.readOnly = true;
            categorySelector.disabled = false;
            button.disabled = false;
            break;
        default:
            inputCategoryName.readOnly = true;
            inputCategoryId.readOnly = true;
            categorySelector.disabled = true;
            button.disabled = true;
    }
}

function clearCategorySection() {
    document.getElementById("inputCategoryName").value = null;
    document.getElementById("inputCategoryId").value = null;
    document.getElementById("categorySelector").length = 0;
    fillCategorySection();
}

function fillCategorySection() {
    var sourceSelector = document.getElementById("inputSource");
    var sourceId = sourceSelector.options[document.getElementById("inputSource").selectedIndex].id;
    var categorySelector = document.getElementById("categorySelector");
    var categoryId;

    var index = categorySelector.selectedIndex;
    if (index > -1) {
        categoryId = categorySelector.options[index].value;
        document.getElementById("inputCategoryName").value = categorySelector.options[index].text;
        document.getElementById("inputCategoryId").value = categorySelector.options[index].value;
    }

    var url = createRequestUrl(sourceId, categoryId);
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);

    xhr.onload = function() {
        var categories = JSON.parse(this.response);
        if (Object.keys(categories).length >= 1) {
            populateCategorySelector(categorySelector, categories);
        }
    }
    xhr.send();
}

function populateCategorySelector(categorySelector, categories) {
    categorySelector.options.length = 0;
    categories.forEach((category) => {
        var el = document.createElement("option");
        el.textContent = category.name;
        el.value = category.id;
        categorySelector.appendChild(el);
    })
}

function createRequestUrl(sourceId, parentId) {
    var url = '/categories?sourceId=' + sourceId;
    if (parentId) {
        url += '&parentId=' + parentId;
    }
    return url;
}