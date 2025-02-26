package com.bbva.wikj.lib.r888.impl;

import com.bbva.wikj.dto.user.DtoIn;
import com.bbva.wikj.dto.user.DtoOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class WIKJR888Impl extends WIKJR888Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJR888Impl.class);


	@Override
	public DtoOut execute(DtoIn dtoIn) {
		DtoOut dtoOut = new DtoOut();
		Map<String, Object> args = new HashMap<>();
		args.put("id",dtoIn.getId());
		args.put("nuip",dtoIn.getNuip());
		args.put("full_name",dtoIn.getFull_name());
		args.put("phone",dtoIn.getPhone());
		args.put("address",dtoIn.getAddress());

		int result = this.wikjR889.executeInsert(args);
		if(result == 1){
			Map<String ,Object> response =  this.wikjR889.executeSelect(dtoIn.getId());

			dtoOut.setId(response.get("id").toString());
			dtoOut.setNuip(response.get("nuip").toString());
			dtoOut.setFull_name(response.get("full_name").toString());
			dtoOut.setPhone(response.get("phone").toString());
			dtoOut.setAddress(response.get("address").toString());
		}
		return dtoOut;
	}
}
