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
    public OrderDTO getOrderbyID(@PathVariable("id") Long id) {
        return ordersService.findbyId(id);
    }

    /*
    CRUD METHODS
    */
    @PostMapping()
    public OrderDTO AddOrder(@RequestBody OrderDTO order) {
        return ordersService.add(order);
    }

    @PutMapping("/update/{id}")
    public Optional<OrderDTO> UpdateOrder(@RequestBody OrderDTO order, @PathVariable("id") Long id) {
        return ordersService.update(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteOrder (@PathVariable("id") Long id) {
        ordersService.delete(id);
    }

}
