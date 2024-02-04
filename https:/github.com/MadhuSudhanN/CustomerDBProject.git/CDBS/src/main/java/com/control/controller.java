package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAO.*;
import com.entity.CustomerEntity;
import com.validate.StringFormat;
import com.validate.Validate;

@Controller
public class controller {
	@RequestMapping("/App")
	public String ms(@RequestParam("user") String u)
	{
		System.out.println(u);
		return "Login.jsp";
	}
	//request to validate user details
	@RequestMapping("/usercheck")
	public String userCheck(@RequestParam ("user") String user ,@RequestParam("password") String password)
	{
		if(Validate.validateUser(user,password)==true) 
		{
			return "Index.jsp";
		}
		else
		{
			return "InvalidUP.jsp";
		}

	}
	//request to register user details
	@RequestMapping("/register")
	public String register(@RequestParam ("user") String user ,@RequestParam("password") String password ,@RequestParam("confirm-password") String  cpassword)
	{
		try {
			if(password.equals(cpassword))
			{
				SaveUser.saveUser(user, cpassword);
				return "Login.jsp";
			}
			else
			{

				return "InvalidRegisterPass.jsp";
			}
		} 
		catch (Exception e) {
			return "InvalidRegister.jsp";
		}
	}
	@RequestMapping("/addCust")
	public String  addCust(@RequestParam("firstName") String fname,@RequestParam("lastName") String lname,@RequestParam("street") String street,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("email") String email,@RequestParam("phone") String phone)
	{
		try {
			CustomerEntity	c=new CustomerEntity(StringFormat.stringF(fname), StringFormat.stringF(lname), StringFormat.stringF(street), StringFormat.stringF(address),StringFormat.stringF( city), StringFormat.stringF(state), StringFormat.stringF(email), StringFormat.stringF(phone));
			new CustomerDAOImp().insert(c);
			return  "Featch.jsp";
		} catch (Exception e) {
			return  "Invalid.jsp";
		}

	}
	@RequestMapping("/delete")
	public String  deleteCust(@RequestParam("cid") int cid)  {
		try {
			new CustomerDAOImp().delete(cid);
			return "Featch.jsp";
		} catch (Exception e) {
			return "Invalid.jsp";
		}
	}
	@RequestMapping("/update")
	public String  update( @RequestParam ("cid") int cid ,@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("street") String street,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("email") String email,@RequestParam("phone") String phone)
	{
		try {
			new CustomerDAOImp().update(cid,fname, lname,street,address,city,state,email,phone);
			return "Featch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid.jsp";
		}
	}
}
