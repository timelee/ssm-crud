package com.guoxuliang.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guoxuliang.crud.bean.Employee;
import com.guoxuliang.crud.bean.EmployeeExample;
import com.guoxuliang.crud.bean.EmployeeExample.Criteria;
import com.guoxuliang.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll() {
//		EmployeeExample example = new EmployeeExample();
//		example.setOrderByClause("emp_id");
//		return employeeMapper.selectByExampleWithDept(example);
		return employeeMapper.selectByExampleWithDept(null);
	}

	/**
	 * 员工保存
	 */
	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertSelective(employee);
	}

	/**
	 * 检验用户名是否可用
	 * @param empName
	 * @return
	 */
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	
	/**
	 * 按照id查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	
	/**
	 * 员工更新
	 */
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	
	/**
	 * 员工删除
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}
	
	

}
