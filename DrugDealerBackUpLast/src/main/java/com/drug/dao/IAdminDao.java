package com.drug.dao;

import java.util.ArrayList;

import com.drug.dto.AdminDto;

public interface IAdminDao {
   public void insert(AdminDto dto) throws Exception;
   public void update(AdminDto dto) throws Exception;
   public void delete(String id) throws Exception;
   public ArrayList<AdminDto> selectAll() throws Exception;
   public AdminDto selectId(String id) throws Exception;
}