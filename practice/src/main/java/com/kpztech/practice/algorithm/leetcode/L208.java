package com.kpztech.practice.algorithm.leetcode;

import lombok.Getter;
import org.junit.Test;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class L208 {

	@Test
	public void test() {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 true
		System.out.println(trie.search("app"));     // 返回 false
		System.out.println(trie.startsWith("app")); // 返回 true
		trie.insert("app");
		System.out.println(trie.search("app"));     // 返回 true
	}

	public static class Trie {

		@Getter
		private TrieNode root;

		/**
		 * Initialize your data structure here.
		 */
		public Trie() {
			root = new TrieNode();
		}

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char currentChar = word.charAt(i);
				if (!node.containsKey(currentChar)) {
					node.put(currentChar, new TrieNode());
				}
				node = node.get(currentChar);
			}
			node.setEnd();
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			TrieNode node = searchPrefix(word);
			return node != null && node.isEnd();
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode node = searchPrefix(prefix);
			return node != null;
		}

		private TrieNode searchPrefix(String prefix) {
			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char currentChar = prefix.charAt(i);
				if (node.containsKey(currentChar)) {
					node = node.get(currentChar);
				} else {
					return null;
				}
			}
			return node;
		}
	}
}
