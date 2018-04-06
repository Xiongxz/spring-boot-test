package com.xxz.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import com.xxz.util.Utils;
import com.xxz.util.ZYJSONResult;
import com.xxz.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.xxz.service.SpringBootService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SpringBootController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private SpringBootService sbs;

	@RequestMapping(value={"/selectAll"})
	public List<userInformation> springboottests(){
		System.out.println("成功进入！端口号："+port);
		return sbs.queryAll();
	}

	@RequestMapping(value={"/login"})
	public String index(){
		return "index";
	}

	@RequestMapping(value={"/selectById"})
	public UserInfo selectById(HttpServletRequest request){
		System.out.println("根据ID查询测试sss！端口号："+port+"请求userId:"+request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("id"));
		UserInfo user = this.sbs.selectByPrimaryKey(userId);
		return user;
	}

	/*@RequestMapping(value={"/uploadFile"},method = RequestMethod.POST)
	public ZYJSONResult uploadFile(HttpServletRequest request){
		f(file.isEmpty()){
			//return "文件为空";
			return ZYJSONResult.errorMsg("文件为空");
		}
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
		String filePath = request.getSession().getServletContext().getRealPath("img/");
		try {
            String uploadisok = Utils.uploadFile(request);
            //if (uploadisok) ? return ZYJSONResult.errorMsg("文件为空");
            if (!uploadisok.equals("")){
                userInformation ui = new userInformation();
                ui.setUserId((int) new Date().getTime());
                ui.setUserName(uploadisok);
                ui.setUserAge(10);
                sbs.save(ui);
                System.out.println("成功！");
                return ZYJSONResult.ok(uploadisok);
            }
		} catch (Exception e) {
			// TODO: handle exception

		}
        return ZYJSONResult.errorMsg("文件为空");
	}
     */
    @RequestMapping(value={"/uploadFile"},method = RequestMethod.POST)
	public ZYJSONResult uploadFile(@RequestParam(value = "file",required = false) MultipartFile file,HttpServletRequest request) throws IOException{
		if(request instanceof MultipartHttpServletRequest && !file.isEmpty() && file.getSize() > 0) {
		    String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String newName = Utils.getUUID() + fileName.substring(fileName.indexOf("."), fileName.length());
            String filePath = request.getSession().getServletContext().getRealPath("img/");
            System.out.println("文件类型：" + contentType);
            System.out.println("文件路径: " + filePath);
            System.out.println("文件原名称：" + fileName);
            System.out.println("文件新名称：" + newName);
            System.out.println("文件大小：" + file.getSize());
            try {
                Utils.uploadFile(file.getBytes(), filePath, newName);
                userInformation ui = new userInformation();
                ui.setUserId((int) new Date().getTime());
                ui.setUserName(filePath + newName);
                ui.setUserAge(10);
                sbs.save(ui);
                System.out.println("成功！");
                return ZYJSONResult.mok("imgurl", filePath.toString() + newName);
            } catch (Exception e) {
                return ZYJSONResult.errorMsg("异常");
            }
	}else{
            return  ZYJSONResult.errorMsg("文件为空");
    }
    }
}
