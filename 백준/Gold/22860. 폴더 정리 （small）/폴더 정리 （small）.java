import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, Q;
	static int fileCnt;
	static Set<String> set;
	static Map<String, List<String>> folderMap = new HashMap<>();
	static Map<String, List<String>> fileMap = new HashMap<>();
	
	static void dfs(String initFolder) {
		List<String> fileList = fileMap.getOrDefault(initFolder, new ArrayList<>());
		fileCnt += fileList.size();
		set.addAll(fileList);
		
		for (String folder : folderMap.getOrDefault(initFolder, new ArrayList<>())) {
			dfs(folder);
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String f = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			if (c == 1) {
				List<String> folderList = folderMap.getOrDefault(p, new ArrayList<>());
				folderList.add(f);
				folderMap.put(p, folderList);
			} else {
				List<String> fileList = fileMap.getOrDefault(p, new ArrayList<>());
				fileList.add(f);
				fileMap.put(p, fileList);
			}
		}
		
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			String query = br.readLine();
			String[] queries = query.split("/");
			fileCnt = 0;
			set = new HashSet<>();
			dfs(queries[queries.length - 1]);
			sb.append(set.size() + " " + fileCnt).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
