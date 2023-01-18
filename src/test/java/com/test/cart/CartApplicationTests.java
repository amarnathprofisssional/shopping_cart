package com.test.cart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CartApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void regularCustomerEqual5000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"REGULAR",5000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void regularCustomerEqual10000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"REGULAR",10000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void regularCustomerEqual15000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"REGULAR",15000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void premiumCustomerEqual4000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"PREMIUM",4000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void premiumCustomerEqual8000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"PREMIUM",8000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void premiumCustomerEqual12000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"PREMIUM",12000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

	@Test
	void premiumCustomerEqual20000Test() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/billing/{customerType}/{amount}",
				"PREMIUM",20000))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String str = mvcResult.getResponse().getContentAsString();
		System.out.println(str);
	}

}
