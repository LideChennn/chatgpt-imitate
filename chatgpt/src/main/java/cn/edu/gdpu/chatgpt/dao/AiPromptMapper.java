package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.AiPrompt;
import cn.edu.gdpu.chatgpt.domain.AiPromptExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AiPromptMapper {
    /**
     * 根据promptId
     * @param promptId .
     * @return AiPrompt
     */
    AiPrompt selectByPromptIdInt(Integer promptId);

    int countByExample(AiPromptExample example);

    int deleteByExample(AiPromptExample example);

    int insert(AiPrompt record);

    int insertSelective(AiPrompt record);

    List<AiPrompt> selectByExampleWithBLOBs(AiPromptExample example);

    List<AiPrompt> selectByExample(AiPromptExample example);

    int updateByExampleSelective(@Param("record") AiPrompt record, @Param("example") AiPromptExample example);

    int updateByExampleWithBLOBs(@Param("record") AiPrompt record, @Param("example") AiPromptExample example);

    int updateByExample(@Param("record") AiPrompt record, @Param("example") AiPromptExample example);
}