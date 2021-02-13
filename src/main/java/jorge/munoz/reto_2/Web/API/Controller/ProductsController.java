package jorge.munoz.reto_2.Web.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jorge.munoz.reto_2.Services.ProductsService;
import jorge.munoz.reto_2.Services.Models.ProductDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("products/v1")
public class ProductsController {
    private final ProductsService moviesService;

    ProductsController(ProductsService moviesService){
        this.moviesService = moviesService;
    }

    @GetMapping()
    public List<ProductDTO> GetProduct(){
        return moviesService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getMovieDetailbyID(@PathVariable("id") Long id) {
        return moviesService.findbyId(id);
    }

    /*
    CRUD METHODS
    */
    @PostMapping("/movie")
    public ProductDTO AddUser(@RequestBody ProductDTO movie) {
        return moviesService.add(movie);
    }

    @PutMapping("/update/{id}")
    public Optional<ProductDTO> UpdateUser(@RequestBody ProductDTO movie, @PathVariable("id") Long id) {
        //Mejor hacer un if y si no hay nada, return null o error correspondiente. 
        return moviesService.update(id, movie);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteMovie (@PathVariable("id") Long id) {
        moviesService.delete(id);
    }

}
