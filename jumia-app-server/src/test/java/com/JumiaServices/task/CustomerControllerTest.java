package com.JumiaServices.task;

import com.JumiaServices.task.Controller.CustomerController;
import com.JumiaServices.task.Service.CustomerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

}
