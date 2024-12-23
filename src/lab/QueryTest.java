package lab;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

public class QueryTest {

	public static void main(String[] args) {
		int count = 0;

		String a = "[\"unload (''select * from subscritions where data_source_id = 1'') to ''s3://cb-dev-us-e1-etl-staging/1/data/export_1.csv'' iam_role ''arn:aws:iam::817182243321:role/cb-dev-us-e1-insights-redshift-role'';\"]";

		String b = "[\"unload ('select * from subscritions where data_source_id = 1') to 's3://cb-dev-us-e1-etl-staging/1/data/export_1.csv' iam_role 'arn:aws:iam::817182243321:role/cb-dev-us-e1-insights-redshift-role';\"]";

//		String a = "[\"unload (\'select * from subscritions where data_source_id = 1\') to \'s3://cb-dev-us-e1-etl-staging/1/data/export_1.csv\' iam_role \'arn:aws:iam::817182243321:role/cb-dev-us-e1-insights-redshift-role\';\"]";

		System.out.println(a.equals(b));
		JSONArray jsonArray = new JSONArray(a);
		jsonArray.forEach((str) -> {
			System.out.println(str);
		});

		List<String> migrations = IntStream.range(0, jsonArray.length()).mapToObj(i -> jsonArray.getString(i))
				.collect(Collectors.toList());

		migrations.forEach((str) -> {
			MessageFormat messageFormat = new MessageFormat(StringUtils.replace(str, "{SCHEMA}", "{0}"));
			System.out.println(messageFormat);
			String actualQuery = messageFormat.format(new Object[] { "public" });
			System.out.println(actualQuery);
		});

	}

}
