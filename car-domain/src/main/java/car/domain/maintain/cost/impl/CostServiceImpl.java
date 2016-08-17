package car.domain.maintain.cost.impl;

import org.springframework.stereotype.Service;

import car.domain.maintain.cost.Cost;
import car.domain.maintain.cost.CostService;
import car.domain.maintain.register.RegisterEntity;
import car.domain.maintain.register.RegisterItemEntity;

@Service("costService")
public class CostServiceImpl implements CostService {

	public Cost calculate(RegisterEntity entity) {

		Float manualPrice = 0F;
		Float partPrice = 0F;
		for (RegisterItemEntity item : entity.obtainItems()) {
			// 计算配件费用
			if (item.needPart()) {
				partPrice += item.obtainPartSpec().getSalePrice()
						* item.getPartCount();
			}
			// 计算手工费
			manualPrice += item.obtainType().getManualPrice();
		}
		return new Cost(manualPrice, partPrice);
	}

}
