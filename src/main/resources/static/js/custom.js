function reload() {
    var e = document.getElementById("languages");
    var selectedLang = e.options[e.selectedIndex].value;

    var url = "?lang=" + selectedLang
    location.href = url;
}

function incrementQty(id_product) {

    let url = '/orderproducts/v1/orderproduct'

    fetch('/products/v1/' + id_product)
        .then(res => respones = res.json())
        .then(data => {
            var productID = data.id;
            var orderID = 3;
            var qty = 1;
            fetch(url, {
                method: 'POST',
                body: JSON.stringify({ "idProduct": id_product, "qty": 1, "idOrder": orderID }),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                location.reload();
            });

        })
        .catch(error => console.log(error));

}

function deleteProduct(id) {
    fetch('/orderproducts/v1/delete/' + id + '/product', {
            method: 'DELETE',
        })
        .then(res => res.text())
        .then(res => {
            console.log(res);
            location.reload();
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