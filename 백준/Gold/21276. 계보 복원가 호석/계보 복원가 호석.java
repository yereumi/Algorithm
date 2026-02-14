import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static Map<String, List<String>> map;
	static Map<String, Integer> indegree;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		indegree = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String name = st.nextToken();
			map.put(name, new ArrayList<>());
			indegree.put(name, 0);
		}
		
		M = Integer.parseInt(br.readLine()); 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent = st.nextToken();
			
			List<String> children = map.get(parent);
			children.add(child);
			
			map.put(parent, children);
			indegree.put(child, indegree.get(child) + 1);
		}
		
		List<String> roots = new ArrayList<>();
        for (String name : indegree.keySet()) {
            if (indegree.get(name) == 0) {
                roots.add(name);
            }
        }
        Collections.sort(roots);
        
        Map<String, List<String>> realChildren = new HashMap<>();
        for (String name : map.keySet()) {
            realChildren.put(name, new ArrayList<>());
        }
        
        Deque<String> dq = new ArrayDeque<>();
        for (String root : roots) {
            dq.offer(root);
        }
        
        while (!dq.isEmpty()) {
            String cur = dq.poll();
            
            for (String next : map.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                
                if (indegree.get(next) == 0) {
                    realChildren.get(cur).add(next);
                    dq.offer(next);
                }
            }
        }
		
        sb.append(roots.size()).append("\n");
        for (String r : roots) {
            sb.append(r).append(" ");
        }
        sb.append("\n");
        
        List<String> names = new ArrayList<>(map.keySet());
        Collections.sort(names);
        
        for (String name : names) {
            List<String> children = realChildren.get(name);
            Collections.sort(children);
            
            sb.append(name).append(" ").append(children.size());
            
            for (String c : children) {
                sb.append(" ").append(c);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
		br.close();
	}
}
