package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.Board;

public interface BoardMapper {

	@Select("select count(*) from board where boardid=#{value}")
	int count(String boardid);
	
    String sql = "select * from "
+"( select rownum rnum, num ,writer, subject,content,"
+" file1 fileurl,regdate, grp, grplevel,grpstep,pass,readcnt from "
+" (select * from board where boardid=#{boardid} "
+" order by grp desc, grpstep asc))"
+" where rnum between #{startrow} and #{endrow}";
	@Select(sql)
	List<Board> list(Map<String, Object> param);
	
	@Select("select nvl(max(num),0) from board")
	int maxNum();
	@Insert("insert into board "
+"(num,writer,pass,subject,content,file1,regdate,readcnt,"
+" grp,grplevel,grpstep,boardid,ip)"
+" values (#{num},#{writer},#{pass},#{subject},"
+ " #{content},#{fileurl},sysdate,"
+ "0,#{grp},#{grplevel},#{grpstep},#{boardid},#{ip})")
	void insert(Board board);

	String cols = "num,writer,pass,subject,content,file1 fileurl,"
			+ "regdate,readcnt,grp,grplevel,grpstep,boardid,ip";
	
	@Select("select "+cols+" from board where num=#{num}")
	Board selectOne(Integer num);
    @Update
    ("update board set readcnt = readcnt+1 where num=#{num}")
	void readcntadd(Integer num);

    @Update("update board set writer=#{writer},subject=#{subject},"
    		+ "content=#{content}, file1=#{fileurl}"
    		+ " where num=#{num}")
	void update(Board board);

    @Update("update board set grpstep = grpstep + 1"
    		+ " where grp=#{grp} and grpstep > #{grpstep}")
	void getStepAdd(Board board);

    @Delete("delete from board where num=#{num}")
	void delete(Integer num);

    /*Map<String, Object> :
     *         {컬럼명1=컬럼값1,컬럼명2=컬럼값2,...} 객체로 전달
     * List<Map<String, Object>> 리턴
     * [{writer=홍길동,cnt=3},
     * {writer=김삿갓,cnt=2},
     * {writer=이몽룡,cnt=1}]
     */
    @Select("select * from "
	+ " (select writer,count(*) cnt from board "
	+ " where boardid=${value} group by writer order by 2 desc) a "
	+ " where rownum < 8")
	List<Map<String, Object>> graph1(String id);
/* 
 * [{DAY="22-10-11",CNT=5},{DAY="22-10-10",CNT=10}...]
 */
    @Select("select * from "
+ " (select to_char(regdate,'YY-MM-DD') day, count(*) cnt "
+ " from board "
+ " where boardid=${value} group by to_char(regdate,'YY-MM-DD')"
+ "   order by day desc) a"
+ " where rownum < 8")
	List<Map<String, Object>> graph2(String id);
}
