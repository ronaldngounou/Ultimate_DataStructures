from LinkedLists import *
from Node import *

l1 = LinkedList(Node(4))
l1.addFirst(5)

l1.addLast(6)
l1.addLast(8)
l1.addLast(10)

print(l1.indexOf(7))

print(l1.contains(6))

l1.removeFirst()

l1.removeLast()
