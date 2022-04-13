## SinglyLinkedList Efficiency:

As new nodes can be dynamically added (cf. arrays which require contiguous memory) there is no need to "resize" a linked list. This of course comes at the time cost of accessing non adjacent memory locations.

### Time Complexities SinglyLinkedList With Tail Sentinel (pointer):

addToFront(T data)  O(1)
addToBack(T data)   O(1)
removeFromFront()   O(1)
removeFromBack()    O(1)
remove(T data)      O(n)
