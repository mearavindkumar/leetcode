package lab.daily;

import java.util.Arrays;
import java.util.Iterator;

public class Jul17 {

	public static void main(String[] args) {
		Jul17 instance = new Jul17();
//		System.out.println(instance.findComplement(5));
//		System.out.println(instance.findComplement(1));
//		System.out.println();
		instance.printQuery();
	}

	public void printQuery() {
		String tableCSV = "authrization_payment_mappings,subscription_component_histories,subscriptions,order_line_items,payments,applied_credits,invoice_tax_lines,invoice_discount_lines,payment_sources,invoice_line_items,products,refunds,credit_note_tax_lines,credit_note_transactions,credit_note_discount_lines,invoices,coupons,order_addresses,transaction_error_details,invoice_discounts,customers,old_invoice_line_items,invoice_transactions,credit_note_taxes,order_credit_notes,subscription_histories,order_tax_line_items,credit_note_discounts,credit_note_line_items,payment_refund_mappings,dunning_details,credit_notes,order_discount_line_items,invoice_taxes,orders,invoice_histories,subscription_addons,data_source_currencies,manual_exchange_rates,rev_rec_line_items,customer_balances,multi_business_entities,addon_custom_fields,plan_custom_fields,customer_custom_fields,subscription_custom_fields,addon_price_custom_fields,plan_price_custom_fields,charge_price_custom_fields,items,item_families,item_prices,customer_billing_addresses";
		Iterator<String> ite = Arrays.asList(tableCSV.split(",")).iterator();
		while (ite.hasNext()) {
			String tableName = ite.next();
			String insertTableName = tableName + "_sys_inserts";
			String deleteTableName = tableName + "_sys_deletes";

			String query = "SELECT '" + tableName + "' AS table_name, COUNT(*) AS count FROM " + "(SELECT t1.* FROM "
					+ insertTableName + " t1  LEFT ANTI JOIN " + deleteTableName
					+ " t2 ON t1.data_source_id = t2.data_source_id AND t1.ch_uuid = t2.ch_uuid WHERE t1.data_source_id = 3357) AS "
					+ tableName;

			System.out.println(query);

			if (ite.hasNext()) {
				System.out.println("UNION ALL");
			}
		}
	}

	public int findComplement(int num) {

		System.out.println("actual " + (num));
		System.out.print("bit ");
		printInBinary(num);

		System.out.println("\nactual " + (~num));
		System.out.print("bit ");
		printInBinary((~num));

		System.out.println("\nactual highest one bit " + Integer.highestOneBit(num));
		System.out.print("bit ");
		printInBinary(Integer.highestOneBit(num));

		System.out.println("\nactual highest one bit minus " + (Integer.highestOneBit(num) - 1));
		System.out.print("bit ");
		printInBinary((Integer.highestOneBit(num) - 1));
		System.out.print("\n");

		return ~num & (Integer.highestOneBit(num) - 1);

//		return ~num & (Integer.highestOneBit(num) - 1);
//		if (num == 0) {
//			return 1;
//		}
//		StringBuilder builder = new StringBuilder();
//		while (num > 0) {
//			builder.append(((num & 1) == 1 ? "0" : "1") + "");
//			num = num >> 1;
//		}
//		return Integer.parseInt(builder.toString(), 2);
	}

	public void printInBinary(int num) {
		System.out.print(Integer.toBinaryString(num));
	}
}
