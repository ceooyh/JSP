package dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import config.SQLMapper;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSession session;
	private SQLMapper mapper;
	
	public EmployeeDAO() {
		session = DBManager.getInstance().getSqlSession();
		mapper = session.getMapper(SQLMapper.class);
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

		public List<EmployeeDTO> selectAllEmployee(){
			return mapper.selectEmployeeAll();
		}

		public int selectAllCountEmployee() {
			return mapper.selectAllCountEmployee();
		}
	
		public ArrayList<EmployeeDTO> selectPositionEmployee(int position) {
			return mapper.selectPositionEmployee(position);
		}
	
		public List<EmployeeDTO> selectPositionAreaEmployee(int num1,int num2){
			return mapper.selectPositionAreaEmployee(num1, num2);
		}
		
		public void insertEmployee(EmployeeDTO dto) {
			mapper.insertEmployee(dto);
		}
		
		
		public int updateEmployee(HashMap<String, Object> map) {
			return mapper.updateEmployee(map);
		}
		
		
		public ArrayList<EmployeeDTO> selectNameEmployee(String name) {
			return mapper.selectNameEmployee(name);
		}
}
