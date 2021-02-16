function reload() {
    var e = document.getElementById("languages");
    var selectedLang = e.options[e.selectedIndex].value;

    var url = "?lang=" + selectedLang
    location.href = url;
}

function addProduct(id_product) {

    let url = 'http://localhost:9292/orders/3/products/1?action=add'

    fetch('http://localhost:9292/products/' + id_product)
        .then(res => respones = res.json())
        .then(data => {

            fetch(url, {
                method: 'PUT',
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                window.location.href = "/home";
            });
        })

}

function removeProduct(id_product) {

    let url = 'http://localhost:9292/orders/3/products/1?action=delete'

    fetch('http://localhost:9292/products/' + id_product)
        .then(res => respones = res.json())
        .then(data => {

            fetch(url, {
                method: 'PUT',
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                window.location.href = "/home";
            });
        })
}


function getBodyProduct(id) {
    let product = {}
    fetch('http://localhost:9292/products/' + id)
        .then(res => respones = res.json())
        .then(data => {
            product = { '"id_product"': parseInt(data.id_product), '"name"': data.name, '"price"': data.price, '"url_product"': data.url_product };
            return product;
        })
}

function addNewProduct(id_product) {

    let url = 'http://localhost:9292/oders/3/product'

    fetch('http://localhost:9292/products/' + id_product)
        .then(res => respones = res.json())
        .then(data => {

            fetch(url, {
                method: 'POST',
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                window.location.href = "/home";
            });
        })

}

function deleteProducts(id) {
    fetch('http://localhost:9292/orderproducts/' + id, {
            method: 'DELETE',
        })
        .then(res => res.text())
        .then(res => {
            console.log(res);
            window.location.href = "/home";
        })
}

function deleteCompleteOrder(id) {
    fetch('http://localhost:9292/orderproducts/order/' + id, {
            method: 'DELETE',
        })
        .then(res => res.text())
        .then(res => {
            console.log(res);
            window.location.href = "/home";
        })
}