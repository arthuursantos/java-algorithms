package org.example.grokking_algorithms.chapter3;

public class _01_call_stack {

    // 3.1 Suppose I show you a call stack like this.
    // What information can you give me, just based on this call stack?
    // Now let’s see the call stack in action with a recursive function.
    // ... greet(name = maggie) foi chamada primeiro, e então chamou greet2(name = maggie)
    // greet2() vai ser executada, e em seguida greet().

    // Suppose you accidentally write a recursive function that runs
    // forever. As you saw, your computer allocates memory on the
    // stack for each function call. What happens to the stack when your
    // recursive function runs forever?
    // ...  a função recursiva é encerrada com um erro de out of memory

    public static int recursiveSum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + recursiveSum(arr, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(recursiveSum(new int[]{1, 3, 0, 100, 23}, 0));
    }

}
