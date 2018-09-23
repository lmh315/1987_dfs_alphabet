package q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, dist;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[] visited;

	public static void DFS(int x, int y, int r, boolean[] visited) {
		int i, ax, ay;
//		System.out.println(x + " " + y + " " + r + " " );
		for (i = 0; i < 4; i++) {
			ax = x + dx[i];
			ay = y + dy[i];

			if (ax < 0 || ax >= R || ay < 0 || ay >= C) continue;
			if (visited[map[ax][ay]]) continue;

			r++;
			visited[map[ax][ay]] = true;
			DFS(ax, ay, r, visited);
			r--;
			visited[map[ax][ay]] = false;
		}
		
		dist = (r > dist) ? r : dist;
	}

	public static void main(String[] args) throws IOException {
		int i, j;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		for (i = 0; i < R; i++) {
			String line = in.readLine();
			for (j = 0; j < C; j++) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}

		visited[map[0][0]] = true;

		DFS(0,0,1,visited);
		System.out.println(dist);
		in.close();
	}
}
