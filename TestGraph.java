
public class TestGraph {
	public static void main(String[] args) {
		Graph g = new Graph(new String[] {"A","B","C","D","E","F","G","H"}); // 그래프에  정점 삽입. 
		g.add("A", "B"); // 그래프 연결.
		g.add("A", "E"); 
		g.add("B", "C");
		g.add("B", "F");
		g.add("C", "D");
		g.add("C", "H");
		g.add("D", "H");
		g.add("E", "F");
		g.add("F", "G");
		System.out.print("recu_dfs : ");
		g.recu_dfs(0); // 재귀로 구현한 순환 깊이우선탐색 실행.
		System.out.println("");
		System.out.print("nonrecu_dfs : ");
		g.nonrecu_dfs(g.a, g.visit2, 0, true); // 스택으로 구현한 깊이우선탐색 실행.
	}
}
