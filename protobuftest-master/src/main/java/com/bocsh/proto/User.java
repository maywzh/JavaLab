package com.bocsh.proto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7035541557662527235L;

	private String id;

    private String name;

    private Integer age;

    private String desc;
    
    private List<Role> roleList;



	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
    public String toString() {
        return "name=" + name + ",id=" + id + ",age=" + age + 
        		",role1=" + roleList.get(0).getId() + 
        		",role2=" + roleList.get(1).getId();
    }

}
