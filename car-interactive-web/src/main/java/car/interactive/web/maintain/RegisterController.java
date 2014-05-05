package car.interactive.web.maintain;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import car.app.maintain.RegisterAppService;
import car.app.maintain.RegisterAppVO;
import car.domain.vehicle.VehicleFacade;
import car.domain.vehicle.VehicleVO;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

	@Autowired
	private RegisterAppService registerAppService;

	@Autowired
	private VehicleFacade vehicleFacade;

	@RequestMapping(value = "new.ajax", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> regist(
			@ModelAttribute("register") RegisterAppVO register, Model model) {

		registerAppService.create(register);

		return null;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String regist(Model model) {
		return "register/new";
	}

	@RequestMapping(value = "{registerId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable String registerId, Model model) {
		model.addAttribute("register", registerAppService.obtain(registerId));
		return "register/edit";
	}

	@RequestMapping(value = "{vehicleId}/vehicle.ajax", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> obtainVehicle(@PathVariable String vehicleId,
			Model model) {

		VehicleVO vehicle = vehicleFacade.obtainVehicle(vehicleId);

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", "0");
		map.put("msg", "获取成功！");
		map.put("data", vehicle);
		return map;

	}

}