package cn.edu.gdpu.chatgpt.domain;

public class ChatRecord {

    private Integer recordId;
    private Integer historyId;
    private String content;
    private AiResponse aiResponse;

    public AiResponse getAiResponse() {
        return aiResponse;
    }

    public void setAiResponse(AiResponse aiResponse) {
        this.aiResponse = aiResponse;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "recordId=" + recordId +
                ", historyId=" + historyId +
                ", content='" + content + '\'' +
                ", aiResponse=" + aiResponse +
                '}';
    }
}