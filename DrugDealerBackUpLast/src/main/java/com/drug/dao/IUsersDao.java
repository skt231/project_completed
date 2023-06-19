package com.drug.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.AuthoritiesDto;
import com.drug.dto.UsersDto;

public interface IUsersDao {
   public void insert(UsersDto dto) throws Exception;
   public void insertAuthority(UsersDto dto) throws Exception;
   public void update(UsersDto dto) throws Exception;
   public void update_tier(@Param("authority")String authority,@Param("id")String id) throws Exception;
   public void delete(String id) throws Exception;
   public void delete_au(String id) throws Exception;
   public ArrayList<UsersDto> selectAll() throws Exception;
   public ArrayList<AuthoritiesDto> select_authorities() throws Exception;
   public UsersDto selectId(String id) throws Exception;
   public AuthoritiesDto select_au(String id) throws Exception;   
}
