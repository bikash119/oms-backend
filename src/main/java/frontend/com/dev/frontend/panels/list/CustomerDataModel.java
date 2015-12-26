package com.dev.frontend.panels.list;

import java.util.List;

import com.crossover.assignment.model.Customer;
import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
		//TODO: by the candidate
		/* Bikash :- IMPL done
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		List<Object> records = Services.listCurrentRecords(Services.TYPE_CUSTOMER);
		
		String[][] customers = prepareRows(records);
		return customers;
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
		Customer cust = (Customer)row;
		cols[0] = cust.getId()+"";
		cols[1] = cust.getName();
		cols[2] = cust.getPhoneNumber1();
		cols[3] = cust.getCurrentCredit()+"";
		return cols;
	}
}
