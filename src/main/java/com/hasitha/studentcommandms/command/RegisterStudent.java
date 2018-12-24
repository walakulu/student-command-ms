package com.hasitha.studentcommandms.command;

import com.hasitha.studentcommandms.model.Student;
import lombok.Data;

/**
 * <p>Command class to register student command object</p>
 */
@Data
public class RegisterStudent {
  private Student student;
}
