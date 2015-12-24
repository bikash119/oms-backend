/**
 * 
 */
package com.crossover.assignment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.assignment.model.OrderLine;
import com.crossover.assignment.service.url.OrderLineItemsRestURIConstants;

/**
 * @author bikash
 *
 */
@Controller
public class OrderLineController extends DefaultController {

	private static final Logger logger = LoggerFactory.getLogger(OrderLineController.class);

	@RequestMapping(value = OrderLineItemsRestURIConstants.ORDERLINE_DUMMY, method = RequestMethod.GET)
	public @ResponseBody OrderLine getDummyOrderLine() {
		logger.info("");
		return null;
	}

	@RequestMapping(value = OrderLineItemsRestURIConstants.GET_ORDERLINE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody OrderLine getOrderLineById(@PathVariable("id") int custId) {
		logger.info("");
		return null;

	}

	// TODO implement pagination
	@RequestMapping(value = OrderLineItemsRestURIConstants.GET_ALL_ORDERLINE, method = RequestMethod.GET)
	public @ResponseBody List<OrderLine> getOrderLines() {
		logger.info("");
		return null;
	}

	@RequestMapping(value = OrderLineItemsRestURIConstants.CREATE_ORDERLINE, method = RequestMethod.POST)
	public @ResponseBody OrderLine createOrderLine(@RequestBody OrderLine customer) {
		logger.info("");
		return null;
	}

	@RequestMapping(value = OrderLineItemsRestURIConstants.UPDATE_ORDERLINE, method = RequestMethod.POST)
	public @ResponseBody OrderLine updateOrderLine(@RequestBody OrderLine customer, @PathVariable("id") int id) {
		logger.info("");
		return null;
	}

}
