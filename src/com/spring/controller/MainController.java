package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.DAOImp;
import com.spring.model.User;

@Controller
public class MainController {

	@Autowired
	DAOImp dao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHome(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView saveForm(User user){
		ModelAndView mv = new ModelAndView();
		dao.save(user);
		mv.setViewName("redirect:/viewAllUser");
		return mv;
	}
	
	@RequestMapping(value="viewAllUser",method=RequestMethod.GET)
	public ModelAndView viewAll(){
		ModelAndView mv = new ModelAndView();
		List<User> list = dao.viewAllUser();
		mv.addObject("user",list);
		mv.setViewName("viewAll");
		return mv;
	}
	
	@RequestMapping(value="updateForm",method=RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam("id")int id){
		ModelAndView mv = new ModelAndView();
		User user  = dao.getUserById(id);
		mv.addObject("user", user);
		mv.setViewName("updateForm");
		return mv;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView update(User user){
		ModelAndView mv = new ModelAndView();
		dao.update(user);
		mv.setViewName("redirect:/viewAllUser");
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id")int id){
		ModelAndView mv = new ModelAndView();
		dao.delete(id);
		mv.setViewName("redirect:/viewAllUser");
		return mv;
	}
	
	@RequestMapping(value="newUser",method=RequestMethod.GET)
	public ModelAndView addnew(){
		return new ModelAndView("redirect:/");
	}
	
}
