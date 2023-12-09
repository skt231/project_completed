package com.booking.service;

import java.util.List;

import com.booking.dto.userDto;

public interface userService {
	public void addUser(userDto user) throws Exception;

	public userDto getUserById(int id) throws Exception;

	public void updateUser(userDto user) throws Exception;

	public void deleteUser(int id) throws Exception;

	public List<userDto> getAllUsers() throws Exception;

	public userDto loginUser(String username, String password) throws Exception;

	public userDto getUserByUsername(String username) throws Exception;

	public void getAuthority(String username,String authority) throws Exception;
}
