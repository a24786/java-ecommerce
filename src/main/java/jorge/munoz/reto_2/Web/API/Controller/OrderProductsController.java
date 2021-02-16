package jorge.munoz.reto_2.Web.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jorge.munoz.reto_2.Services.OrderProductsService;
import jorge.munoz.reto_2.Services.Models.OrderProductDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("orderproducts/v1")
public class OrderProductsController {
    private final OrderProductsService orderproductsService;

    OrderProductsController(OrderProductsService orderproductsService){
        this.orderproductsService = orderproductsService;
    }

    @GetMapping()
    public List<OrderProductDTO> GetProduct(){
        return orderproductsService.getAll();
    }

    @GetMapping("/{id}")
    public OrderProductDTO getMovieDetailbyID(@PathVariable("id") Long id) {
        return orderproductsService.findbyId(id);
    }

    /*
    CRUD METHODS
    */
    @PostMapping("/movie")
    public OrderProductDTO AddUser(@RequestBody OrderProductDTO movie) {
        return orderproductsService.add(movie);
    }

    @PutMapping("/update/{id}")
    public Optional<OrderProductDTO> UpdateUser(@RequestBody OrderProductDTO movie, @PathVariable("id") Long id) {
        //Mejor hacer un if y si no hay nada, return null o error correspondiente. 
        return orderproductsService.update(id, movie);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteMovie (@PathVariable("id") Long id) {
        orderproductsService.delete(id);
    }

}
