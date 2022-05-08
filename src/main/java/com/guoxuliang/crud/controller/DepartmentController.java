package com.guoxuliang.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guoxuliang.crud.bean.Department;
import com.guoxuliang.crud.bean.Employee;
import com.guoxuliang.crud.bean.Msg;
import com.guoxuliang.crud.service.DepartmentService;
import com.guoxuliang.crud.service.EmployeeService;

/**
 * 处理和部门有关的请求
 * @author Administrator
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	

	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
		//查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
