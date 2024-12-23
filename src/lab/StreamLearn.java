package lab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

import org.json.JSONArray;
import org.json.JSONObject;

public class StreamLearn {

//	1,5,100
//	2,3,50
//	4,5,10

// 1 100
// 2, 50
// 4, 10

// 3, 50
// 5, 110

//  1 100   0
//  2  50   0
//	3   0  50
//	4  10   0
//	5   0 110

//	1 100
//	2 150
//	3 150
//	4 110
//	5 110

	public static void main(String[] args) {

//		1,5,100
//		2,3,50
//		4,5,10

		JSONArray first = new JSONArray().put(1).put(5).put(100);
		JSONArray second = new JSONArray().put(2).put(3).put(50);
		JSONArray third = new JSONArray().put(4).put(5).put(10);

		JSONArray i0 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i1 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i2 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i3 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i4 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i5 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i6 = new JSONArray().put(5).put(29).put(0E-9);
		JSONArray i7 = new JSONArray().put(20).put(29).put(0E-9);
		JSONArray i8 = new JSONArray().put(10).put(29).put(9.000000000);
		JSONArray i9 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i10 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i11 = new JSONArray().put(1).put(9).put(9.000000000);
		JSONArray i12 = new JSONArray().put(15).put(29).put(9.000000000);
		JSONArray i13 = new JSONArray().put(1).put(14).put(9.000000000);
		JSONArray i14 = new JSONArray().put(5).put(29).put(0E-9);
		JSONArray i15 = new JSONArray().put(1).put(4).put(0E-9);
		JSONArray i16 = new JSONArray().put(1).put(29).put(0E-9);
		JSONArray i17 = new JSONArray().put(1).put(29).put(9.000000000);
		JSONArray i18 = new JSONArray().put(11).put(29).put(9.000000000);
		JSONArray i19 = new JSONArray().put(1).put(10).put(9.000000000);
		JSONArray i20 = new JSONArray().put(15).put(29).put(0E-9);
		JSONArray i21 = new JSONArray().put(1).put(14).put(0E-9);
		JSONArray i22 = new JSONArray().put(1).put(29).put(9.000000000);
		JSONArray i23 = new JSONArray().put(5).put(29).put(9.000000000);
		JSONArray i24 = new JSONArray().put(6).put(29).put(8.100000000);
		JSONArray i25 = new JSONArray().put(15).put(29).put(19.000000000);
		JSONArray i26 = new JSONArray().put(6).put(14).put(9.000000000);
		JSONArray i27 = new JSONArray().put(15).put(29).put(9.000000000);
		JSONArray i28 = new JSONArray().put(6).put(14).put(19.000000000);
		JSONArray i29 = new JSONArray().put(10).put(29).put(0E-9);
		JSONArray i30 = new JSONArray().put(1).put(9).put(0E-9);
		JSONArray i31 = new JSONArray().put(15).put(29).put(0E-9);
		JSONArray i32 = new JSONArray().put(1).put(14).put(0E-9);
		JSONArray i33 = new JSONArray().put(17).put(29).put(0E-9);
		JSONArray i34 = new JSONArray().put(1).put(16).put(0E-9);
		JSONArray i35 = new JSONArray().put(5).put(29).put(9.000000000);

		List<JSONArray> items = Arrays.asList(first, second, third);

		items = Arrays.asList(new JSONArray().put(1).put(29).put(0E-9), new JSONArray().put(1).put(29).put(0E-9),
				new JSONArray().put(1).put(29).put(0E-9), new JSONArray().put(1).put(29).put(0E-9),
				new JSONArray().put(1).put(29).put(0E-9), new JSONArray().put(1).put(29).put(0E-9),
				new JSONArray().put(5).put(29).put(0E-9), new JSONArray().put(20).put(29).put(0E-9),
				new JSONArray().put(10).put(29).put(9.000000000), new JSONArray().put(1).put(29).put(0E-9),
				new JSONArray().put(1).put(29).put(0E-9), new JSONArray().put(1).put(9).put(9.000000000),
				new JSONArray().put(15).put(29).put(9.000000000), new JSONArray().put(1).put(14).put(9.000000000),
				new JSONArray().put(5).put(29).put(0E-9), new JSONArray().put(1).put(4).put(0E-9),
				new JSONArray().put(1).put(29).put(0E-9), new JSONArray().put(1).put(29).put(9.000000000),
				new JSONArray().put(11).put(29).put(9.000000000), new JSONArray().put(1).put(10).put(9.000000000),
				new JSONArray().put(15).put(29).put(0E-9), new JSONArray().put(1).put(14).put(0E-9),
				new JSONArray().put(1).put(29).put(9.000000000), new JSONArray().put(5).put(29).put(9.000000000),
				new JSONArray().put(6).put(29).put(8.100000000), new JSONArray().put(15).put(29).put(19.000000000),
				new JSONArray().put(6).put(14).put(9.000000000), new JSONArray().put(15).put(29).put(9.000000000),
				new JSONArray().put(6).put(14).put(19.000000000), new JSONArray().put(10).put(29).put(0E-9),
				new JSONArray().put(1).put(9).put(0E-9), new JSONArray().put(15).put(29).put(0E-9),
				new JSONArray().put(1).put(14).put(0E-9), new JSONArray().put(17).put(29).put(0E-9),
				new JSONArray().put(1).put(16).put(0E-9), new JSONArray().put(5).put(29).put(9.000000000));

//		items.stream().collect(Collectors.groupingBy(grou))

		final List<JSONArray> view = items.stream().collect(upperCollect());

		System.out.println(view);

//		final List<JSONArray> upper1 = items.parallelStream().collect(upperCollect());

//		System.out.println(view);

		JSONArray result = new JSONArray();

		BigDecimal runningTotal = BigDecimal.ZERO;
		BigDecimal periodEndLagMrr = BigDecimal.ZERO;
		for (int index = 0; index < view.size(); index++) {
			JSONArray json = view.get(index);
			BigDecimal periodStartMrr = BigDecimal.valueOf(json.getDouble(0));
			BigDecimal periodEndMrr = BigDecimal.valueOf(json.getDouble(1));
			BigDecimal mrr = runningTotal.add(periodStartMrr).subtract(periodEndLagMrr);
			BigDecimal periodEndMrrActual = periodEndLagMrr;
			runningTotal = mrr;
			periodEndLagMrr = periodEndMrr;
			result.put(new JSONObject().put("period", (index + 1) + "").put("mrr", mrr.toString())
					.put("start_mrr", periodStartMrr.toString()).put("end_mrr", periodEndMrr.toString())
					.put("end_mrr_lag", periodEndLagMrr.toString()).put("running_total", runningTotal.toString())

			);

			System.out.println((index + 1) + "\t" + mrr.toString() + "\t" + periodStartMrr + "\t" + periodEndMrr + "\t"
					+ periodEndMrrActual);
		}
//		System.out.println(result);
	}

	private static Collector<JSONArray, ?, List<JSONArray>> upperCollect() {
		return Collector.of(() -> {
			ArrayList<JSONArray> output = new ArrayList<JSONArray>();
			for (int i = 0; i < 30; i++) {
				JSONArray arr = new JSONArray().put(BigDecimal.ZERO).put(BigDecimal.ZERO);
				output.add(arr);
			}

			return output;
		},

				(list, value) -> {
					Integer periodStartIdx = value.getInt(0) - 1;
					Integer periodEndIdx = value.getInt(1) - 1;

					JSONArray periodStartArr = list.get(periodStartIdx);
					BigDecimal mrr = periodStartArr.getBigDecimal(0);
					mrr = mrr.add(value.getBigDecimal(2));
					periodStartArr.put(0, mrr);

					JSONArray periodEndArr = list.get(periodEndIdx);
					mrr = periodEndArr.getBigDecimal(1);
					mrr = mrr.add(value.getBigDecimal(2));
					periodEndArr.put(1, mrr);

				},

				(first, second) -> {
					throw new RuntimeException("Parallel Stream not supported");
				}, list -> Collections.unmodifiableList(list));
	}
}
