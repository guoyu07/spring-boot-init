package com.kyee.repository;

import com.kyee.domain.Questionnaire;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionnaireMapper {

    @Select("SELECT ID, QUESTIONNAIRE_NAME AS QUESTIONNAIRENAME, START_TIME AS STARTTIME, END_TIME AS ENDTIME FROM QUESTIONNAIRE WHERE QUESTIONNAIRE_NAME = #{name}")
    Questionnaire getByName(@Param("name") String name);

    @Insert("INSERT INTO QUESTIONNAIRE(QUESTIONNAIRE_NAME, START_TIME, END_TIME) VALUES(#{name}, #{startTime}, #{endTime})")
    int insertQuestionnaire(@Param("name") String name,
                            @Param("startTime") long startTime,
                            @Param("endTime") long endTime);

    @Select("SELECT ID, QUESTIONNAIRE_NAME AS QUESTIONNAIRENAME, START_TIME AS STARTTIME, END_TIME AS ENDTIME FROM QUESTIONNAIRE WHERE ID = #{id}")
    Questionnaire getById(long id);
}
