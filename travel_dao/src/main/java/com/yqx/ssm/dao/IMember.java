package com.yqx.ssm.dao;


import com.yqx.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author YangQX   2022/3/18 - 19:56
 */
@Repository
public interface IMember
{
    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
