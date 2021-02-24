package jorge.munoz.reto_2.Web.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jorge.munoz.reto_2.Services.OrderProductsService;
import jorge.munoz.reto_2.Services.OrdersService;
import jorge.munoz.reto_2.Services.ProductsService;


@Controller
@RequestMapping("products")
public class ShopViewController {
    private final ProductsService productsService;
    private final OrderProductsService orderproductsService;
    private final OrdersService ordersService;

    ShopViewController(ProductsService productsService, OrderProductsService orderproductsService, OrdersService ordersService ){
        this.productsService = productsService;
        this.orderproductsService = orderproductsService;
        this.ordersService = ordersService;
    }

    @GetMapping("/home")
    public ModelAndView loadDetail(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("products", productsService.getAll());
        // mv.addObject("ordersProduct", orderproductsService.findByOrderId(3L));
        mv.addObject("totalAmountPrice", orderproductsService.getTotalPriceByOrder(3L));
        mv.addObject("ordersProduct", orderproductsService.getCartData(3L));
        return mv;
    }


    // Password1

}
