package car.domain.inventory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import car.infrastructure.exception.CarException;

@Service
public class OutLibraryService {

	@Autowired
	private PartJpaRepo partJpaRepo;

	@Autowired
	private PartInstanceJpaRepo partInstanceJpaRepo;

	public void createDemand(String registerId, String vehicleNumber,
			Map<String, Integer> demandParts) {
		// ������Ҫ�������Ϣ
		DemandPartEntity entity = new DemandPartEntity();
		entity.save();
		// ���¿����Ϣ
		PartEntity partEntity = null;
		for (String demandPartId : demandParts.keySet()) {
			partEntity = partJpaRepo.findOne(demandPartId);
			partEntity.register(demandParts.get(demandPartId));
			partEntity.save();
		}

	}

	public void out(String registerId, String vehicleNumber,
			Map<String, Integer> outParts, Collection<String> codes)
			throws CarException {
		// ��������¼
		PartOutRecordEntity partOutRecordEntity = new PartOutRecordEntity(
				registerId, vehicleNumber, outParts, codes);
		partOutRecordEntity.save();
		// �������������
		this.out(registerId, vehicleNumber, outParts);
		// �������������
		this.out(registerId, vehicleNumber, codes);
	}

	/**
	 * �������������
	 * 
	 * @param registerId
	 * @param vehicleNumber
	 * @param outParts
	 * @throws CarException
	 */
	public void out(String registerId, String vehicleNumber,
			Map<String, Integer> outParts) throws CarException {

		// ���¿����Ϣ
		PartEntity partEntity = null;
		for (String demandPartId : outParts.keySet()) {
			partEntity = partJpaRepo.findOne(demandPartId);
			partEntity.out(outParts.get(demandPartId));
			partEntity.save();
		}
	}

	/**
	 * �������������
	 * 
	 * @param registerId
	 * @param vehicleNumber
	 * @param codes
	 * @throws CarException
	 */
	public void out(String registerId, String vehicleNumber,
			Collection<String> codes) throws CarException {
		// ������ʽת��
		Map<String, Collection<String>> parts = new HashMap<String, Collection<String>>();
		for (PartInstanceEntity partInstanceEntity : partInstanceJpaRepo
				.findByCodeIn(codes)) {
			if (!parts.containsKey(partInstanceEntity.getNumber())) {
				parts.put(partInstanceEntity.getNumber(),
						new ArrayList<String>());
			}
			parts.get(partInstanceEntity.getNumber()).add(
					partInstanceEntity.getCode());
		}
		// ���¿����Ϣ
		PartEntity partEntity = null;
		for (String part : parts.keySet()) {
			partEntity = partJpaRepo.findOne(part);
			partEntity.out(vehicleNumber, parts.get(part));
			partEntity.save();
		}
	}

}
