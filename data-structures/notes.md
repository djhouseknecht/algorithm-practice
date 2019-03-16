# Notes on Data Structures

### Definitions

_**FIFO**: First In, First Out_

_**LIFO**: Last In, First Out_

### Data Structure Performance
| | Acess | Search | Insert | Delete | 
| - | - | - | - | - | 
| **Stack** | *O(n)* | *O(n)* | *O(1)* | *O(1)* |
| **Queue** | *O(n)* | *O(n)* | *O(1)* | *O(1)* |
| **Linked List** | *O(n)* | *O(n)* | *O(1)* | *O(1)* |
| **Hash Table** | *O(1)* | *O(1)* | *O(1)* | *O(1)* |
| **Binary Tree** | *O(log n)* | *O(log n)* | *O(log n)* | *O(log n)* |

Useful repository: https://github.com/dlbunker/big-o-performance from [Dan Bunker](https://github.com/dlbunker/)

## Stack

- _push_: Put an item on the stack _`O(1)`_
- _pop_: Remove the top item _`O(1)`_
- _search_: Look for an item _`O(n)`_
- _access_: Find the item, then pop everything on top of it _`O(n)`_

> Java provides two main classes for stacks. The `Stack<E>` and `Deque<E>` classes. Stacks are thread safe making them slower whereas `Deque`s are not thread safe making them faster. 

## Queue

- _enQueue_: Add an item to the queue _`O(1)`_
- _deQueue_: Remove the next item in the queue _`O(1)`_
- _Search_: Look for an item _`O(n)`_
- _Access_: Access an item in the queue _`O(n)`_

## List

- _add_: Add an item to the list _`O(1)`_
- _remove_: Remove an item from the top of the list _`O(1)`_
- _insert_: Insert an item to the list at a specific index _`O(n)`_
- _removeAt_: Remove an item at a specific index _`O(n)`_
- _find_: Find a specific item _`O(n)`_
- _get_: Get an item at a specific index _`O(n)`_

## Hash

Hashes are sets of items. They are not ordered, but presents all the data to you. A hash is a `map`. `Arrays` are kind of like hashes. 

*Keys:* You need to take your key and turn it into an `int` value. Use Java's `public int hashCode()`.

## Tree

Trees can be a **Parent**, **Child**, or **Both**. A binary tree has a **left** and a **right** property. They are not required to have a value in the branches. 

> Trees have an *`O(log n)`*