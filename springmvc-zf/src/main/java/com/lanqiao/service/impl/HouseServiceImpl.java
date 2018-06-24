package com.lanqiao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanqiao.mapper.HouseMapper;
import com.lanqiao.service.IHouseService;
import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;

@Service("houseService")
public class HouseServiceImpl implements IHouseService {
	
	@Resource
	HouseMapper houseMapper;

	@Override
	public int countForSelective(Page<House> page) {
		return houseMapper.countForSelective(page);
	}
	
	
	@Override
	public List<House> selectSelective(Page<House> page) {
		return houseMapper.selectSelective(page);
	}


	@Override
	public List<District> selectDistrict() {
		return houseMapper.selectDistrict();
	}


	@Override
	public List<Street> selectStreetById(Integer districtId) {
		return houseMapper.selectStreetById(districtId);
	}


}
