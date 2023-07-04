class LinkedList:
    class Node:
        def __init__(self, val=0, next=None):
            self.val = val
            self.next = next

    def __init__(self, head=None, tail=None):
        self.head = head 
        self.tail = tail 

    def addFirst(self, element):
        node = self.Node(element)
        if (self.head == None):
            self.head = node 
            self.tail = node
        else:
            node.next = self.head
            self.head = node 
    
    def addLast(self, element):
        node = self.Node(element)
        if (self.head == None):
            self.tail = node 
            self.head = node
        else:
            self.tail.next = node 
            self.tail = node 

    def indexOf(self, element):
        index = 0
        current = self.head 
        while current:
            if (current.val == element):
                return index 
            else:
                current = current.next
                index += 1
        
        return -1

    def contains(self, element):
        current = self.head
        while current:
            if (current.val == element):
                return True
            elif (element == self.tail.val):
                return True
            current = current.next
        return False 
    
    def removeFirst(self):

        if (self.head == None):
            raise LookupError("Empty linked list")
        
        if (self.head == self.tail):
            self.head = self.tail = None

        second = self.head.next 
        self.head = None 
        self.head = second 
        
    def removeLast(self):

        previous = self.getPrevious()
        self.tail = previous
        self.tail.next = None 
    
    def getPrevious(self):
        current = self.head;
        while current:
            if (current.next == self.tail):
                return current
            current = current.next
        return None 
        
    

                




    

        
    