package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

public class StreamLearn2 {

	public static void main(String[] args) {
		// Sample map
		Map<String, List<JSONArray>> view = new HashMap<>();
		view.put("USD", new ArrayList<>(
				Arrays.asList(new JSONArray("[100,0]"), new JSONArray("[10,0]"), new JSONArray("[1,1]"))));
		view.put("INR",
				new ArrayList<>(Arrays.asList(new JSONArray("[1,0]"), new JSONArray("[0,0]"), new JSONArray("[0,0]"))));

//		// Calculate the sum of values for each key
//		List<JSONArray> sumList = view.values().stream().flatMap(List::stream).reduce(StreamLearn2::sumJSONArray)
//				.orElse(new JSONArray());

		// Print the sumList
//		System.out.println(sumList);
	}

	// Helper method to sum two JSONArrays
	private static JSONArray sumJSONArray(JSONArray arr1, JSONArray arr2) {
		JSONArray sumArray = new JSONArray();
		for (int i = 0; i < arr1.length(); i++) {
			int sum = arr1.getInt(i) + arr2.getInt(i);
			sumArray.put(sum);
		}
		return sumArray;
	}

}
