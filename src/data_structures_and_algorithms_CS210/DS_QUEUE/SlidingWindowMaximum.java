package data_structures_and_algorithms_CS210.DS_QUEUE;

public class SlidingWindowMaximum {

        // How to compute max in the Queue? - MaxQueue to return maximum
        // 2 Stacks, replace each stack with a MaxStack

        class MaxStack {
            // void push(int val) pushes element val onto the stack
            // void pop() removes the element on the top of the stack
            // int top() gets the top element of the stack
            // int getMin() retrieves the min element in the stack
            private Node head;

            public void push(int x) {
                if (head == null)
                    head = new Node(x, x, null);
                else
                    head = new Node(x, Math.max(x, head.max), head);
            }

            public void pop() {
                head = head.next;
            }

            public int top() {
                return head.val;
            }

            public int getMax() {
                return head.max;
            }

            public boolean empty() {
                return head == null;
            }

            private class Node { // singly-linked list
                int val;
                int max;
                Node next;

                private Node(int val, int max, Node next) {
                    this.val = val;
                    this.max = max;
                    this.next = next;
                }
            }
        }

        class MaxQueue {
            MaxStack input = new MaxStack();
            MaxStack output = new MaxStack();

            public void push(int x) {
                input.push(x);
            }

            // Amortized O(1)
            public int pop() {
                int x = front();
                output.pop();
                return x;
            }

            // Amortized O(1)
            public int front() { // this is the front of the Queue
                if (output.empty()) {
                    while (!input.empty()) {
                        int x = input.top(); // to get the element first
                        input.pop(); // then remove above element from the 1st stack
                        output.push(x); // pop operation returns removed element, now push it into output Stack
                    }
                }
                return output.top(); // in queue peek called top
            }

            public boolean empty() {
                return input.empty() && output.empty();
            }

            public int getMax() {
                int max = (int) -1e5; // set to something that cannot be max at all 10^5
                if (!input.empty()) {
                    max = Math.max(max, input.getMax());
                }
                if (!output.empty()) {
                    max = Math.max(max, output.getMax());
                }
                return max;
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] results = new int[n - k + 1];

            MaxQueue maxQueue = new MaxQueue();

            for (int i = 0; i < k; i++) { // i = 0..k-1
                maxQueue.push(nums[i]);
            }

            results[0] = maxQueue.getMax();
            for (int i = k; i < n; i++) {
                maxQueue.pop();
                maxQueue.push(nums[i]);
                results[i - k + 1] = maxQueue.getMax();
            }

            return results;
        }
    }

