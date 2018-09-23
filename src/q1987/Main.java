package q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static int[][] dist;
	static boolean[] visited;

	public static void DFS(Node n, boolean[] visited) {
		int i, j, ax, ay;
		for (i = 0; i < 4; i++) {
			ax = n.x + dx[i];
			ay = n.y + dy[i];

			if (ax < 0 || ax >= R || ay < 0 || ay >= C) continue;
			if (visited[map[ax][ay]]) continue;
			dist[ax][ay] = dist[n.x][n.y] + 1;

			max = (dist[ax][ay] > max) ? dist[ax][ay] : max;

			visited[map[ax][ay]] = true;
			DFS(new Node(ax, ay), visited);
			visited[map[ax][ay]] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		int i, j;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		dist = new int[R][C];
		max = 1;
		for (i = 0; i < R; i++) {
			String line = in.readLine();
			for (j = 0; j < C; j++) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}

		dist[0][0] = 1;
		visited[map[0][0]] = true;

		DFS(new Node(0, 0), visited);
		System.out.println(max);
		in.close();
	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
