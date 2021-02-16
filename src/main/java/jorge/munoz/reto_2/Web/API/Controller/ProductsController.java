package jorge.munoz.reto_2.Web.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jorge.munoz.reto_2.Services.ProductsService;
import jorge.munoz.reto_2.Services.Models.ProductDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("products/v1")
public class ProductsController {
    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping()
    public List<ProductDTO> GetProduct(){
        return productsService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductbyID(@PathVariable("id") Long id) {
        return productsService.findbyId(id);
    }

    /*
    CRUD METHODS
    */
    @PostMapping()
    public ProductDTO AddProduct(@RequestBody ProductDTO product) {
        return productsService.add(product);
    }

    @PutMapping("/update/{id}")
    public Optional<ProductDTO> UpdateProduct(@RequestBody ProductDTO product, @PathVariable("id") Long id) {
        return productsService.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteProduct (@PathVariable("id") Long id) {
        productsService.delete(id);
    }

}
