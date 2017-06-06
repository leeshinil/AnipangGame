package com.makers.showmethemoney.model.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class RankingLogic {
	public static void main(String[] args) {
		writeScoreToFile("½Å¿ìÃ¢", 45);
	}
	// file read
	public static LinkedList<GameRankingData> readScoreToFile() {
		LinkedList<GameRankingData> list = new GameRankingData().getList(); 
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("ranking.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				String input[] = line.split(" ");
				// input[0] => nickname, input[1] => score
				String nickname = input[0];
				int score = Integer.parseInt(input[1]);
				list.add(new GameRankingData(nickname, score));
			}
			br.close();
		} catch (IOException e) {
		}
		return list;
	}

	// file write
	public static void writeScoreToFile(String nickname, int total_score) {
		LinkedList<GameRankingData> list = readScoreToFile();
		list.add(new GameRankingData(nickname, total_score));
		Collections.sort(list, new GameRankingDataCompare());
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("ranking.txt");
			for (GameRankingData g : list) {
				fw.write(g.getNickname() + " " + g.getTotal_score() + "\n");
			}
			fw.close();
		} catch (IOException e) {
		}
	}
}

// sorting
class GameRankingDataCompare implements Comparator<GameRankingData> {

	@Override
	public int compare(GameRankingData g1, GameRankingData g2) {
		if (g1.getTotal_score() < g2.getTotal_score()) {
			return 1;
		} else {
			return -1;
		}
	}
}
