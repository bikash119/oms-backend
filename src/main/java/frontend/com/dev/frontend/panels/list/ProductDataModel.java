package com.dev.frontend.panels.list;

import java.util.List;

import com.crossover.assignment.model.Product;
import com.dev.frontend.services.Services;


public class ProductDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() 
	{
		super(new String[]{"Code","Description","Price","Quantity"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate
		/* Bikash :- IMPL done
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
		List<Object> records = Services.listCurrentRecords(Services.TYPE_PRODUCT);
		//String[][] sampleData = new String [][]{{"01","Product 1","12.5","25"},{"02","Product 2","10","8"}};
		String[][] products = prepareRows(records);
		return products;
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
		Product prod = (Product)row;
		cols[0] = prod.getId()+"";
		cols[1] = prod.getDesc();
		cols[2] = prod.getPrice()+"";
		cols[3] = prod.getQuantity()+"";
		return cols;
	}
}
