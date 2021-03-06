package com.dev.frontend.panels.list;

import java.util.List;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.model.SalesOrder;
import com.dev.frontend.services.Services;


public class SalesOrderDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() 
	{
		super(new String[]{"Order Number","Customer","Total Price"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate
		/* Bikash :- IMPL done
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		List<Object> records = Services.listCurrentRecords(Services.TYPE_SALESORDER);
		String[][] salesOrders = prepareRows(records);
		return salesOrders;
	}
	
	private String[][] prepareRows(List<Object> listCurrentRecords) {
		String[][] rows = new String[listCurrentRecords.size()][];
		int i = 0;
		for (Object row : listCurrentRecords) {
			String[] columns = prepareColumns(row);
			rows[i] = columns;
			i++;
		}
		return rows;
	}

	private String[] prepareColumns(Object row) {
		String[] cols = new String[4];
		SalesOrder salesOrder = (SalesOrder)row;
		cols[0] = salesOrder.getId()+"";
		cols[1] = pepareCustomerString(salesOrder.getCustomer());
		cols[2] = salesOrder.getTotalPrice()+"";
		return cols;
	}

	private String pepareCustomerString(Customer customer) {
		StringBuilder cust = new StringBuilder("(");
		cust.append(customer.getId());
		cust.append(")");
		cust.append(customer.getName());
		return cust.toString();
	}
}
