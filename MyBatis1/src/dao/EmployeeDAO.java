package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSessionFactory factory;
	private SqlSession session;
	private EmployeeDAO() {
		String resource = "db/mybatis_config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public int selectEmployeeAllCount() {
		int count = 0;
		count = session.selectOne("db.sqlmapper.selectAllCountEmployee");
		return count;
	}
	
	public List<EmployeeDTO> selectAllEmployee() {
		List<EmployeeDTO> list = session.selectList("db.sqlmapper.selectAllEmployee");
		return list;
	}
	
	public List<EmployeeDTO> selectPositionEmployee(int pos){
		List<EmployeeDTO> list = session.selectList("db.sqlmapper.selectPositionEmployee",pos);
		return list;
	}
	public List<EmployeeDTO> selectPositionAreaEmployee(int start,int end){
		HashMap<String , Object> map = new HashMap<String, Object>();
		map.put("n1",start);
		map.put("n2",end);
		List<EmployeeDTO> list = session.selectList("db.sqlmapper.selectPositionEmployee", map);
		return list;
	}
	
	public int insertEmployee(EmployeeDTO dto) throws Exception{
		if(dto.getEno().length()==0) {
			throw new Exception("사원번호를 입력하세요");
		}
		return session.insert("db.sqlmapper.insertEmployee",dto);
	}
	public int updateEmployee(EmployeeDTO dto){
		return session.update("db.sqlmapper.updateEmployee",dto);
	}
	
	
}
