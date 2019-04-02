package com.microservice.valpro.oauth.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.microservice.valpro.common.util.IOUtils;
import com.microservice.valpro.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 登录控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@Controller
public class SysLoginController {

	@Autowired
	private Producer producer;
	@Autowired
	private UserService sysUserService;

	@ResponseBody
	@RequestMapping("/")
	public String getMessage(){
		return "OauthServer";
	}

	@ResponseBody
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println(principal);
		return principal;
	}

	@ResponseBody
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);	
		IOUtils.closeQuietly(out);
	}
	@RequestMapping("/home")
	public String getHome(){
		return "index";
	}
}
