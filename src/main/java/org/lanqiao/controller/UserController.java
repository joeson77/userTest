package org.lanqiao.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.lanqiao.entity.User;
import org.lanqiao.entity.Users;
import org.lanqiao.service.UserService;
import org.lanqiao.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@Controller
public class UserController {
	
	protected static Logger log = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("loginInit.do")
	public String loginInit(){
		return "login";
	}
	
	@RequestMapping("login")
	public String login(HttpSession session,HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", username);
		System.out.println("username=" + username + "; password=" + password);
		return "redirect:index";
	}
	
	@RequestMapping("reg")
	public String register(User user,HttpSession session,HttpServletRequest request){
		int flag = userService.insertUser(user);
		String IP = StringUtil.getIP(request);
		System.out.println("IP地址为：" + IP);
		if (flag > 0) {
			session.setAttribute("username", user.getUsername());
			return "redirect:index";
		} else {
			return "register";
		}
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getAllUser(HttpSession session,HttpServletRequest request,Model model){
		log.info("进入到跳转主页方法中。。。");
		String sessionID = request.getSession().getId();
		log.info("sessionID=" + sessionID);
		List<User> userlist = userService.getAllUser();
		List<Users> userlists = userService.getAllUsers();
		model.addAttribute("userlist", userlist);
		model.addAttribute("userlists", userlists);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "oneUpdate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Map<String, Object> oneUpdate(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = new User();
		String userName = request.getParameter("userName");
		String userPwd = String.valueOf((int)(Math.random() * 100000));
		log.info("userName 的值为:" + userName);
		log.info("userPwd 的值为:" + userPwd);
		log.info("userName 为:" + userName + " 的用户sessionID = " + session.getId());
		user.setUsername(userName);
		user.setPassword(userPwd);
		int returnFlag = userService.updateUserPwd(user);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (returnFlag != 0) {
			jsonMap.put("errorMsg", "true");
			jsonMap.put("errorCode", "0000");
			jsonMap.put("sessionID", session.getId());
			return jsonMap;
		} else {
			jsonMap.put("errorMsg", "false");
			jsonMap.put("errorCode", "1111");
			jsonMap.put("sessionID", session.getId());
			return jsonMap;
		}
	}
	
	
	@ResponseBody
	@RequestMapping("twoUpdate")
	public String twoUpdate(HttpServletRequest request){
		Users users = new Users();
		String usersName = request.getParameter("userName");
		String usersTel = String.valueOf((int)(Math.random() * 100000));
		log.info("usersName 的值为:" + usersName);
		log.info("usersPwd 的值为:" + usersTel);
		users.setUserName(usersName);;
		users.setUserTel(usersTel);
		int returnFlag = userService.updateUsersPwd(users);
		if (returnFlag != 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@ResponseBody
	@RequestMapping("uniteUpdate")
	public String uniteUpdate(HttpServletRequest request){
		String usersName = request.getParameter("userName");
		String usersTel = String.valueOf((int)(Math.random() * 100000));
		String userPwd = String.valueOf((int)(Math.random() * 100000));
		Users users = new Users();
		User user = new User();
		log.info("userName 的值为:" + usersName);
		log.info("userPwd 的值为:" + userPwd);
		user.setUsername(usersName);
		user.setPassword(userPwd);
		log.info("usersName 的值为:" + usersName);
		log.info("usersPwd 的值为:" + usersTel);
		users.setUserName(usersName);;
		users.setUserTel(usersTel);
		String flag = "";
		try {
			flag = userService.uniteUpdate(user, users);
		} catch (Exception e) {
			e.printStackTrace();
			flag = "fail...";
		}
		log.info("返回的flag值为:" + flag);
		return flag;
	}
}
