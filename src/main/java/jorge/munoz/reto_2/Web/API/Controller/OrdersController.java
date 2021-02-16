package jorge.munoz.reto_2.Web.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jorge.munoz.reto_2.Services.OrdersService;
import jorge.munoz.reto_2.Services.Models.OrderDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("orders/v1")
public class OrdersController {
    private final OrdersService ordersService;

    OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping()
    public List<OrderDTO> GetProduct(){
        return ordersService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getMovieDetailbyID(@PathVariable("id") Long id) {
        return ordersService.findbyId(id);
    }

    /*
    CRUD METHODS
    */
    @PostMapping("/movie")
    public OrderDTO AddUser(@RequestBody OrderDTO movie) {
        return ordersService.add(movie);
    }

    @PutMapping("/update/{id}")
    public Optional<OrderDTO> UpdateUser(@RequestBody OrderDTO movie, @PathVariable("id") Long id) {
        //Mejor hacer un if y si no hay nada, return null o error correspondiente. 
        return ordersService.update(id, movie);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteMovie (@PathVariable("id") Long id) {
        ordersService.delete(id);
    }

}
