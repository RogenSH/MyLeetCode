/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.29%)
 * Likes:    310
 * Dislikes: 0
 * Total Accepted:    24.7K
 * Total Submissions: 55.3K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 ); * 2 为缓存容量 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1); // 返回  1
  *cache.put(3,3); // 该操作会使得密钥 2 作废
  *cache.get(2); // 返回 -1 (未找到)
  *cache.put(4,4); // 该操作会使得密钥 1 作废
  *cache.get(1); // 返回 -1 (未找到)
  *cache.get(3); // 返回  3
  *cache.get(4); // 返回  4
  ***/

// @lc code=start
import java.util.HashMap;
import java.util.Map;

/// 需要确定，put 操作中如果 key 值重复时的操作，目前解法为覆盖为新的 value
class LRUCache {

  Map<Integer, Node> mCacheMap;
  int mCapacity;
  Node head;
  Node tail;

  public LRUCache(int capacity) {
    mCapacity = capacity;
    mCacheMap = new HashMap<>(capacity);
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  /// 查找并获取对应的值，同时将优先级提高
  public int get(int key) {
    Node node = mCacheMap.get(key);
    if (node == null) {
      return -1;
    }
    // if (mCacheMap.containsKey(key)) {
    //   Node node = mCacheMap.get(key);
      moveToHead(node);
      return node.value;
    // }
    // return -1;
  }

  void insertToHead(Node node) {
    Node oldFirst = getFirstNode();
    head.next = node;
    oldFirst.prev = node;
    node.next = oldFirst;
    node.prev = head;
  }

  void moveToHead(Node node) {
    if (node != getFirstNode()) {
      removeNode(node);
      insertToHead(node);
    }
  }

  Node getFirstNode() {
    return head.next;
  }

  /// todo: 复用 [removeNode]
  /// 【考虑边界情况：tail.prev.prev 是 null，即只有两项】
  Node removeLastNode() {
    Node last = tail.prev;
    removeNode(last);
    // Node temp = tail.prev.prev;
    // temp.next = tail;
    // tail.prev = temp;
    return last;
  }

  void removeNode(Node node) {
    Node current = tail;
    while (current != null) {
      if (node == current) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return;
      }
      current = current.prev;
    }
  }

  /****
   * 1. 判断是否重复 key 2. 判断是否超出容量
   */
  public void put(int key, int value) {
    if (mCacheMap.containsKey(key)) {
      Node existNode = mCacheMap.get(key);
      existNode.value = value;
      moveToHead(existNode);
      mCacheMap.replace(key, existNode);
    } else {
      Node newNode = new Node(key, value);
      if (mCacheMap.size() >= mCapacity) {
        Node removedNode = removeLastNode();
        mCacheMap.remove(removedNode.key);
      }
      mCacheMap.put(key, newNode);
      insertToHead(newNode);
    }
  }

  class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
