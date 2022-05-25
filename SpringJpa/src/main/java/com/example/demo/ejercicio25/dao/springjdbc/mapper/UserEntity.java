package com.example.demo.ejercicio25.dao.springjdbc.mapper;

import com.example.demo.ejercicio25.domain.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {

	private Long userId;
	private Long fkCustomerId;
	private String username;
	private String password;

	public static UserEntity map(User user) {
		return UserEntity.builder().userId(user.getId()).fkCustomerId(user.getCustomer().getId())
				.username(user.getUsername()).password(user.getPassword()).build();
	}

}
