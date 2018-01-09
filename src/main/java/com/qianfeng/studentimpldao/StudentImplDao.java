package com.qianfeng.studentimpldao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qianfeng.istudentdao.IStudentDao;
import com.qianfeng.pojo.po.Student;

public class StudentImplDao implements IStudentDao {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static{
		try {
			reader=Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession(){
		return sqlSessionFactory;
	}
	
	@Override
	public void listStudents(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		Student stu = (Student)session.selectOne("com/qianfeng/istudentdao/StudentMapper.GetStudentByID",id);
		System.out.println(stu);
	}

}
