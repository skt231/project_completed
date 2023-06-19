package com.drug.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dto.AuthoritiesDto;
import com.drug.dto.UsersDto;
import com.drug.dao.IUsersDao;

@Service
public class UsersServiceImpl implements IUsersService {

   @Autowired
   private SqlSession sqlSession;

   @Override
   public void insert(UsersDto dto) throws Exception {
      IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
      dao.insert(dto);
   }

   @Override
   public void update(UsersDto dto) throws Exception {
      IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
      dao.update(dto);
   }

   @Override
   public void delete(String id) throws Exception {
      IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
      dao.delete(id);
   }

   @Override
   public ArrayList<UsersDto> selectAll() throws Exception {     
      
      IUsersDao dao = sqlSession.getMapper(IUsersDao.class);

      return dao.selectAll();
   }

   @Override
   public UsersDto selectId(String id) throws Exception {
      IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
      return dao.selectId(id);
   }

   @Override
   public void insertAuthority(UsersDto dto) throws Exception {
	  IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
	  System.out.println(dto);
	  dao.insertAuthority(dto);
   }

   @Override
   public void update_tier(UsersDto dto) throws Exception {
	// TODO Auto-generated method stub
	   IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
	   String authority = dao.select_au(dto.getId()).getAuthority();
	   if(authority.equals("member")) {
		   authority="V.I.P";
	   }else if(authority.equals("admin")){
		   authority="admin";
	   }else {
		   authority="member";
	   }
	   dao.update_tier(authority,dto.getId());
   }

	@Override
	public AuthoritiesDto select_au(String id) throws Exception {
		// TODO Auto-generated method stub
		IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
		System.out.println(dao.select_au(id)); 
		return dao.select_au(id);
	}

	@Override
	public ArrayList<AuthoritiesDto> select_authorities() throws Exception {
		// TODO Auto-generated method stub
		IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
		System.out.println(dao.select_authorities());
		return dao.select_authorities();
	}

	@Override
	public void delete_au(String id) throws Exception {
		// TODO Auto-generated method stub
		 IUsersDao dao = sqlSession.getMapper(IUsersDao.class);
	      dao.delete_au(id);
	}

}