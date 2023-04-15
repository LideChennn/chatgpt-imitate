package cn.edu.gdpu.chatgpt.domain;

public class History {

    private Integer historyId;
    private String historyName;
    private Integer userId;
    private AiPrompt aiPrompt;
    private String userAiPrompt;
    private Integer promptId;
    public Integer getHistoryId() {
        return historyId;
    }

    public Integer getPromptId() {
        return promptId;
    }

    public void setPromptId(Integer promptId) {
        this.promptId = promptId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName == null ? null : historyName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public AiPrompt getAiPrompt() {
        return aiPrompt;
    }

    public void setAiPrompt(AiPrompt aiPrompt) {
        this.aiPrompt = aiPrompt;
    }




    public String getUserAiPrompt() {
        return userAiPrompt;
    }

    public void setUserAiPrompt(String userAiPrompt) {
        this.userAiPrompt = userAiPrompt;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId=" + historyId +
                ", historyName='" + historyName + '\'' +
                ", userId=" + userId +
                ", aiPrompt=" + aiPrompt +
                ", userAiPrompt='" + userAiPrompt + '\'' +
                ", promptId=" + promptId +
                '}';
    }
}