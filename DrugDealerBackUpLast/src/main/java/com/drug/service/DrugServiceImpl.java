package com.drug.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dao.IDrugDao;
import com.drug.dto.DrugDto;
import com.drug.vo.PageMaker;

@Service
public class DrugServiceImpl implements IDrugService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(DrugDto dto) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		dao.insert(dto);
	}

	@Override
	public void update(DrugDto dto) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		dao.update(dto);
	}

	@Override
	public void delete(int pn) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		dao.delete(pn);
	}

	@Override
	public ArrayList<DrugDto> selectAll() throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		return dao.selectAll();
	}

	@Override
	public DrugDto selectName(int pn) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		return dao.selectName(pn);
	}

	@Override
	public List<DrugDto> listSearchCriteria(PageMaker pm) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		return dao.listSearch(pm);
	}

	@Override
	public int listSearchCount(PageMaker pm) throws Exception {
		IDrugDao dao=sqlSession.getMapper(IDrugDao.class);
		return dao.listSearchCount(pm);
	}
	@Override
	public void update_inventory(int inventory, int pn) throws Exception {		
		IDrugDao dao = sqlSession.getMapper(IDrugDao.class);
		dao.update_inventory(inventory,pn);
	}

	@Override
	public List<DrugDto> listSearch_VIP(PageMaker pm) throws Exception {
		// TODO Auto-generated method stub
		IDrugDao dao = sqlSession.getMapper(IDrugDao.class);
		return dao.listSearch_VIP(pm);
	}

	@Override
	public int listSearchCount_VIP(PageMaker pm) throws Exception {
		// TODO Auto-generated method stub
		IDrugDao dao = sqlSession.getMapper(IDrugDao.class);
		return dao.listSearchCount_VIP(pm);
	}

	
}