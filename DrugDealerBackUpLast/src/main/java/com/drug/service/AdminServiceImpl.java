package com.drug.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dto.AdminDto;
import com.drug.dao.IAdminDao;

@Service
public class AdminServiceImpl implements IAdminService {

   @Autowired
   private SqlSession sqlSession;

   @Override
   public void insert(AdminDto dto) throws Exception {
      IAdminDao dao = sqlSession.getMapper(IAdminDao.class);
      dao.insert(dto);

   }

   @Override
   public void update(AdminDto dto) throws Exception {
      IAdminDao dao = sqlSession.getMapper(IAdminDao.class);
      dao.update(dto);

   }

   @Override
   public void delete(String id) throws Exception {
      IAdminDao dao = sqlSession.getMapper(IAdminDao.class);
      dao.delete(id);

   }

   @Override
   public ArrayList<AdminDto> selectAll() throws Exception {
      IAdminDao dao = sqlSession.getMapper(IAdminDao.class);

      return dao.selectAll();
   }

   @Override
   public AdminDto selectId(String id) throws Exception {
      IAdminDao dao = sqlSession.getMapper(IAdminDao.class);
      return dao.selectId(id);
   }

}