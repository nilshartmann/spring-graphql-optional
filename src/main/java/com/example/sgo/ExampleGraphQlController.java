package com.example.sgo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ExampleGraphQlController {

  private static final Logger log = LoggerFactory.getLogger(ExampleGraphQlController.class);

  record ContactInput(String phone, String email) {
  }

  static class PersonalDataInput {
    private int age;

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }

  record AccountInput(String id,
                      Optional<String> fullname,
                      Optional<ContactInput> contact,
                      Optional<PersonalDataInput> personalData) {
  }

  @MutationMapping
  public String createAccount(@Argument AccountInput input) {
    log.info("Input: {}", input);

    // dummy
    return "OK";
  }

}
