package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test1017.Professor;
public interface ProfessorMapper {
	
	@Select("select count(*) from professor")
	public int count();
	
	@Select("select * from professor")
	public List<Professor> select1();
	
	@Select("select * from professor where deptno = #{value}")
	public List<Professor> select2(int profno);
	// 교수중 성이 김씨인 전임강사 정보를 출력하기
	@Select("select * from professor where name like '${name}%' and position = #{position}")
	public List<Professor> select3(Map<String, Object> map);
	
	@Select("select * from professor where name like '${name}%' and position = #{position}")
	public List<Professor> select4(@Param("name") String name, @Param("position") String postion);
}