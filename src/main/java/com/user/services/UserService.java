package com.user.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.user.POJO.User;

@Service
public class UserService {

	@Autowired
	JdbcTemplate jdbc;

	public int insertUser(User u) {
		int id = u.getId();
		String name = u.getName();
		String address = u.getAddress();
		if (name.equals(null)) {
			return 0;
		} else {
			String add = "insert into Users values(?,?,?)";
			int addUser = jdbc.update(add, id, name, address);
			return addUser;
		}

	}

	public int updateUser(User u) {
		int id = u.getId();
		String name = u.getName();
		String address = u.getAddress();

		int resUpdate = 0;
		if (id == 0 && (address == (null))) {
			return 0;
		} else {
			if (name == (null)) {
				String update = "update Users set address=? where id=?";
				resUpdate = jdbc.update(update, address, id);
				System.out.println("empty name");
			} else {
				String update = "update Users set address=? where id=? and name=?";
				resUpdate = jdbc.update(update, address, id, name);

			}

		}

		return resUpdate;
	}

	public int deleteUser(User u) {
		int id=u.getId();
		String name=u.getName();
		int res=0;
		if(name!=null&&id!=0) {
			String delete="delete from Users where id=? and name=?";
			res=jdbc.update(delete,id,name);
		}
		return res;
	}
	public List<Map<String, Object>> getUser(User u) {
	int id=u.getId();
	String name=u.getName();
	String address=u.getAddress();
	StringBuilder getUser=new StringBuilder("select * from Users where 1=1 ");
	if(id!=0&&name!=null&&!name.isEmpty()&&address!=null&&!address.isEmpty()) {
		getUser.append("and id="+id+" and name='"+name+"' and address='"+address+"'");
		System.out.println(getUser);
	}
	else {
		
		if(id!=0) {
		getUser.append("and id="+id);
	    }if(name!=null) {
	    	getUser.append(" and name='"+name+"' ");
	    }if(address!=null) {
	    	getUser.append("and address='"+address+"'");
	    }
	}
		List<Map<String, Object>> getUserList = jdbc.queryForList(getUser.toString());
		System.out.println(getUser);
   System.out.println(getUserList.size());
   for(int i=0;i<getUserList.size();i++) {
         		Map<String, Object> map = getUserList.get(i);
         		Collection<Object> values = map.values();
         		         System.out.println(values);
         		System.out.println(map);
   }
		return getUserList;
	}

}
