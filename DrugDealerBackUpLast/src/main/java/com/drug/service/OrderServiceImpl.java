package com.drug.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dao.IDrugDao;
import com.drug.dao.IOrderDao;
import com.drug.dto.OrderDto;
import com.drug.dto.OrderPageDto;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(OrderDto dto) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		dao.insert(dto);
	}

	@Override
	public void update(Integer odnum,Character dt) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);		
		dao.update(odnum,dt);
	}

	@Override
	public void delete(int odnum) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		dao.delete(odnum);
	}

	@Override
	public ArrayList<OrderDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		System.out.println(dao.selectAll());
		return dao.selectAll();
	}
	@Override
	public ArrayList<OrderDto> selectId(String id) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		System.out.println(dao.selectId(id));
		return dao.selectId(id);
	}
//	@Override
//	public ArrayList<OrderDto> select(ArrayList<OrderDto> orders) throws Exception {
//		// TODO Auto-generated method stub
//		IDrugDao dao = sqlSession.getMapper(IDrugDao.class);
//		System.out.println(orders);
//		ArrayList<OrderDto> dt = new ArrayList<OrderDto>();
//		for(OrderDto ord : orders) {
//			OrderDto dto = dao.selectName(ord.getPn());
//			System.out.println(dao.selectOne(ord.getPn()));
//			dto.setId(ord.getId());
//			dto.setPrice(ord.getPrice());
//			dto.setInventory(ord.getInventory());
//			dto.setQuantity(ord.getQuantity());
//			dto.setPn(ord.getPn());
//			System.out.println(dto);
//			dt.add(dto);
//		}		
//		System.out.println(dt);
//		return dt;
//	}

	@Override
	public OrderDto selectOne(int pn) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		System.out.println(dao.selectOne(pn));
		return dao.selectOne(pn);
	}

	@Override
	public OrderDto select_dt(Integer odnum) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		System.out.println(dao.select_dt(odnum));
		return dao.select_dt(odnum);
	}

	@Override
	public void update_pay(Integer odnum) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);		
		dao.update_pay(odnum);
	}

	@Override
	public ArrayList<OrderDto> select_pay(String id) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao dao = sqlSession.getMapper(IOrderDao.class);
		System.out.println(dao.select_pay(id));
		return dao.select_pay(id);
	}
}
