package com.lanqiao.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lanqiao.service.IHouseService;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class HouseServiceImplTest {
	
	@Resource
	IHouseService houseService;

	//@Test
	public void testCountForSelective() {
		
	}

	@Test
	public void testSelectSelective() {
		House house = new House();
		Page<House> page = new Page<House>(house);
		page.setPageSize(5);
		page.setPageNo(1);
		
		int totalRow = houseService.countForSelective(page);
		page.setTotalRow(totalRow);
		
		System.out.println(page);
		
		List<House> list = houseService.selectSelective(page);
		for (House h : list) {
			System.out.println(h);
		}
	}

}
