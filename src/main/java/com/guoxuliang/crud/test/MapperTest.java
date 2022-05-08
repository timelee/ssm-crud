package com.guoxuliang.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guoxuliang.crud.bean.Department;
import com.guoxuliang.crud.bean.Employee;
import com.guoxuliang.crud.bean.EmployeeExample;
import com.guoxuliang.crud.dao.DepartmentMapper;
import com.guoxuliang.crud.dao.EmployeeMapper;



/**
 * ����dao��Ĺ���
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD(){
		System.out.println(departmentMapper);
		
		//1,���벿��
//		departmentMapper.insertSelective(new Department(null,"ˮ����"));
//		departmentMapper.insertSelective(new Department(null,"��չ��"));
//		
//		//2������Ա��
//		employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@qq.com", 1));
		
		//3,��������
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@guoxuliang.com",1));
		}
		System.out.println("�������");
		
	}

}
