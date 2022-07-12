package com.chary.shopping.controller;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.service.IUserInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.SendMailUtil;
import com.chary.shopping.util.SessionConstantKey;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private IUserInfoService  userInfoService;
	
	@Autowired 
	private SendMailUtil sendEmailUtil;

	@GetMapping("/check")
	public ResultVO check(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCES, userInfo);
		
	}
	
	@PostMapping("/login")
	public ResultVO login(String email, String pwd, HttpSession session) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPwd(pwd);
		
		//检查用户是否注册过账号
		UserInfo result = userInfoService.findEmail(email);
		if(StringUtil.checkNull(result) ) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		
		
		result = userInfoService.login(userInfo);
		
		if(!StringUtil.checkNull(result) ) {
			session.setAttribute("userInfo", result);
			return new ResultVO(ResultEnum.SUCCES,result);
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/reg")
	public ResultVO reg(String email, String pwd, String code, HttpSession session) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPwd(pwd);
		
		//判断验证码是否过期
		if(!code.equals(SessionConstantKey.VCODE)) {
			return new ResultVO(ResultEnum.CODE_ERROR);
		}
		
		//判断邮箱是否注册过
		UserInfo findEmail = userInfoService.findEmail(email);
		if(!StringUtil.checkNull(findEmail) ) {
			return new ResultVO(ResultEnum.DATA_EXIT);
		}
				
		int result = userInfoService.reg(userInfo);
		
		if(result > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@PostMapping("/findUserInfo")
	public ResultVO findUserInfo() {
		
		List<UserInfo> userInfo = userInfoService.findUserInfo();
		return new ResultVO(ResultEnum.SUCCES,userInfo);
		
	}
	
	
	/**
	 * 管理员添加用户信息
	 * @param email
	 * @param pwd
	 * @return
	 */
	@PostMapping("/regByManager")
	public ResultVO regByManager(String email, String pwd) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPwd(pwd);
		
		//判断邮箱是否注册过
		UserInfo findEmail = userInfoService.findEmail(email);
		if(!StringUtil.checkNull(findEmail) ) {
			return new ResultVO(ResultEnum.DATA_EXIT);
		}
				
		int result = userInfoService.reg(userInfo);
		
		if(result > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.ERROR);
		
	}
	
	
	/**
	 * 管理员删除用户
	 * @param uno
	 * @return
	 */
	@PostMapping("/delUserByUno")
	public ResultVO delUserByUno(int uno) {
		
		int result = userInfoService.delUserByUno(uno);
		if(result > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	/**
	 *  修改用户权限
	 * @param uno
	 * @param status
	 * @return
	 */
	@PostMapping("/upUserStatusByUno")
	public ResultVO upUserStatusByUno(int uno, int status) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUno(uno);
		userInfo.setStatus(status);
		
		int result = userInfoService.upUserStatusByUno(userInfo);
		if(result > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	/**
	 * 修改用户信息
	 * @param uno
	 * @param email
	 * @return
	 */
	@PostMapping("/upUserEmailByUno")
	public ResultVO upUserEmailByUno(int uno, String email) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUno(uno);
		userInfo.setEmail(email);
		
		int result = userInfoService.upUserEmailByUno(userInfo);
		if(result > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}

	
	/**
	  *  前端504 验证码移至前端
	 * @param email
	 * @param session
	 * @return
	 */
	@PostMapping("/sendEmail")
	public ResultVO sendEmail( String email,String code, HttpSession session) {
		
		if(StringUtil.checkNull(email)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		
		//判断邮箱是否注册过
		UserInfo findEmail = userInfoService.findEmail(email);
		if(!StringUtil.checkNull(findEmail) ) {
			return new ResultVO(ResultEnum.DATA_EXIT);
		}
		
		if(sendEmailUtil.sendQQEmail(email, code, email)) {
			
			SessionConstantKey.VCODE = code;
			
			session.setAttribute(SessionConstantKey.VCODE, code);
			
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					
					SessionConstantKey.VCODE = "";
					
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task, 180000); 	
			
			return new ResultVO(ResultEnum.SUCCES,code);
			
		}
		
		return new ResultVO(ResultEnum.ERROR);
		
	}
	
}
