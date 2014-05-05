package car.domain.maintain.credits;

import org.springframework.stereotype.Service;

import car.domain.maintain.register.RegisterEntity;

@Service
public class CreditsService {

	public int calCredits(RegisterEntity entity) {
		return new Float(entity.obtainPrice() / 100).intValue();
	}

}
