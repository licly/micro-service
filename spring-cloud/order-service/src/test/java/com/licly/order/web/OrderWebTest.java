package com.licly.order.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * {@link OrderWeb}单元测试
 *
 * @author licly
 * @date 2020/10/8
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderWebTest {

	@MockBean
	private OrderService service;

	@Resource
	private MockMvc mockMvc;

	@Test
	public void testPlaceOrder() throws Exception {
		Mockito.when(service.placeOrder(Mockito.any(Order.class)))
				.thenReturn(Result.success());
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/order/placeOrder")
				.content(new ObjectMapper().writeValueAsString(new Order()))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String contentAsString = mvcResult.getResponse().getContentAsString();
		Result result = new ObjectMapper().readValue(contentAsString, Result.class);
		Assertions.assertThat(result.getCode()).isEqualTo(0);
	}
}
