package com.example.demo;

import javax.naming.Name;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import java.io.Serializable;

//@Entry(objectClasses = { "person", "top" }, base="dc=spring,dc=ldap,dc=model" )
@Entry(objectClasses = { "person", "top" })
public class User
{
	@Id
	@JsonIgnore
	private Name dn;

	private String name;

	@Attribute(name = "cn")
	@DnAttribute(value = "cn", index = 0)
	private String userName;

	@Attribute(name = "sn")
	private String fullName;


	@Attribute(name = "userPassword")
	private String password;

	public String getDn() { return name; }
	public void setDn(Name dn) { this.name = dn.toString(); }

	public String getUsername() { return userName; }
	public void setUsername(String userName) { this.userName = userName; }

	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
