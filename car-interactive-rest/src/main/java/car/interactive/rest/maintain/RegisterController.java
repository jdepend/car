package car.interactive.rest.maintain;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import car.app.maintain.RegisterAppService;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

	@Autowired
	private RegisterAppService registerAppService;

	@RequestMapping(value = "{vehicleNumber}/register/state/obtain.ajax", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> obtainVehicle(@PathVariable String vehicleNumber,
			Model model) {

		String state = registerAppService.obtainByVehicleNumber(vehicleNumber)
				.getState();

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", "0");
		map.put("msg", "获取成功！");
		map.put("data", state);
		return map;

	}

}