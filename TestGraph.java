
public class TestGraph {
	public static void main(String[] args) {
		Graph g = new Graph(new String[] {"A","B","C","D","E","F","G","H"}); // �׷�����  ���� ����. 
		g.add("A", "B"); // �׷��� ����.
		g.add("A", "E"); 
		g.add("B", "C");
		g.add("B", "F");
		g.add("C", "D");
		g.add("C", "H");
		g.add("D", "H");
		g.add("E", "F");
		g.add("F", "G");
		System.out.print("recu_dfs : ");
		g.recu_dfs(0); // ��ͷ� ������ ��ȯ ���̿켱Ž�� ����.
		System.out.println("");
		System.out.print("nonrecu_dfs : ");
		g.nonrecu_dfs(g.a, g.visit2, 0, true); // �������� ������ ���̿켱Ž�� ����.
	}
}
