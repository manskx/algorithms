package interviewbit.heapsandmaps;

import java.io.ObjectOutputStream.PutField;
import java.util.*;

public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 2;
		LRU cache = new LRU(cacheSize);
		cache.set(1, 10);
		cache.set(5, 12);
		System.out.println(cache.get(5));
		System.out.println(cache.get(1));
		System.out.println(cache.get(10));
		cache.set(6, 14);
		System.out.println(cache.get(5));
	}

	private int Capacity;
	private Map<Integer, LinkedListNode> CacheMap;
	private LinkedListNode head, tail;

	public LRU(int capacity) {
		Capacity = capacity;
		CacheMap = new LinkedHashMap<Integer, LinkedListNode>();
	}

	public int get(int key) {

		LinkedListNode node;
		if (CacheMap.containsKey(key)) {
			node = CacheMap.get(key);
			// if not head remove from list
			if (node != head) {
				removeLinkedListNode(node);
				moveToFront(node);
			}
			return node.value;
		}
		return -1;

	}

	public void moveToFront(LinkedListNode node) {
		if (head != null) {
			head.prev = node;
			node.next = head;
			head = node;
		}
	}

	public void set(int key, int value) {
		int preValue = get(key);
		if (preValue != -1) {
			if (preValue != value) {
				CacheMap.get(key).value= value;
			}
			return;
		}

		if (CacheMap.size() >= Capacity) {
			CacheMap.remove(tail.key);
			removeLinkedListNode(tail);

		}
		LinkedListNode node = new LinkedListNode(key, value);
		if (tail == null)
			tail = node;

		if (head != null) {
			head.prev = node;
			node.next = head;
		}
		head = node;

		CacheMap.put(key, head);

	}

	private void removeLinkedListNode(LinkedListNode node) {
		if (node == null)
			return;

		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;

		if (node == head)
			head = head.next;
		if (node == tail)
			tail = tail.prev;
	}

	public class LinkedListNode {
		public int key, value;
		public LinkedListNode prev;
		public LinkedListNode next;

		LinkedListNode(int Key, int Value) {
			this.key = Key;
			this.value = Value;
			prev = null;
			next = null;
		}

	}

}
