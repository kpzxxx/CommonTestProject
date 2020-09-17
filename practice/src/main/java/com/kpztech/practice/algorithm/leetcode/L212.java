package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 */
public class L212 {
	@Test
	public void test() {
		char[][] board = {{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		List<String> result = findWords(board, words);
		result.forEach(System.out::println);
	}

	private char[][] _board = null;
	private List<String> _result = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {
		L208.Trie trie = new L208.Trie();
		Arrays.stream(words).forEach(trie::insert);
		_board = board;


		return this._result;

	}

	private void backtracking(int row, int col, L208.Trie parent){
		char letter = this._board[row][col];
//		parent.searchPrefix(letter)
	}
}
