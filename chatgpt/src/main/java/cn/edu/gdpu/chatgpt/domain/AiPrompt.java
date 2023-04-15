package cn.edu.gdpu.chatgpt.domain;

public class AiPrompt {
    private Integer promptId;

    private String model;

    private String content;

    public Integer getPromptId() {
        return promptId;
    }

    public void setPromptId(Integer promptId) {
        this.promptId = promptId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "AiPrompt{" +
                "promptId=" + promptId +
                ", model='" + model + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}