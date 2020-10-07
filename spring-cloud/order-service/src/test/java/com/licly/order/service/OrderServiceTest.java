package com.licly.order.service;

import com.licly.order.entity.Order.Order;
import com.licly.order.feign.CreditService;
import com.licly.order.feign.StockService;
import com.licly.order.feign.WmsService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * {@link OrderService}单元测试
 *
 * @author licly
 * @date 2020/10/7
 */

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@Mock
	private CreditService creditService;

	@Mock
	private WmsService wmsService;

	@Mock
	private StockService stockService;

	@InjectMocks
	@Spy
	private OrderService service;

	@Test
	public void testPlaceOrder() {
		service.placeOrder(new Order());
	}

}
