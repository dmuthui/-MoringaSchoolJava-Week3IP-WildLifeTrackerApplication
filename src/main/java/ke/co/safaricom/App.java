package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        //INITIALIZATION OF THE HANDLEBARS
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        //THE ROUTE TO VIEW HOME PAGE
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "home.hbs");
        }, engine);
    }
}