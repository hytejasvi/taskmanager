package com.learningSpringboot.taskmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateTaskDto {
    String title;
    String description;
    String deadline;
}
