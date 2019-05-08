package cn.pomit.consulproxy.mapper.advice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.pomit.consulproxy.domain.advice.FAdviceInfo;

@Mapper
public interface FAdviceInfoDao {

	@Select({
		"<script>",
		"select id id,name name,contract contract,",
		"summary summary,content content,status status",
		"from f_advice_info ",
		" where status = #{status, jdbcType=INTEGER}",
		"</script>"
	})
	List<FAdviceInfo> findByStatus(@Param("status") Integer status);

	@Insert({"<script>",
        "INSERT INTO f_advice_info(name , contract , summary , content , status )",
        "values ",
        "(#{name},#{contract},#{summary},#{content},#{status})",
        "</script>"})
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int save(FAdviceInfo fAdviceInfo);

	@Update({
		"<script>",
		" update f_advice_info set",
		"<if test='name != null and name != \"\" '> name = #{name, jdbcType=VARCHAR}, </if>",
		"<if test='contract != null and contract != \"\" '> contract = #{contract, jdbcType=VARCHAR}, </if>",
		"<if test='content != null and content != \"\" '> content = #{content, jdbcType=VARCHAR}, </if>",
		"<if test='status != -1 '> status = #{status, jdbcType=INTEGER}, </if>",
		"<if test='summary != null and summary != \"\" '> summary = #{summary, jdbcType=VARCHAR} </if>",
		" where id=#{id}",
		"</script>"
	})
	int update(FAdviceInfo fAdviceInfo);

	@Select({
		"<script>",
		"select id id,name name,contract contract,",
		"summary summary,content content,status status",
		"from f_advice_info ",
		" where id = #{id, jdbcType=INTEGER}",
		"</script>"
	})
	FAdviceInfo findOne(@Param("id") int id);

	@Delete({
		"<script>",
		" delete from f_advice_info",
		" where id=#{id}",
		"</script>"
	})
	int deleteById(@Param("id") Integer id);

}