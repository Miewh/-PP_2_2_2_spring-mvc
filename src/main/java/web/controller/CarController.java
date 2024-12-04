package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

@Controller
@RequestMapping("/cars")
public class CarController {

	private final CarDao carDao;

	@Autowired
	CarController(CarDao carDao) {
		this.carDao = carDao;
	}

	@GetMapping()
	public String printCars(@RequestParam(value = "count", defaultValue = "5")int count, Model model) {
		model.addAttribute("cars", carDao.getCarsByNumber(count));
		return "cars";
	}
	
}