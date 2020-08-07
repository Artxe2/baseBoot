package org.apache.mybatis;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GoogleChart {
	private static final com.google.gson.Gson gson = new com.google.gson.Gson();

	public static String toChartDataTable(String rowName, List<Map<String, Object>> list, String[] strs, String[] format) {
		StringBuilder sb = new StringBuilder();
		Map<String, Object> data = new HashMap<>();
		List<Map<String, Object>> cols = new ArrayList<>();
		data.put("cols", cols);
		Map<String, Object> col = new HashMap<>();
		col.put("type", "string");
		cols.add(col);
		if (strs != null) {
			for (String s : strs) {
				col = new HashMap<>();
				col.put("type", "string");
				cols.add(col);
			}
		}
		F: for (Map.Entry<String, Object> e : list.get(0).entrySet()) {
			if (!rowName.equals(e.getKey())) {
				if (strs != null) {
					for (String s : strs) {
						if (s.equals(e.getKey())) {
							continue F;
						}
					}
				}
				col = new HashMap<>();
				col.put("type", "number");
				cols.add(col);
			}
		}
		List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();
		data.put("rows", rows);
		Map<String, List<Map<String, Object>>> row;
		List<Map<String, Object>> cells;
		for (Map<String, Object> map : list) {
			row = new HashMap<>();
			cells = new ArrayList<Map<String, Object>>();
			row.put("c", cells);
			Map<String, Object> cell = new HashMap<>();
			cell.put("v", map.get(rowName));
			if (format != null) {
				sb.setLength(0);
				for (String t : format) {
					if (t.indexOf('#') == 0) {
						if (map.get(t.substring(1)) == null) {
							continue;
						}
						sb.append(map.get(t.substring(1)));
					} else {
						sb.append(t);
					}
				}
				cell.put("f", sb.toString());
			}
			cells.add(cell);
			if (strs != null) {
				for (String s : strs) {
					cell = new HashMap<>();
					cell.put("v", map.get(s));
					//					if (format != null) {
					//						sb.setLength(0);
					//						for (String t : format) {
					//							if (t.indexOf('#') == 0) {
					//								if (map.get(t.substring(1)) == null) {
					//									continue;
					//								}
					//								sb.append(map.get(t.substring(1)));
					//							} else {
					//								sb.append(t);
					//							}
					//						}
					//						cell.put("f", sb.toString());
					//					}
					cells.add(cell);
				}
			}
			F: for (Map.Entry<String, Object> e : map.entrySet()) {
				if (!rowName.equals(e.getKey())) {
					if (strs != null) {
						for (String s : strs) {
							if (s.equals(e.getKey())) {
								continue F;
							}
						}
					}
					cell = new HashMap<>();
					cell.put("v", e.getValue());
					//					if (format != null) {
					//						sb.setLength(0);
					//						for (String t : format) {
					//							if (t.indexOf('#') == 0) {
					//								if (map.get(t.substring(1)) == null) {
					//									continue;
					//								}
					//								sb.append(map.get(t.substring(1)));
					//							} else {
					//								sb.append(t);
					//							}
					//						}
					//						cell.put("f", sb.toString());
					//					}
					cells.add(cell);
				}
			}
			rows.add(row);
		}
		return gson.toJson(data);
	}
}