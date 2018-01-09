package com.qianfeng.studentimpldao;

import org.junit.Test;

public class StudentImplDaoTest {
	
	@Test
	public void Test1(){
		StudentImplDao dao = new StudentImplDao();
		dao.listStudents(1);
	}
}
