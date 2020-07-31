package com.cos.securityex01.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



// ORM - Object Relation Mapping

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // 이거 토대로 테이블을 만듬
public class User {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 번호매기는 전략
	private int id;
	private String username;
	private String password;
	private String email;
	@CreationTimestamp
	private Timestamp createDate;
	
}
