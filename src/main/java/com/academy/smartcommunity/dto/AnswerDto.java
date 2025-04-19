// src/main/java/com/academy/smartcommunity/dto/AnswerDto.java
package com.academy.smartcommunity.dto;

/**
 * 질문에 대한 답변을 받을 때 사용하는 DTO
 */
public class AnswerDto {
    private String answer;
    public AnswerDto() {}
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}
