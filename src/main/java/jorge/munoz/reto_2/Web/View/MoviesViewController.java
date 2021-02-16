package jorge.munoz.reto_2.Web.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jorge.munoz.reto_2.Services.ProductsService;


@Controller
@RequestMapping("products")
public class MoviesViewController {
    private final ProductsService productsService;

    MoviesViewController(ProductsService moviesService){
        this.productsService = moviesService;
    }

    @GetMapping()
    public ModelAndView Products() {
        ModelAndView mv = new ModelAndView("searchTH");
        mv.addObject("movie", productsService.getAll());
        return mv;
    }



}
