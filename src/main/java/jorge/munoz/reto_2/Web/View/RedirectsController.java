package jorge.munoz.reto_2.Web.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectsController {
    @GetMapping("")
    public String getIndex(String lang){
        return "redirect:/products/home";
    }
}
