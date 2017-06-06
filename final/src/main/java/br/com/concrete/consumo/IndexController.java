package br.com.concrete.consumo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by assis on 13/03/17.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String homePage(){
        return "index";
    }
}
