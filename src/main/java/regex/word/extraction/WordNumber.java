package RegExp;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class WordNumber {
	public static void main(String[] args) {

		BufferedReader bReader = null;
		HashMap map = new HashMap();
		try {

			String s;
			File file = new File("C:\\Little.txt");
			bReader = new BufferedReader(new FileReader(file));

			while ((s = bReader.readLine()) != null) {
				Pattern p = Pattern.compile("\\b\\w+\\b");
				Matcher m = p.matcher(s);
				while (m.find()) {
					String[] data = { m.group() };
					for (int i = 0; i < data.length; i++) {
						if (map.containsKey(data[i])) {
							Integer value = (Integer) map.get(data[i]);
							map.put(data[i], value + 1);
						} else {
							map.put(data[i], 1);
						}
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bReader != null)
					bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = ((Integer) entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + value);
		}
		System.out.println("총 단어 수 : " + map.size());
	}
}
