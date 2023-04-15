package cn.edu.gdpu.chatgpt.domain;

public class AiResponse {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ai_responses.ai_response_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    private Integer aiResponseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ai_responses.record_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    private Integer recordId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ai_responses.content
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ai_responses.ai_response_id
     *
     * @return the value of ai_responses.ai_response_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public Integer getAiResponseId() {
        return aiResponseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ai_responses.ai_response_id
     *
     * @param aiResponseId the value for ai_responses.ai_response_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public void setAiResponseId(Integer aiResponseId) {
        this.aiResponseId = aiResponseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ai_responses.record_id
     *
     * @return the value of ai_responses.record_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ai_responses.record_id
     *
     * @param recordId the value for ai_responses.record_id
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ai_responses.content
     *
     * @return the value of ai_responses.content
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ai_responses.content
     *
     * @param content the value for ai_responses.content
     *
     * @mbggenerated Tue Apr 04 19:27:46 CST 2023
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "AiResponse{" +
                "aiResponseId=" + aiResponseId +
                ", recordId=" + recordId +
                ", content='" + content + '\'' +
                '}';
    }
}
