package com.xxz.controller;

import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import com.xxz.service.SpringBootService;
import com.xxz.util.DateUtils;
import com.xxz.util.SidWorker;
import com.xxz.util.Utils;
import com.xxz.util.ZYJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class SpringBootController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private SpringBootService springBootService;

	@RequestMapping(value={"/selectAll"})
	public List<userInformation> selectAll(){
		System.out.println("成功进入！端口号："+port);
		return springBootService.queryAll();
	}

	@PostMapping(value={"/logins"})
	public ModelAndView userLogin(){
		ModelAndView  mav=new ModelAndView();
		System.out.println("拦截器测试");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value={"/selectById"})
	public UserInfo selectById(HttpServletRequest request){
		System.out.println("根据ID查询测试sss！端口号："+port+"请求userId:"+request.getParameter("id"));
		Long userId =Long.parseLong(request.getParameter("id"));
		UserInfo user = this.springBootService.selectByPrimaryKey(userId);
		return user;
	}
	@RequestMapping(value = {"/saveUserInfo"},method = RequestMethod.POST)
	public ZYJSONResult saveUserInfo(@RequestParam(name = "userage",required = false) Integer userage,@RequestParam(name = "username") String username) throws ParseException {
		UserInfo ui = new UserInfo();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("生成的ID： " + SidWorker.nextSid());
		System.out.println("当前时间：" + DateUtils.getCurrentDateTime());
		ui.setUserId(SidWorker.nextSid());
		ui.setUserAge(userage);
		ui.setUserName(username);
		ui.setStartDate(df.parse(DateUtils.getCurrentDateTime()));
		try {
            springBootService.save(ui);
		}catch (Exception e){
			//e.printStackTrace();
			return ZYJSONResult.errorException("程序异常！");
		}
		return ZYJSONResult.ok(ui);
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
                UserInfo ui = new UserInfo();
                ui.setUserId(new Date().getTime());
                ui.setUserName(filePath + newName);
                ui.setUserAge(10);
                springBootService.save(ui);
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
