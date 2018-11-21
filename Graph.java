import java.util.Stack;

public class Graph {
	int size;
	String[] vertices; // 정점 인덱스의 String형 (A, B, C, D ...)을 가지고 있는 String 배열 
	boolean[][] a; // 0이면 false, 1이면 true 값을 가지는 2X2 행렬
	boolean[] visit; // recu_dfs() 를 실행할 때 방문한 index를 표시하기 위한 boolean 배열
	boolean[] visit2; // nonrecu_dfs() 를 실행할 때 방분한 index를 표시하기 위한 boolean 배열
	

	public Graph(String[] args) {
		size = args.length; // 배열의 사이즈는 입력한 String 배열의 개수.
		vertices = new String[size]; // String 배열 선언
		System.arraycopy(args, 0, vertices, 0, size); // vertices 배열에 초기에 입력한 정점들을 삽입.
		a = new boolean[size][size]; // 2차원 배열 선언
		visit = new boolean[size]; // recu_dfs()의 visit 배열 선언.
		visit2 = new boolean[size]; // nonrecu_dfs()의  visit 배열 선언.
	}

	public void add(String v, String w) { // Graph 배열에 elements 삽입.
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	public String toString() { // Graph 배열에 있는 elements 들을 출력하는 메소드.
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("[" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}

	private int index(String v) { // index값과 verticis 배열에 들어있는 String을 매칭시키기 위한 메소드.
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	private String vertex(int i) { // vertices 배열의 elements를 출력하기 위한 메소드.
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (a[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}

	public void recu_dfs(int i) { // 재귀를 이용한 순환 깊이우선탐색 알고리즘 실행.
		visit[i] = true; // 처음 함수 호출 시 입력한 index의 값은 true로 시작.
		System.out.print(vertices[i] + " "); // 첫번째 elements 출력.

		for (int j = 1; j < a.length; j++) { // 배열의 길이만큼 반복
			if (a[i][j] == true && visit[j] == false) { // j를 방문하지 않았으면
				recu_dfs(j); // 같은 메소드로 j를 방문한다.
			}
		}
	}

	public void nonrecu_dfs(boolean[][] a, boolean[] l, int v, boolean flag) { // 스택을 이용한 깊이우선탐색 알고리즘 실행.
		Stack<Integer> s = new Stack<>(); // 탐색에 visit 마킹을 하기 위한 스택 s 선언.
		int n = a.length -1; // a.length = 8 이기 때문에 배열의 최대 index인 7까지 실행하기 위함.

		s.push(v); // 스택 s에 초기 탐색의 시작점을 push
		l[v] = true; // visit 마킹 boolean 배열의 v index는 true로 변환.
		System.out.print(vertices[v] + " ");
		while (!s.isEmpty()) { // 스택이 모두 peek 되어 아무것도 없을 때 까지 반복.
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
