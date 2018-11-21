import java.util.Stack;

public class Graph {
	int size;
	String[] vertices; // ���� �ε����� String�� (A, B, C, D ...)�� ������ �ִ� String �迭 
	boolean[][] a; // 0�̸� false, 1�̸� true ���� ������ 2X2 ���
	boolean[] visit; // recu_dfs() �� ������ �� �湮�� index�� ǥ���ϱ� ���� boolean �迭
	boolean[] visit2; // nonrecu_dfs() �� ������ �� ����� index�� ǥ���ϱ� ���� boolean �迭
	

	public Graph(String[] args) {
		size = args.length; // �迭�� ������� �Է��� String �迭�� ����.
		vertices = new String[size]; // String �迭 ����
		System.arraycopy(args, 0, vertices, 0, size); // vertices �迭�� �ʱ⿡ �Է��� �������� ����.
		a = new boolean[size][size]; // 2���� �迭 ����
		visit = new boolean[size]; // recu_dfs()�� visit �迭 ����.
		visit2 = new boolean[size]; // nonrecu_dfs()��  visit �迭 ����.
	}

	public void add(String v, String w) { // Graph �迭�� elements ����.
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	public String toString() { // Graph �迭�� �ִ� elements ���� ����ϴ� �޼ҵ�.
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("[" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}

	private int index(String v) { // index���� verticis �迭�� ����ִ� String�� ��Ī��Ű�� ���� �޼ҵ�.
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	private String vertex(int i) { // vertices �迭�� elements�� ����ϱ� ���� �޼ҵ�.
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (a[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}

	public void recu_dfs(int i) { // ��͸� �̿��� ��ȯ ���̿켱Ž�� �˰��� ����.
		visit[i] = true; // ó�� �Լ� ȣ�� �� �Է��� index�� ���� true�� ����.
		System.out.print(vertices[i] + " "); // ù��° elements ���.

		for (int j = 1; j < a.length; j++) { // �迭�� ���̸�ŭ �ݺ�
			if (a[i][j] == true && visit[j] == false) { // j�� �湮���� �ʾ�����
				recu_dfs(j); // ���� �޼ҵ�� j�� �湮�Ѵ�.
			}
		}
	}

	public void nonrecu_dfs(boolean[][] a, boolean[] l, int v, boolean flag) { // ������ �̿��� ���̿켱Ž�� �˰��� ����.
		Stack<Integer> s = new Stack<>(); // Ž���� visit ��ŷ�� �ϱ� ���� ���� s ����.
		int n = a.length -1; // a.length = 8 �̱� ������ �迭�� �ִ� index�� 7���� �����ϱ� ����.

		s.push(v); // ���� s�� �ʱ� Ž���� �������� push
		l[v] = true; // visit ��ŷ boolean �迭�� v index�� true�� ��ȯ.
		System.out.print(vertices[v] + " ");
		while (!s.isEmpty()) { // ������ ��� peek �Ǿ� �ƹ��͵� ���� �� ���� �ݺ�.
			int visit = s.peek();
			flag = false;
			for (int i = 1; i <= n; i++) {
				if (a[visit][i] == true && !l[i]) {
					s.push(i);
					System.out.print(vertices[i] + " ");
					l[i] = true;
					flag = true;
					break;
				}
			}
			if (!flag) {
				s.pop();
			}
		}
	}

}
