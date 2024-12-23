package lab.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class CBTest {

	public static void main(String[] args) throws Exception {
		JSONObject json = new JSONObject(getClickHouseSyncSql(1l, 1000l));
		System.out.println(json);
	}

	public static Map<String, List<String>> getClickHouseSyncSql(Long dataSourceId, Long etlSyncLogId)
			throws Exception {
		String s3UrlPrefix = "https://s3.aws.com/";
		Map<String, List<String>> queries = new HashMap<>();
//		for (Iterator<String> itr = tableColMap.keySet().iterator(); itr.hasNext();) {

		String tableName = "subscriptions";
		String insertTableName = tableName + "_sys_inserts";
		String deleteTableName = tableName + "_sys_deletes";
		String colString = "id, data_source_id";
		String fileName = "1_2_subs.csv";

//			if (!tableName.equalsIgnoreCase("subscriptions")) {
//				continue;
//			}

//			TODO Check
		String s3Url = s3UrlPrefix + "/" + fileName;
		String insertSql = "INSERT INTO " + insertTableName + " ( " + colString + " ) FROM s3('" + s3Url
				+ "_insert'. 'CSV')";

		String deleteSql = "INSERT INTO " + deleteTableName + " (data_source_id, ch_uuid) " + "SELECT " + dataSourceId
				+ " as data_source_id, ch_uuid FROM " + insertTableName + " t1 LEFT ANTI JOIN  " + deleteTableName
				+ " t2 ON t1.data_source_id = t2.data_source_id AND t1.ch_uuid = t2.ch_uuid "
				+ " WHERE t1.data_source_id = " + dataSourceId + " AND t2.data_source_id = " + dataSourceId
				+ " AND id in ( SELECT id FROM s3('" + s3Url + "', 'CSV')) ";

		String upsertDeleteSql = "INSERT INTO " + deleteTableName + " (data_source_id, ch_uuid) " + "SELECT "
				+ dataSourceId + " as data_source_id, t1.ch_uuid FROM " + insertTableName + " t1 LEFT ANTI JOIN  "
				+ deleteTableName + " t2 ON t1.data_source_id = t2.data_source_id AND t1.ch_uuid = t2.ch_uuid "
				+ " WHERE t1.data_source_id = " + dataSourceId + " AND t2.data_source_id = " + dataSourceId
				+ " AND id in ( SELECT id FROM s3('" + s3Url + "', 'CSV')) ";

		String upsertInsertSql = "INSERT INTO " + insertTableName + " ( " + colString + " ) SELECT " + colString
				+ " FROM s3('" + s3Url + "', 'CSV')";

		List<String> sqls = Arrays.asList(insertSql, deleteSql, upsertDeleteSql, upsertInsertSql);

		queries.put(tableName, sqls);
//		}
		return queries;
	}
}
