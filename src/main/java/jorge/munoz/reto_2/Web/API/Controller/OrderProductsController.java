package jorge.munoz.reto_2.Web.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jorge.munoz.reto_2.Services.OrderProductsService;
import jorge.munoz.reto_2.Services.Models.OrderProductDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("orderproducts/v1")
public class OrderProductsController {
    private final OrderProductsService orderproductsService;

    OrderProductsController(OrderProductsService orderproductsService) {
        this.orderproductsService = orderproductsService;
    }

    @GetMapping()
    public List<OrderProductDTO> GetProduct() throws ResponseStatusException {
        if(!orderproductsService.getAll().isEmpty()){
            return orderproductsService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public OrderProductDTO getOrderProductDetailbyID(@PathVariable("id") Long id) throws ResponseStatusException {
        try {
            return orderproductsService.findbyId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error adding new data", e);
        }
    }

    /*
     * CRUD METHODS
     */
    @PostMapping("/orderproduct")
    public OrderProductDTO AddOrderProduct(@RequestBody OrderProductDTO orderproduct) {
        try {
            return orderproductsService.add(orderproduct);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error adding new data", e);
        }
    }

    @PutMapping("/update/{id}")
    public Optional<OrderProductDTO> UpdateOrderProduct(@RequestBody OrderProductDTO orderproduct,
            @PathVariable("id") Long id) {
        // Mejor hacer un if y si no hay nada, return null o error correspondiente.
        try{
            return orderproductsService.update(id, orderproduct);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating data", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteOrderProduct(@PathVariable("id") Long id) throws ResponseStatusException {
        try{
            orderproductsService.delete(id);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating data", e);
        }
    }

    @DeleteMapping("/delete/{idProduct}/product")
    public void DeleteProductonOrderProduct(@PathVariable("idProduct") int idProduct) throws ResponseStatusException {
        try{
            orderproductsService.deleteByIdProduct(Long.valueOf(idProduct));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error deletting new data", e);
        }
    }
    
    

}
