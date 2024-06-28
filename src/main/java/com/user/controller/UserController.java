package com.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.user.POJO.User;

@RestController
public class UserController {
    @Autowired 
	com.user.services.UserService userService;
   
    @PostMapping("/")
    public HashMap<String,String> addUser(@RequestBody User u) {
     int resInUser=userService.insertUser(u);
     HashMap<String,String> hm=new HashMap<String, String>();
     if(resInUser==0) {
    	 hm.put("f", "failed to insert.");
     }else {
    	 hm.put("s","success");
    	 System.out.print("inserted...");
     }
    	return  hm;
    }
    @PutMapping("/")
    public HashMap<String,String> upUser(@RequestBody User u) {
     int resInUser=userService.updateUser(u);
     HashMap<String,String> hm=new HashMap<String, String>();
     if(resInUser==0) {
    	 hm.put("f", "failed to update...");
     }else {
    	 hm.put("s","success");
    	 System.out.print("updated...");
     }
    	return  hm;
    }
    
    @DeleteMapping("/")
    public HashMap<String,String> delUser(@RequestBody User u) {
        int resInUser=userService.deleteUser(u);
        HashMap<String,String> hm=new HashMap<String, String>();
        if(resInUser==0) {
       	 hm.put("f", "failed to delete...");
        }else {
       	 hm.put("s","success");
       	 System.out.print("user deleted...");
        }
       	return  hm;
       }
    @GetMapping("/")
    public List<Map<String, Object>> getUser(@RequestBody User u){
    	
    	
    	return userService.getUser(u);
    }

}
