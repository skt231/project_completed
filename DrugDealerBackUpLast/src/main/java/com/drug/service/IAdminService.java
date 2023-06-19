package com.drug.service;

import java.util.ArrayList;

import com.drug.dto.AdminDto;

public interface IAdminService {
   public void insert(AdminDto dto) throws Exception;
   public void update(AdminDto dto) throws Exception;
   public ArrayList<AdminDto> selectAll() throws Exception;
   public AdminDto selectId(String id) throws Exception;
   public void delete(String id) throws Exception;
}