package app.controller;

import app.Response;
import app.model.Dish;
import app.model.ImageLinks;
import app.model.ImageSearch;
import app.model.exception.InvalidCurrencyException;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import app.repository.DishRepository;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    private MultiValueMap<String, String> headers;
    private Gson gson;

    private DishController() {
        this.headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "text/json");

        this.gson = new Gson().newBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    }

    @GetMapping("/dishes")
    public ResponseEntity<String> getDishes(@RequestParam(value="lang", required=false) String language,
                                            @RequestParam(value="curr", required=false) String currency) throws InvalidCurrencyException {
        List<Dish> dishes = dishRepository.findAll();

        for(Dish dish : dishes)
            dish.localize(language, currency);

        return new ResponseEntity<>(gson.toJson(dishes), headers, HttpStatus.OK);
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<String> getDishesId(@PathVariable String id,
                                              @RequestParam(value="lang", required=false) String language,
                                              @RequestParam(value="curr", required=false) String currency) throws InvalidCurrencyException {
        ObjectId objectId = new ObjectId(id);
        Dish dish = dishRepository.findById(objectId).orElse(null);

        String json = "{}";
        if(dish != null) {
            dish.localize(language, currency);
            json = gson.toJson(dish);
        }

        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

    @PostMapping("/dishes")
    public ResponseEntity<Response> addDishes(@RequestBody Map<String, Object> input) throws Exception {
        Dish dish = Dish.createDish((String)input.get("type"), (ArrayList<String>)input.get("toppings"));
        ObjectId id = new ObjectId();
        ImageLinks imageLinks = ImageSearch.getImageLinksJson(StringUtils.getQueryString(dish));
        dish.setObjectId(id);
        dish.setImageLinks(imageLinks);

        dishRepository.save(dish);

        Response response = new Response("Successfully added " + dish.getClass().getSimpleName() + " to collection.", imageLinks);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
