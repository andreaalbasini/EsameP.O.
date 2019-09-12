package controller;

import model.Vegetablesproducts;
import Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
	private VegetablesService service;



public Controller(VegetablesService service) {
    this.service = service;
}

	@GetMapping("/data")
    public List getAllData() {
        return service.getData();
    }
}
