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
    // private final ProductsService productsService;
    // private final OrderProductsService orderproductsService;
    // private final OrdersService ordersService;

    // ShopViewController(ProductsService productsService){
    //     this.productsService = productsService;
    // }

    // @GetMapping("/home")
    // public ModelAndView loadDetail(){
    //     ModelAndView mv = new ModelAndView("home");
    //     mv.addObject("products", ProductsController.productsList);
    //     mv.addObject("ordersProduct", OrdersProductsController.findOrderProductbyIdOrder(3));
    //     mv.addObject("totalAmountPrice", OrdersProductsController.calculateTotalPrice(3));
    //     return mv;
    // }



}
