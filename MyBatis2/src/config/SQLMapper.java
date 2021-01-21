package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.EmployeeDTO;

public interface SQLMapper {
	@Select("select * from employee")
	public List<EmployeeDTO> selectEmployeeAll();
	
	
	@Select("select count(*) from employee")
	public int selectAllCountEmployee();
	
	
	@Select("select * from employee where position < #{fuck}")
	public ArrayList<EmployeeDTO> selectPositionEmployee(int no);
	
	
	@Select("select * from employee where position between #{no1} and #{no2}")
	public List<EmployeeDTO> selectPositionAreaEmployee(@Param("no1")int num1,@Param("no2")int num2);
	
	
	@Insert("insert into employee(eno,name,department,position) values(#{eno},#{name},#{department},#{position})")//map이나 dto가 들어오면 매개변수랑 자동으로 매칭시킨다.
	public void insertEmployee(EmployeeDTO dto);
	
	
	@Update("update employee set name = #{name} , department =#{department} , position =#{position} where eno = #{eno}")
	public int updateEmployee(HashMap<String, Object> map);

	
	@Select("select * from employee where name like #{name} ")
	public ArrayList<EmployeeDTO> selectNameEmployee(String name);
}
